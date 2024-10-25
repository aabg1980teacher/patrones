package co.edu.javeriana.clean.interfaces.main.fachada;

import co.edu.javeriana.clean.funcionalidad.login.ValidadorCredenciales;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.IngresoDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.RespuestaDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.gateway.ValidadorGateway;
import co.edu.javeriana.clean.infraestructura.persistencia.archivos.RepositorioUsuariosJSON;

public class FachadaLogin {

    private ValidadorCredenciales validadorCredenciales;
    private ValidadorGateway validadorGateway;

    public FachadaLogin() {
        this.validadorCredenciales = new ValidadorCredenciales(new RepositorioUsuariosJSON());
        this.validadorGateway = new ValidadorGateway(validadorCredenciales);
    }

    public RespuestaDTO<Boolean> validarCredenciales(IngresoDTO ingresoDTO) {
        return validadorGateway.validarCredenciales(ingresoDTO);
    }


}
