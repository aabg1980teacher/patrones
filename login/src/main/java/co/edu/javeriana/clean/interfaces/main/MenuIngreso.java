package co.edu.javeriana.clean.interfaces.main;

import co.edu.javeriana.clean.funcionalidad.login.ValidadorCredenciales;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.IngresoDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.RespuestaDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.gateway.ValidadorGateway;
import co.edu.javeriana.clean.infraestructura.persistencia.archivos.RepositorioUsuariosJSON;

import java.util.Scanner;

public class MenuIngreso {

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de ingreso");
        System.out.print("Por favor ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Por favor ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        ValidadorCredenciales validadorCredenciales = new ValidadorCredenciales(new RepositorioUsuariosJSON());
        ValidadorGateway validadorGateway = new ValidadorGateway(validadorCredenciales);
        IngresoDTO ingresoDTO = new IngresoDTO(usuario, contrasena);
        RespuestaDTO<Boolean> respuesta = validadorGateway.validarCredenciales(ingresoDTO);

        System.out.println(respuesta.getMensaje());


    }
}
