package co.edu.javeriana.clean.dominio.entidades;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Credenciales {

    private final String nombreUsuario;
    private String contrasena;

    public Credenciales(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public void cambiarContrasena(String contrasena) {
        // Validar que la contraseña cumpla con las reglas de negocio
        this.contrasena = contrasena;
    }
}
