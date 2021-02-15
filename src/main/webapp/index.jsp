<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Aplicación de Pruebas - Web Service Consulta de Datos - RUIPN</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/vendors/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/app/css/app.css">

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/vendors/jquery/jquery-3.2.1.min.js"></script>

    <script language="JavaScript" type="text/javascript"
            src="https://serviciosportal.reniec.gob.pe/mwwd2/resources/js/dnieauth-1.0.full.min.js"></script>

    <%--<script language="JavaScript" type="text/javascript"
            src="https://hsmserver3.reniec.gob.pe/mwwd2/resources/js/dnieauth-1.0.full.min.js"></script>--%>

    <script language="JavaScript" type="text/javascript">
        var appArgs = {
            // localAppConnectionTimeout: 8000, // tiempo de espera para iniciar servidor local
            dnieAuthServer: '${oauthServer}',// servidor de autenticación
            dnieAuthClientId: '${oAuthClientId}',//
            dnieAuthRedirectUri: '${dnieAuthRedirectUri}',
            dnieAuthScope: 'all',
            dnieAuthState: 'abcdef'
        };

        function onLoginSuccess(evt) {
            $('#output')
                .html('')
                .append(evt);

            $.ajax({
                url: evt,
                type: 'post',
                success: function (response) {
                    console.log(response);
                    $('#accessToken').val(response);
                },
                error: function (jqXHR) {
                    console.log(jqXHR);
                    alert(jqXHR)
                }
            });
        }

        function onLoginError(evt) {
            console.log(evt);
            alert(evt);
            $('#result').html('');
            $('#result').append('<p class="text-danger">' + evt + '</p>');
        }

        function consultar() {
            $('#result').html('<p class="text-danger">Cargando...</p>');
            limpiar();
            $.ajax({
                url: 'consultar.do',
                data: $('#form-consulta').serialize(),
                type: 'post',
                success: function (response) {
                    console.log(response);
                    $('#result').html('');

                    $('#result').append('<strong> coResultado: ' + response.coResultado + '<br/>');
                    $('#result').append('<strong> deResultado: ' + response.deResultado + '<br/> <br/>');

                    if (response.coResultado == '0000') { // respuesta OK

                        $("#dni").html(response.datosPersona.dni);
                        $("#prenombres").html(response.datosPersona.prenombres);
                        $("#primerApellido").html(response.datosPersona.primerApellido);
                        $("#apellidoCasada").html(response.datosPersona.apellidoCasada);
                        $("#segundoApellido").html(response.datosPersona.segundoApellido);
                        $("#fechaNacimiento").html(response.datosPersona.fechaNacimiento);
                        $("#genero").html(response.datosPersona.genero);
                        $("#estatura").html(response.datosPersona.estatura + " CMS");
                        $("#estadoCivil").html(response.datosPersona.estadoCivil);
                        $("#digitoVerificacion").html(response.datosPersona.digitoVerificacion);
                        $("#restriccion").html(response.datosPersona.restriccion);
                        $("#departamentoDomicilio").html(response.datosPersona.departamentoDomicilio);
                        $("#provinciaDomicilio").html(response.datosPersona.provinciaDomicilio);
                        $("#distritoDomicilio").html(response.datosPersona.distritoDomicilio);
                        $("#direccionCompleta").html(response.datosPersona.direccionCompleta);
                        $("#prenombreMadre").html(response.datosPersona.prenombreMadre);
                        $("#prenombrePadre").html(response.datosPersona.prenombrePadre);
                        $("#departamentoNacimiento").html(response.datosPersona.departamentoNacimiento);
                        $("#provinciaNacimiento").html(response.datosPersona.provinciaNacimiento);
                        $("#distritoNacimiento").html(response.datosPersona.distritoNacimiento);

                        $("#foto").attr('src', 'data:image/png;base64,' + btoa(String.fromCharCode.apply(null, new Uint8Array(response.datosPersona.foto))));

                    }

                },
                error: function (jqXHR) {
                    console.log(jqXHR);
                    alert(jqXHR)
                }
            });
        }
        function limpiar() {
            $("#dni").html(' ');
            $("#prenombres").html(' ');
            $("#primerApellido").html(' ');
            $("#apellidoCasada").html(' ');
            $("#segundoApellido").html(' ');
            $("#fechaNacimiento").html(' ');
            $("#genero").html(' ');
            $("#estatura").html(' ');
            $("#estadoCivil").html(' ');
            $("#digitoVerificacion").html(' ');
            $("#restriccion").html(' ');
            $("#departamentoDomicilio").html(' ');
            $("#provinciaDomicilio").html(' ');
            $("#distritoDomicilio").html(' ');
            $("#direccionCompleta").html(' ');
            $("#prenombreMadre").html(' ');
            $("#prenombrePadre").html(' ');
            $("#departamentoNacimiento").html(' ');
            $("#provinciaNacimiento").html(' ');
            $("#distritoNacimiento").html(' ');

            $("#foto").attr('src', '');
        }

    </script>

    <script language="JavaScript" type="text/javascript"
            src="https://serviciosportal.reniec.gob.pe/mwwd2/resources/js/dnieauth-1.0.full.min.js"></script>

    <script language="JavaScript" type="text/javascript">
        var appArgs = {
            dnieAuthServer: 'https://dnieauth.reniec.gob.pe/sso',// servidor de autenticación
            dnieAuthClientId: 'test.20295613620.localapp',// client id solicitar a reniec
            dnieAuthRedirectUri: 'http://localhost:8080/wsconsultadni-test-dnie/accessToken.do',
            dnieAuthScope: 'all', // scope por defecto all
            dnieAuthState: 'abcdef'// State por defecto abcdef
        };

        function onLoginSuccess(evt) {
            // “url de redirección”
            console.log(evt);
        }

        function onLoginError(evt) {
            // Error
            console.log(evt);
        }
    </script>
</head>
<body>

<div class="page-header">
    <h1>Aplicación cliente - Web Service Consulta de Datos
        <small>SREL</small>
    </h1>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <h2>Consulta de Datos</h2>

            <div class="divider">
                <br/>
                <br/>
            </div>
            <form class="form-horizontal" id="form-consulta">

                <div class="form-group">
                    <label class="control-label col-sm-4">nuRucEntidad</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="nuRucUsuario" name="nuRucUsuario"
                               value="20295613620"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4">nuDniConsulta</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="nuDniConsulta" name="nuDniConsulta"
                               value="41691600"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4"><span class="badge">3</span> AccessToken</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="accessToken" name="accessToken"
                               value="${accessToken}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-4">
                        <button type="button" class="btn btn-lg btn-primary" value="Login con DNIe"
                                onclick="DnieAuth.launch(appArgs, onLoginSuccess, onLoginError)">
                            <span class="badge">1</span> Login con DNIe
                        </button>

                        <button type="button" class="btn btn-lg btn-default btn-send-form" value="AccessToken Cache"
                                onclick="consultar()">
                            <span class="badge">4</span> Consultar
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-6">

            <h2>Requisitos en la PC</h2>
            <p>Todos el software necesario se encuentra en: <a href="https://serviciosportal.reniec.gob.pe/static/portal/installers/RENIEC-PortalCiudadano-1.1.exe">https://serviciosportal.reniec.gob.pe/static/portal/installers/RENIEC-PortalCiudadano-1.1.exe</a></p>
            <ol>
                <li>Windows 7 x32 o x64 o superior</li>
                <li>Java 8</li>
                <li>Lectora de tarjetas inteligentes (ISO-7816)</li>
                <li>DNI electrónico con certificado de autenticación vigente.</li>
                <li>MiniDriver del DNIe</li>
                <li>Navegador web: Google Chrome 69 o superior, IE 11 o superior, Firefox 48 o superior</li>
                <li>Acceso a las siguientes urls:
                    <ol>
                        <li><a href="https://dnieauth.reniec.gob.pe/sso">https://dnieauth.reniec.gob.pe/sso</a> Servicio de autenticación con dnie (debe accederse directamente sin proxy )</li>
                        <li><a href="https://serviciosportal.reniec.gob.pe/wsdnievalidation/">https://serviciosportal.reniec.gob.pe/wsdnievalidation/</a> WS de validación de certificados del dnie</li>
                    </ol>
                </li>
            </ol>
            <h2>Flujo</h2>
            <ul class="list-unstyled">
                <li class=""><span class="badge">1</span> Aplicación login con DNIe, envía petición al servidor de autorización (TLS_1.2, autenticación  con certificado del DNIe): https://dnieauth.reniec.gob.pe/sso/oauth/authorize?client_id=test.20295613620.localapp&redirect_uri=URI_REDIRECT&response_type=code&scope=all&state=abcdef</li>
                <li><span class="badge">2</span> Aplicación login con DNIe responde la URI_REDIRECT con el parametro <strong>code</strong></li>
                <li><span class="badge">3</span> La aplicación cliente solicita el accessToken al servidor de autorización, incluyendo el parametro <strong>code</strong> de autorización recibido en el paso anterior.</li>
                <li><span class="badge">4</span> La aplicación cliente envía una petición con los parametros accessToken, ruc, dni al WS de consulta de datos</li>
            </ul>

        </div>
    </div>

    <div class="row">
        <div class="col-sm-12">

            <h4><span class="badge">2</span> OUTPUT: (redirect_uri)</h4>
            <div id="output"></div>
            <br/>

            <h1>Resultado de la Consulta de Datos</h1>
            <br/>

            <div id="result"></div>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Datos Persona</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img src="" id="foto">
                        </div>

                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td><strong>dni:</strong></td>
                                    <td id="dni"></td>
                                </tr>

                                <tr>
                                    <td><strong>prenombres:</strong></td>
                                    <td id="prenombres"></td>
                                </tr>
                                <tr>
                                    <td><strong>primerApellido:</strong></td>
                                    <td id="primerApellido"></td>
                                </tr>
                                <tr>
                                    <td><strong>apellidoCasada:</strong></td>
                                    <td id="apellidoCasada"></td>
                                </tr>
                                <tr>
                                    <td><strong>segundoApellido:</strong></td>
                                    <td id="segundoApellido"></td>
                                </tr>
                                <tr>
                                    <td><strong>fechaNacimiento:</strong></td>
                                    <td id="fechaNacimiento"></td>
                                </tr>
                                <tr>
                                    <td><strong>genero:</strong></td>
                                    <td id="genero"></td>
                                </tr>

                                <tr>
                                    <td><strong>estadoCivil:</strong></td>
                                    <td id="estadoCivil"></td>
                                </tr>

                                <tr>
                                    <td><strong>restriccion:</strong></td>
                                    <td id="restriccion"></td>
                                </tr>



                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>