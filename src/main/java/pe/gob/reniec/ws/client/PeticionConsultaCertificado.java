package pe.gob.reniec.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para peticionConsultaCertificado complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="peticionConsultaCertificado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accessToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nuDniConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nuRucUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "peticionConsultaCertificado", propOrder = {"accessToken", "nuDniConsulta", "nuRucUsuario"})
public class PeticionConsultaCertificado {

    protected String accessToken;
    protected String nuDniConsulta;
    protected String nuRucUsuario;

    /**
     * Obtiene el valor de la propiedad accessToken.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Define el valor de la propiedad accessToken.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * Obtiene el valor de la propiedad nuDniConsulta.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNuDniConsulta() {
        return nuDniConsulta;
    }

    /**
     * Define el valor de la propiedad nuDniConsulta.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNuDniConsulta(String value) {
        this.nuDniConsulta = value;
    }

    /**
     * Obtiene el valor de la propiedad nuRucUsuario.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNuRucUsuario() {
        return nuRucUsuario;
    }

    /**
     * Define el valor de la propiedad nuRucUsuario.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNuRucUsuario(String value) {
        this.nuRucUsuario = value;
    }

}
