package pe.gob.reniec.ws.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para datosPersona complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType name="datosPersona">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenombres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apellidoCasada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="digitoVerificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foto" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="restriccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoContinenteDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoPaisDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDepartamentoDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoProvinciaDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDistritoDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="continenteDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departamentoDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provinciaDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distritoDomicilio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccionCompleta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenombreMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellidoMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellidoMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prenombrePadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellidoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellidoPadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="donacionOrgano" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaInscripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaEmision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaCaducidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="continenteNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paisNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="departamentoNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provinciaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distritoNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoContinenteNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoPaisNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDepartamentoNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoProvinciaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDistritoNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroDocumentoAdjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentoAdjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoDocumentoAdjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoNivelEducativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nivelEducativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoVotacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grupoVotacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosPersona", propOrder = {"dni", "prenombres", "primerApellido", "apellidoCasada", "segundoApellido", "fechaNacimiento", "genero", "estatura", "estadoCivil", "codigoEstadoCivil", "digitoVerificacion", "foto", "restriccion", "codigoContinenteDomicilio", "codigoPaisDomicilio", "codigoDepartamentoDomicilio", "codigoProvinciaDomicilio", "codigoDistritoDomicilio", "continenteDomicilio", "paisDomicilio", "departamentoDomicilio", "provinciaDomicilio", "distritoDomicilio", "direccionCompleta", "prenombreMadre", "primerApellidoMadre", "segundoApellidoMadre", "prenombrePadre", "primerApellidoPadre", "segundoApellidoPadre", "donacionOrgano", "fechaInscripcion", "fechaEmision", "fechaCaducidad", "continenteNacimiento", "paisNacimiento", "departamentoNacimiento", "provinciaNacimiento", "distritoNacimiento", "codigoContinenteNacimiento", "codigoPaisNacimiento", "codigoDepartamentoNacimiento", "codigoProvinciaNacimiento", "codigoDistritoNacimiento", "numeroDocumentoAdjunto", "documentoAdjunto", "codigoDocumentoAdjunto", "codigoNivelEducativo", "nivelEducativo", "codigoVotacion", "grupoVotacion"})
public class DatosPersona {

    protected String dni;
    protected String prenombres;
    protected String primerApellido;
    protected String apellidoCasada;
    protected String segundoApellido;
    protected String fechaNacimiento;
    protected String genero;
    protected String estatura;
    protected String estadoCivil;
    protected String codigoEstadoCivil;
    protected String digitoVerificacion;
    protected byte[] foto;
    protected String restriccion;
    protected String codigoContinenteDomicilio;
    protected String codigoPaisDomicilio;
    protected String codigoDepartamentoDomicilio;
    protected String codigoProvinciaDomicilio;
    protected String codigoDistritoDomicilio;
    protected String continenteDomicilio;
    protected String paisDomicilio;
    protected String departamentoDomicilio;
    protected String provinciaDomicilio;
    protected String distritoDomicilio;
    protected String direccionCompleta;
    protected String prenombreMadre;
    protected String primerApellidoMadre;
    protected String segundoApellidoMadre;
    protected String prenombrePadre;
    protected String primerApellidoPadre;
    protected String segundoApellidoPadre;
    protected String donacionOrgano;
    protected String fechaInscripcion;
    protected String fechaEmision;
    protected String fechaCaducidad;
    protected String continenteNacimiento;
    protected String paisNacimiento;
    protected String departamentoNacimiento;
    protected String provinciaNacimiento;
    protected String distritoNacimiento;
    protected String codigoContinenteNacimiento;
    protected String codigoPaisNacimiento;
    protected String codigoDepartamentoNacimiento;
    protected String codigoProvinciaNacimiento;
    protected String codigoDistritoNacimiento;
    protected String numeroDocumentoAdjunto;
    protected String documentoAdjunto;
    protected String codigoDocumentoAdjunto;
    protected String codigoNivelEducativo;
    protected String nivelEducativo;
    protected String codigoVotacion;
    protected String grupoVotacion;

    /**
     * Obtiene el valor de la propiedad dni.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDni(String value) {
        this.dni = value;
    }

    /**
     * Obtiene el valor de la propiedad prenombres.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrenombres() {
        return prenombres;
    }

    /**
     * Define el valor de la propiedad prenombres.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrenombres(String value) {
        this.prenombres = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellido.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Define el valor de la propiedad primerApellido.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoCasada.
     *
     * @return possible object is
     * {@link String }
     */
    public String getApellidoCasada() {
        return apellidoCasada;
    }

    /**
     * Define el valor de la propiedad apellidoCasada.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setApellidoCasada(String value) {
        this.apellidoCasada = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellido.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Define el valor de la propiedad segundoApellido.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFechaNacimiento(String value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad genero.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Define el valor de la propiedad genero.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGenero(String value) {
        this.genero = value;
    }

    /**
     * Obtiene el valor de la propiedad estatura.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEstatura() {
        return estatura;
    }

    /**
     * Define el valor de la propiedad estatura.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEstatura(String value) {
        this.estatura = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoCivil.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Define el valor de la propiedad estadoCivil.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEstadoCivil(String value) {
        this.estadoCivil = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoEstadoCivil.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoEstadoCivil() {
        return codigoEstadoCivil;
    }

    /**
     * Define el valor de la propiedad codigoEstadoCivil.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoEstadoCivil(String value) {
        this.codigoEstadoCivil = value;
    }

    /**
     * Obtiene el valor de la propiedad digitoVerificacion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    /**
     * Define el valor de la propiedad digitoVerificacion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDigitoVerificacion(String value) {
        this.digitoVerificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad foto.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Define el valor de la propiedad foto.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setFoto(byte[] value) {
        this.foto = value;
    }

    /**
     * Obtiene el valor de la propiedad restriccion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRestriccion() {
        return restriccion;
    }

    /**
     * Define el valor de la propiedad restriccion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRestriccion(String value) {
        this.restriccion = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoContinenteDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoContinenteDomicilio() {
        return codigoContinenteDomicilio;
    }

    /**
     * Define el valor de la propiedad codigoContinenteDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoContinenteDomicilio(String value) {
        this.codigoContinenteDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPaisDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoPaisDomicilio() {
        return codigoPaisDomicilio;
    }

    /**
     * Define el valor de la propiedad codigoPaisDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoPaisDomicilio(String value) {
        this.codigoPaisDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDepartamentoDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoDepartamentoDomicilio() {
        return codigoDepartamentoDomicilio;
    }

    /**
     * Define el valor de la propiedad codigoDepartamentoDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoDepartamentoDomicilio(String value) {
        this.codigoDepartamentoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoProvinciaDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoProvinciaDomicilio() {
        return codigoProvinciaDomicilio;
    }

    /**
     * Define el valor de la propiedad codigoProvinciaDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoProvinciaDomicilio(String value) {
        this.codigoProvinciaDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDistritoDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoDistritoDomicilio() {
        return codigoDistritoDomicilio;
    }

    /**
     * Define el valor de la propiedad codigoDistritoDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoDistritoDomicilio(String value) {
        this.codigoDistritoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad continenteDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContinenteDomicilio() {
        return continenteDomicilio;
    }

    /**
     * Define el valor de la propiedad continenteDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContinenteDomicilio(String value) {
        this.continenteDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad paisDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPaisDomicilio() {
        return paisDomicilio;
    }

    /**
     * Define el valor de la propiedad paisDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPaisDomicilio(String value) {
        this.paisDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad departamentoDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDepartamentoDomicilio() {
        return departamentoDomicilio;
    }

    /**
     * Define el valor de la propiedad departamentoDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDepartamentoDomicilio(String value) {
        this.departamentoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad provinciaDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProvinciaDomicilio() {
        return provinciaDomicilio;
    }

    /**
     * Define el valor de la propiedad provinciaDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProvinciaDomicilio(String value) {
        this.provinciaDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad distritoDomicilio.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDistritoDomicilio() {
        return distritoDomicilio;
    }

    /**
     * Define el valor de la propiedad distritoDomicilio.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDistritoDomicilio(String value) {
        this.distritoDomicilio = value;
    }

    /**
     * Obtiene el valor de la propiedad direccionCompleta.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDireccionCompleta() {
        return direccionCompleta;
    }

    /**
     * Define el valor de la propiedad direccionCompleta.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDireccionCompleta(String value) {
        this.direccionCompleta = value;
    }

    /**
     * Obtiene el valor de la propiedad prenombreMadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrenombreMadre() {
        return prenombreMadre;
    }

    /**
     * Define el valor de la propiedad prenombreMadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrenombreMadre(String value) {
        this.prenombreMadre = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellidoMadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrimerApellidoMadre() {
        return primerApellidoMadre;
    }

    /**
     * Define el valor de la propiedad primerApellidoMadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrimerApellidoMadre(String value) {
        this.primerApellidoMadre = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellidoMadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSegundoApellidoMadre() {
        return segundoApellidoMadre;
    }

    /**
     * Define el valor de la propiedad segundoApellidoMadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSegundoApellidoMadre(String value) {
        this.segundoApellidoMadre = value;
    }

    /**
     * Obtiene el valor de la propiedad prenombrePadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrenombrePadre() {
        return prenombrePadre;
    }

    /**
     * Define el valor de la propiedad prenombrePadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrenombrePadre(String value) {
        this.prenombrePadre = value;
    }

    /**
     * Obtiene el valor de la propiedad primerApellidoPadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrimerApellidoPadre() {
        return primerApellidoPadre;
    }

    /**
     * Define el valor de la propiedad primerApellidoPadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrimerApellidoPadre(String value) {
        this.primerApellidoPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad segundoApellidoPadre.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSegundoApellidoPadre() {
        return segundoApellidoPadre;
    }

    /**
     * Define el valor de la propiedad segundoApellidoPadre.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSegundoApellidoPadre(String value) {
        this.segundoApellidoPadre = value;
    }

    /**
     * Obtiene el valor de la propiedad donacionOrgano.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDonacionOrgano() {
        return donacionOrgano;
    }

    /**
     * Define el valor de la propiedad donacionOrgano.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDonacionOrgano(String value) {
        this.donacionOrgano = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaInscripcion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Define el valor de la propiedad fechaInscripcion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFechaInscripcion(String value) {
        this.fechaInscripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEmision.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Define el valor de la propiedad fechaEmision.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFechaEmision(String value) {
        this.fechaEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCaducidad.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Define el valor de la propiedad fechaCaducidad.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFechaCaducidad(String value) {
        this.fechaCaducidad = value;
    }

    /**
     * Obtiene el valor de la propiedad continenteNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContinenteNacimiento() {
        return continenteNacimiento;
    }

    /**
     * Define el valor de la propiedad continenteNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContinenteNacimiento(String value) {
        this.continenteNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad paisNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    /**
     * Define el valor de la propiedad paisNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPaisNacimiento(String value) {
        this.paisNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad departamentoNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    /**
     * Define el valor de la propiedad departamentoNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDepartamentoNacimiento(String value) {
        this.departamentoNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad provinciaNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProvinciaNacimiento() {
        return provinciaNacimiento;
    }

    /**
     * Define el valor de la propiedad provinciaNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProvinciaNacimiento(String value) {
        this.provinciaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad distritoNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDistritoNacimiento() {
        return distritoNacimiento;
    }

    /**
     * Define el valor de la propiedad distritoNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDistritoNacimiento(String value) {
        this.distritoNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoContinenteNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoContinenteNacimiento() {
        return codigoContinenteNacimiento;
    }

    /**
     * Define el valor de la propiedad codigoContinenteNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoContinenteNacimiento(String value) {
        this.codigoContinenteNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoPaisNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoPaisNacimiento() {
        return codigoPaisNacimiento;
    }

    /**
     * Define el valor de la propiedad codigoPaisNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoPaisNacimiento(String value) {
        this.codigoPaisNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDepartamentoNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoDepartamentoNacimiento() {
        return codigoDepartamentoNacimiento;
    }

    /**
     * Define el valor de la propiedad codigoDepartamentoNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoDepartamentoNacimiento(String value) {
        this.codigoDepartamentoNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoProvinciaNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoProvinciaNacimiento() {
        return codigoProvinciaNacimiento;
    }

    /**
     * Define el valor de la propiedad codigoProvinciaNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoProvinciaNacimiento(String value) {
        this.codigoProvinciaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDistritoNacimiento.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoDistritoNacimiento() {
        return codigoDistritoNacimiento;
    }

    /**
     * Define el valor de la propiedad codigoDistritoNacimiento.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoDistritoNacimiento(String value) {
        this.codigoDistritoNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroDocumentoAdjunto.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNumeroDocumentoAdjunto() {
        return numeroDocumentoAdjunto;
    }

    /**
     * Define el valor de la propiedad numeroDocumentoAdjunto.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNumeroDocumentoAdjunto(String value) {
        this.numeroDocumentoAdjunto = value;
    }

    /**
     * Obtiene el valor de la propiedad documentoAdjunto.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocumentoAdjunto() {
        return documentoAdjunto;
    }

    /**
     * Define el valor de la propiedad documentoAdjunto.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocumentoAdjunto(String value) {
        this.documentoAdjunto = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoDocumentoAdjunto.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoDocumentoAdjunto() {
        return codigoDocumentoAdjunto;
    }

    /**
     * Define el valor de la propiedad codigoDocumentoAdjunto.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoDocumentoAdjunto(String value) {
        this.codigoDocumentoAdjunto = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoNivelEducativo.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoNivelEducativo() {
        return codigoNivelEducativo;
    }

    /**
     * Define el valor de la propiedad codigoNivelEducativo.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoNivelEducativo(String value) {
        this.codigoNivelEducativo = value;
    }

    /**
     * Obtiene el valor de la propiedad nivelEducativo.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNivelEducativo() {
        return nivelEducativo;
    }

    /**
     * Define el valor de la propiedad nivelEducativo.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNivelEducativo(String value) {
        this.nivelEducativo = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoVotacion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCodigoVotacion() {
        return codigoVotacion;
    }

    /**
     * Define el valor de la propiedad codigoVotacion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCodigoVotacion(String value) {
        this.codigoVotacion = value;
    }

    /**
     * Obtiene el valor de la propiedad grupoVotacion.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGrupoVotacion() {
        return grupoVotacion;
    }

    /**
     * Define el valor de la propiedad grupoVotacion.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGrupoVotacion(String value) {
        this.grupoVotacion = value;
    }

}
