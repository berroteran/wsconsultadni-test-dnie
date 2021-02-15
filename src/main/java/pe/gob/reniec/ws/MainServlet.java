package pe.gob.reniec.ws;

import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import pe.gob.reniec.ws.authorization.AuthUser;
import pe.gob.reniec.ws.authorization.DnieAuthService;
import pe.gob.reniec.ws.authorization.DnieAuthServiceBean;
import pe.gob.reniec.ws.client.PeticionConsultaCertificado;
import pe.gob.reniec.ws.client.ResultadoConsulta;
import pe.gob.reniec.ws.client.SRELServiceService;
import pe.gob.reniec.ws.client.SimpleConsultaDniService;

import javax.net.ssl.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

/**
 * Permite inicializar el flujo de autorización y envio de petición hacia el webservice con los parámetros AccessToken, RUC, Dni consultado.
 */
public class MainServlet extends HttpServlet {
    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(getClass());

    private DnieAuthService dnieAuthService;
    private String webserviceUrl;
    private String redirectUri;
    private String oauthServer;
    private String oAuthClientId;

    private Gson gson = new Gson();

    private void initialize() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");

        Properties properties = new Properties();

        properties.load(input);

        // initializing required parameters
        DnieAuthService.OAuthConfiguration oAuthConfiguration = new DnieAuthService.OAuthConfiguration();
        oAuthConfiguration.setServer(properties.getProperty("oAuth.server"));
        oAuthConfiguration.setClientId(properties.getProperty("oAuth.clientId"));
        oAuthConfiguration.setSecret(properties.getProperty("oAuth.secret"));
        oAuthConfiguration.setScope(properties.getProperty("oAuth.scope"));
        oAuthConfiguration.setRedirectUri(properties.getProperty("oAuth.redirectUri"));

        DnieAuthService.HttpClientConfiguration httpClientConfiguration = new DnieAuthService.HttpClientConfiguration();
        httpClientConfiguration.setIdentityKeyStore(properties.getProperty("httpClient.identityKeyStore"));
        httpClientConfiguration.setIdentityKeyStorePassword(properties.getProperty("httpClient.identityKeyStorePassword"));
        httpClientConfiguration.setIdentityCertificateAlias(properties.getProperty("httpClient.identityCertificateAlias"));
        httpClientConfiguration.setIdentityCertificatePrivateKeyPassword(properties.getProperty("httpClient.identityCertificatePrivateKeyPassword"));
        httpClientConfiguration.setTrustKeyStore(properties.getProperty("httpClient.trustKeyStore"));
        httpClientConfiguration.setTrustKeyStorePassword(properties.getProperty("httpClient.trustKeyStorePassword"));

        LOG.info("using HttpClientConfiguration: " + httpClientConfiguration);
        LOG.info("using OAuthConfiguration: " + oAuthConfiguration);
        dnieAuthService = new DnieAuthServiceBean(oAuthConfiguration, httpClientConfiguration);

        webserviceUrl = properties.getProperty("application.wsdl");
        redirectUri = oAuthConfiguration.getRedirectUri();
        oauthServer = oAuthConfiguration.getServer();
        oAuthClientId = oAuthConfiguration.getClientId();
    }

    private AuthUser authcallback(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        LOG.info("Obteniendo AccessToken");
        initialize();
        String code = req.getParameter("code");
        String state = req.getParameter("state");
        LOG.info("code={}", code);
        LOG.info("state={}", state);

        //
        // the THIRD STEP for the Authorization Code Grant Flow:
        // this application will request an access token from the authorization server
        // (see https://tools.ietf.org/id/draft-ietf-oauth-v2-31.html#grant-code)
        //
        // script.sh
        //
        // oauth_server='https://dnieauth.reniec.gob.pe/sso'
        // client_id=<CLIENTID>
        // secret=<SECRET>
        // scope=<SCOPE>
        // redirect_uri=<URL>
        // # exchange the authorization code for a JWT token
        // curl -u $client_id:$secret -d grant_type='authorization_code&code='$code'&redirect_uri='$redirect_uri -X POST $oauth_server/oauth/token
        //
        String accessToken;
        accessToken = dnieAuthService.getAccessToken(code);
        LOG.info("accessToken obtenido correctamente, accessToken='{}'", accessToken);

        // IMPORTANT. the access token is **confidential** and must be decoded and verified in the server
        String dni;
        dni = dnieAuthService.extractDniFromAccessToken(accessToken);
        // dni = dnieAuthService.extractDniFromAccessToken(accessToken, dnieAuthServer);
        LOG.info("dni autenticado: {}", dni);

        return new AuthUser(dni, accessToken);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        initialize();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        req.setAttribute("dnieAuthRedirectUri", redirectUri);
        req.setAttribute("oauthServer", oauthServer);
        req.setAttribute("oAuthClientId", oAuthClientId);
        req.setAttribute("accessToken", req.getSession().getAttribute("accessToken"));
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String path = req.getRequestURI().substring(req.getContextPath().length() + 1);
        if ("accessToken.do".equals(path)) {
            try {
                accessToken(req, resp);
            } catch (Exception e) {
                LOG.error("Error", e);
            }
        } else if ("consultar.do".equals(path)) {
            try {
                consultar(req, resp);
            } catch (Exception e) {
                LOG.error("Error", e);
            }
        }
    }

    private void accessToken(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        LOG.info("Inicializando parametros de properties.");
        initialize();// initialize properties

        // accessToken in session
        HttpSession httpSession = req.getSession();
        String accessToken = (String) httpSession.getAttribute("accessToken");
        if (accessToken == null || accessToken.length() == 0) {
            AuthUser authUser = authcallback(req, resp);
            accessToken = authUser.getAccessToken();
            httpSession.setAttribute("accessToken", accessToken);
        }

        // accessToken should only get on the server
        String json = this.gson.toJson(accessToken);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }

    private void consultar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        initialize();// initialize properties

        // accessToken in session
        HttpSession httpSession = req.getSession();
        String accessToken = req.getParameter("accessToken");

        SRELServiceService consultaDniService = crearCliente(webserviceUrl);
        PeticionConsultaCertificado p = new PeticionConsultaCertificado();
        p.setNuDniConsulta(req.getParameter("nuDniConsulta"));
        p.setNuRucUsuario(req.getParameter("nuRucUsuario"));

        if (accessToken != null && accessToken.length() > 0) {
            p.setAccessToken(accessToken);
        } else {
            p.setAccessToken((String) httpSession.getAttribute("accessToken"));
        }

        ResultadoConsulta resultadoConsulta = consultaDniService.consultarCertificado(p);

        String json = this.gson.toJson(resultadoConsulta);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }

    private SRELServiceService crearCliente(String endpointUrl) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        SRELServiceService srelServiceService;
        URL wsdl = this.getClass().getResource("/ConsultaDniService.wsdl");

        SimpleConsultaDniService c = new SimpleConsultaDniService(wsdl);
        srelServiceService = c.getSRELServiceServicePort();
        BindingProvider bindingProvider = (BindingProvider) srelServiceService;

        // se establece el SSLSocketFactory
        bindingProvider.getRequestContext().put("com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory", getSSLSocketFactory());

        System.out.println("endpointUrl = " + endpointUrl);
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

        return srelServiceService;
    }

    // obtiene SSLSocketFactory
    private SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableKeyException, KeyManagementException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore myKeyStore = KeyStore.getInstance("JKS");
        // identidad
        myKeyStore.load(MainServlet.class.getClassLoader().getResourceAsStream("20295613620.wsconsultadniclient.jks"), "Reniec01".toCharArray());
        keyManagerFactory.init(myKeyStore, "Reniec01".toCharArray());

        // only development enviroment building truststore
        TrustManager[] trustAllManager = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                // trust all!
                return new X509Certificate[0];
                // trust selected root
                // return new X509Certificate[]{(X509Certificate) certificate};
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        final SSLContext sslContext = SSLContext.getInstance("TLS");

        sslContext.init(keyManagerFactory.getKeyManagers(), trustAllManager, new SecureRandom());

        final SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);

        return socketFactory;
    }

}