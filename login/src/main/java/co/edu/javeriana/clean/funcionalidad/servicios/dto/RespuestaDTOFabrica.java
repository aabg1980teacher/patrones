package co.edu.javeriana.clean.funcionalidad.servicios.dto;

import co.edu.javeriana.clean.dominio.excepciones.LoginException;

public class RespuestaDTOFabrica {

    public static RespuestaDTO crearRespuestaOK(Integer codigo, String mensaje, Object data) {
        return new RespuestaDTO<>(codigo, mensaje, data);
    }

    public static RespuestaDTO crearRespuestaExcepcion(Exception e) {
        return new RespuestaDTO<>(500, "Error interno" + e.getMessage(), null);
    }

    public static RespuestaDTO crearRespuestaExcepcionControlada(LoginException e) {
        return new RespuestaDTO<>(e.getCodigoError(), e.getMessage(), null);
    }
}
