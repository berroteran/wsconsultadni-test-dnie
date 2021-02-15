package pe.gob.reniec.ws.authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.PrivateKeyDetails;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.SSLContexts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAKey;
import java.security.spec.InvalidKeySpecException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que permite obtener el accessToken del servicio de autorización: https://dnieauth.reniec.gob.pe/sso
 * enviando el parametro Code Grant
 */
public class DnieAuthServiceBean implements DnieAuthService {

    private static final Logger log = LogManager.getLogger(DnieAuthServiceBean.class);

    private HttpClient httpClient;
    private HttpClientConfiguration httpClientConfiguration;
    private OAuthConfiguration oAuthConfiguration;

    private String authorizationServerPublicKey;

    public DnieAuthServiceBean(OAuthConfiguration oAuthConfiguration, HttpClientConfiguration httpClientConfiguration) {
        if (httpClientConfiguration == null || !httpClientConfiguration.isValid()) {
            throw new IllegalStateException("dnieAuthServiceConfiguration");
        }
        this.oAuthConfiguration = oAuthConfiguration;
        this.httpClientConfiguration = httpClientConfiguration;
    }

    private String getTokenKeyUrl(String oauthServer) {
        return MessageFormat.format("{0}/oauth/token_key", oauthServer);
    }

    @Override
    public String getAuthorizationCodeGrantUrl(String oauthServer, String clientId, String redirectUri, String scope, String state) {
        if (state == null || state.isEmpty()) {
            return MessageFormat.format("{0}/oauth/authorize?client_id={1}&redirect_uri={2}&response_type=code&scope={3}", oauthServer, clientId, redirectUri, scope);
        } else {
            return MessageFormat.format("{0}/oauth/authorize?client_id={1}&redirect_uri={2}&response_type=code&scope={3}&state={4}", oauthServer, clientId, redirectUri, scope, state);
        }
    }

    //
    // we use Apache HttpClient but we could have used Spring's RestTemplate too, or whatever library because what we are trying to emulate is the next script:
    //
    //     oauth_server='https://dnieauth.reniec.gob.pe/sso'
    //     client_id=<CLIENTID>
    //     secret=<SECRET>
    //     scope=<SCOPE>
    //     redirect_uri=<URL>
    //     # exchange the authorization code for a JWT token
    //     curl -u $client_id:$secret -d grant_type='authorization_code&code='$code'&redirect_uri='$redirect_uri -X POST $oauth_server/oauth/token
    //
    @Override
    public String getAccessToken(String oauthServer, String code, String clientId, String secret, String redirectUri) throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String endpointUrl = oauthServer + "/oauth/token";
        log.info("retrieving token from {} for code {}", endpointUrl, code);

        HttpClient client = getHttpClient();

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.STRICT);

        ContentBody grantTypeBody = new StringBody("authorization_code", ContentType.TEXT_PLAIN);
        builder.addPart("grant_type", grantTypeBody);

        ContentBody codeBody = new StringBody(code, ContentType.TEXT_PLAIN);
        builder.addPart("code", codeBody);

        ContentBody redirectUriBody = new StringBody(redirectUri, ContentType.TEXT_PLAIN);
        builder.addPart("redirect_uri", redirectUriBody);

        HttpEntity multipart = builder.build();
        HttpPost post = new HttpPost(endpointUrl);
        post.addHeader("Authorization", "Basic " + DatatypeConverter.printBase64Binary((clientId + ":" + secret).getBytes(Charset.forName("utf-8"))));
        post.setEntity(multipart);

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != org.apache.http.HttpStatus.SC_OK) {
            throw new RuntimeException(endpointUrl + " failed with code: " + statusCode + " " + response.getStatusLine().getReasonPhrase());
        }

        HttpEntity responseEntity = response.getEntity();
        InputStream is = responseEntity.getContent();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        IOUtils.copy(is, baos);

        String json = new String(baos.toByteArray(), Charset.defaultCharset());
        is.close();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> result = new HashMap<String, Object>();
        result = mapper.readValue(json, new TypeReference<Map<String, String>>() {
        });

        log.info("access_token=={}", result.get("access_token").toString());
        return result.get("access_token").toString();
    }

    @Override
    public String getAccessToken(String code) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException {
        return getAccessToken(oAuthConfiguration.getServer(), code, oAuthConfiguration.getClientId(), oAuthConfiguration.getSecret(), oAuthConfiguration.getRedirectUri());
    }

    @Override
    public String extractDniFromAccessToken(String accessToken, String oauthServer) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException, UnrecoverableKeyException, CertificateException, KeyStoreException, KeyManagementException {

        String authorizationServerPublicKey = getAuthorizationServerPublicKey(getTokenKeyUrl(oauthServer));

        RSAKey publicKey = (RSAKey) PemUtils.readPublicKey(authorizationServerPublicKey, "RSA");
        Algorithm algorithm = Algorithm.RSA256(publicKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(accessToken);
        // fields:
        // decodedJWT.getExpiresAt()
        // decodedJWT.getId()
        // decodedJWT.getClaim("client_id").asString()
        // decodedJWT.getClaim("scope").asList(String.class)
        // decodedJWT.getClaim("authorities").asList(String.class)
        // decodedJWT.getClaim("user_name").asString()
        String userNameClaim = decodedJWT.getClaim("user_name").asString();
        log.trace("decoded access token for: {}", userNameClaim);
        return decodedJWT.getClaim("nu_dni").asString();
    }

    @Override
    public String extractDniFromAccessToken(String accessToken) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, InvalidKeySpecException {
        return extractDniFromAccessToken(accessToken, oAuthConfiguration.getServer());
    }

    // we use Apache HttpClient
    private String getAuthorizationServerPublicKey(String endpointUrl) throws IOException, UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        if (authorizationServerPublicKey == null) {
            HttpClient client = getHttpClient();
            HttpGet get = new HttpGet(endpointUrl);
            HttpResponse response = client.execute(get);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != org.apache.http.HttpStatus.SC_OK) {
                throw new RuntimeException(endpointUrl + " failed with code: " + statusCode);
            }

            HttpEntity responseEntity = response.getEntity();
            InputStream is = responseEntity.getContent();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            IOUtils.copy(is, baos);
            is.close();

            String json = new String(baos.toByteArray(), Charset.defaultCharset());

            log.info("JSON={}", json);

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> result = new HashMap<String, Object>();
            result = mapper.readValue(json, new TypeReference<Map<String, String>>() {
            });
            log.info("result={}", result);

            authorizationServerPublicKey = result.get("value").toString();

            log.info("authorizationServerPublicKey: {}", authorizationServerPublicKey);
        }
        return authorizationServerPublicKey;
    }

    private HttpClient getHttpClient() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException, KeyManagementException {
//        if (httpClient == null) {
        KeyStore identityKeyStore = KeyStore.getInstance("jks");
        identityKeyStore.load(DnieAuthServiceBean.class.getClassLoader().getResourceAsStream(httpClientConfiguration.getIdentityKeyStore()), httpClientConfiguration.getIdentityKeyStorePassword().toCharArray());

        KeyStore trustKeyStore = KeyStore.getInstance("jks");
        trustKeyStore.load(DnieAuthServiceBean.class.getClassLoader().getResourceAsStream(httpClientConfiguration.getTrustKeyStore()), httpClientConfiguration.getTrustKeyStorePassword().toCharArray());

        SSLContext sslContext = SSLContexts.custom()
                // load identity keystore
                .loadKeyMaterial(identityKeyStore, httpClientConfiguration.getIdentityCertificatePrivateKeyPassword().toCharArray(), new PrivateKeyStrategy() {
                    @Override
                    public String chooseAlias(Map<String, PrivateKeyDetails> aliases, Socket socket) {
                        return httpClientConfiguration.getIdentityCertificateAlias();
                    }
                })
                // load trust keystore
                //.loadTrustMaterial(trustKeyStore, null)
                .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1.2", "TLSv1.1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());


        httpClient = HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        return httpClient;
    }

    /*@Override
    public String getStartAsyncAuthorizeUrl(String oauthServer) {
        return MessageFormat.format("{0}/startAsyncAuthorize", oauthServer);
    }*/

}
