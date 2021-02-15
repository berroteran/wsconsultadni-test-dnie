package pe.gob.reniec.ws.authorization;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

/**
 * Interfaz y clases de ayuda que permiten agrupar los parametros del cliente OAUTH2 y HTTP CLIENT
 */
public interface DnieAuthService {

//    String getStartAsyncAuthorizeUrl(String oauthServer);

    String getAuthorizationCodeGrantUrl(String oauthServer, String clientId, String redirectUri, String scope, String state);

    String getAccessToken(String oauthServer, String code, String clientId, String secret, String redirectUri) throws Exception;

    String getAccessToken(String code) throws Exception;

    String extractDniFromAccessToken(String accessToken, String oauthServer) throws Exception;

    String extractDniFromAccessToken(String accessToken) throws CertificateException, UnrecoverableKeyException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, InvalidKeySpecException;


    /**
     * Clase que permite almacenar los parametros del cliente OAUTH2
     */
    class OAuthConfiguration {
        private String server;
        private String clientId;
        private String secret;
        private String scope;
        private String redirectUri;

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getRedirectUri() {
            return redirectUri;
        }

        public void setRedirectUri(String redirectUri) {
            this.redirectUri = redirectUri;
        }

        public boolean isValid() {
            return server != null && !server.isEmpty() && clientId != null && !clientId.isEmpty() && secret != null && !secret.isEmpty() && scope != null && !scope.isEmpty() && redirectUri != null && !redirectUri.isEmpty();
        }

        @Override
        public String toString() {
            return "{" + "\"server\":\"" + (server == null ? "" : server) + "\"" + ",\"clientId\":\"" + (clientId == null ? "" : clientId) + "\"" + ",\"secret\":\"" + (secret == null ? "" : secret) + "\"" + ",\"scope\":\"" + (scope == null ? "" : scope) + "\"" + ",\"redirectUri\":\"" + (redirectUri == null ? "" : redirectUri) + "\"" + "}";
        }
    }

    /**
     * Clase que permite almacenar los parametros para el cliente HTTP, con certificado en el cliente
     */
    class HttpClientConfiguration {
        private String identityKeyStore;
        private String identityKeyStorePassword;
        private String identityCertificateAlias;
        private String identityCertificatePrivateKeyPassword;
        private String trustKeyStore;
        private String trustKeyStorePassword;

        public String getIdentityKeyStore() {
            return identityKeyStore;
        }

        public void setIdentityKeyStore(String identityKeyStore) {
            this.identityKeyStore = identityKeyStore;
        }

        public String getIdentityKeyStorePassword() {
            return identityKeyStorePassword;
        }

        public void setIdentityKeyStorePassword(String identityKeyStorePassword) {
            this.identityKeyStorePassword = identityKeyStorePassword;
        }

        public String getIdentityCertificateAlias() {
            return identityCertificateAlias;
        }

        public void setIdentityCertificateAlias(String identityCertificateAlias) {
            this.identityCertificateAlias = identityCertificateAlias;
        }

        public String getIdentityCertificatePrivateKeyPassword() {
            return identityCertificatePrivateKeyPassword;
        }

        public void setIdentityCertificatePrivateKeyPassword(String identityCertificatePrivateKeyPassword) {
            this.identityCertificatePrivateKeyPassword = identityCertificatePrivateKeyPassword;
        }

        public String getTrustKeyStore() {
            return trustKeyStore;
        }

        public void setTrustKeyStore(String trustKeyStore) {
            this.trustKeyStore = trustKeyStore;
        }

        public String getTrustKeyStorePassword() {
            return trustKeyStorePassword;
        }

        public void setTrustKeyStorePassword(String trustKeyStorePassword) {
            this.trustKeyStorePassword = trustKeyStorePassword;
        }

        public boolean isValid() {
            return identityKeyStore != null && !identityKeyStore.isEmpty() && identityKeyStorePassword != null && !identityKeyStorePassword.isEmpty() && identityCertificateAlias != null && !identityCertificateAlias.isEmpty() && identityCertificatePrivateKeyPassword != null && !identityCertificatePrivateKeyPassword.isEmpty() && trustKeyStore != null && !trustKeyStore.isEmpty() && trustKeyStorePassword != null && !trustKeyStorePassword.isEmpty();
        }

        @Override
        public String toString() {
            return "{" + "\"identityKeyStore\":\"" + (identityKeyStore == null ? "" : identityKeyStore) + "\"" + ",\"identityKeyStorePassword\":\"" + (identityKeyStorePassword == null ? "" : identityKeyStorePassword) + "\"" + ",\"identityCertificateAlias\":\"" + (identityCertificateAlias == null ? "" : identityCertificateAlias) + "\"" + ",\"identityCertificatePrivateKeyPassword\":\"" + (identityCertificatePrivateKeyPassword == null ? "" : identityCertificatePrivateKeyPassword) + "\"" + ",\"trustKeyStore\":\"" + (trustKeyStore == null ? "" : trustKeyStore) + "\"" + ",\"trustKeyStorePassword\":\"" + (trustKeyStorePassword == null ? "" : trustKeyStorePassword) + "\"" + "}";
        }
    }
}
