package pe.gob.reniec.ws.authorization;

public class AuthUser {
    private String dni;
    private String accessToken;

    public AuthUser() {
    }

    public AuthUser(String dni, String accessToken) {
        this.dni = dni;
        this.accessToken = accessToken;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
