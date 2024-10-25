package co.edu.javeriana.clean.interfaces.main;


import co.edu.javeriana.clean.funcionalidad.servicios.dto.IngresoDTO;
import co.edu.javeriana.clean.funcionalidad.servicios.dto.RespuestaDTO;

import co.edu.javeriana.clean.interfaces.main.fachada.FachadaLogin;

import java.util.Scanner;

public class MenuIngreso {

    private FachadaLogin fachadaLogin;

    public MenuIngreso() {
        fachadaLogin = new FachadaLogin();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al sistema de ingreso");
        System.out.print("Por favor ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Por favor ingrese su contraseña: ");
        String contrasena = scanner.nextLine();


        IngresoDTO ingresoDTO = new IngresoDTO(usuario, contrasena);
        RespuestaDTO<Boolean> respuesta = fachadaLogin.validarCredenciales(ingresoDTO);

        System.out.println(respuesta.getMensaje());


    }
}
