package co.edu.javeriana.clean.funcionalidad.servicios.validador;

import co.edu.javeriana.clean.funcionalidad.servicios.dto.IngresoDTO;

public class ValidadorCampos {

    public static boolean validarCampos(IngresoDTO ingresoDTO) {
        if(ingresoDTO.getUsuario() == null || ingresoDTO.getUsuario().isEmpty()) {
            return false;
        }
        if(ingresoDTO.getContrasena() == null || ingresoDTO.getContrasena().isEmpty()) {
            return false;
        }
        return true;
    }
}
