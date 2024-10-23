package co.edu.javeriana.clean.funcionalidad.servicios.gateway;

import co.edu.javeriana.clean.dominio.excepciones.LoginException;
import co.edu.javeriana.clean.funcionalidad.login.ValidadorCredenciales;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.IngresoDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.RespuestaDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.RespuestaDTOFabrica;
import co.edu.javeriana.clean.funcionalidad.servicios.validador.ValidadorCampos;

/**
 * Clase que se encarga exponer funcionalidades con los mensajes de error
 */
public class ValidadorGateway {

    private ValidadorCredenciales validadorCredenciales;

    public ValidadorGateway(ValidadorCredenciales validadorCredenciales) {
        this.validadorCredenciales = validadorCredenciales;
    }

    public RespuestaDTO<Boolean> validarCredenciales(IngresoDTO ingresoDTO) {
        try {
            if(!ValidadorCampos.validarCampos(ingresoDTO))
                return RespuestaDTOFabrica.crearRespuestaOK(400, "Campos invalidos", false);
            boolean resultado = validadorCredenciales.validarCredenciales(ingresoDTO.getUsuario(),
                    ingresoDTO.getContrasena());
            if(resultado)
                return RespuestaDTOFabrica.crearRespuestaOK(200, "Login Correcto!", resultado);
            else
                return RespuestaDTOFabrica.crearRespuestaOK(401, "Login Incorrecto!", resultado);
        }
        catch (LoginException le) {
            return RespuestaDTOFabrica.crearRespuestaExcepcionControlada(le);
        }
        catch (Exception e) {
            return RespuestaDTOFabrica.crearRespuestaExcepcion(e);
        }
    }
}
