package co.edu.javeriana.clean.funcionalidad.login;

import co.edu.javeriana.clean.dominio.entidades.Credenciales;
import co.edu.javeriana.clean.dominio.entidades.Usuario;
import co.edu.javeriana.clean.dominio.excepciones.LoginException;
import co.edu.javeriana.clean.infraestructura.persistencia.memoria.RepositorioUsuariosMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorCredencialesTest {

    private ValidadorCredenciales validarCredenciales;

    @BeforeEach
    void setUp() {
        RepositorioUsuariosMemoria repositorioUsuariosMemoria = new RepositorioUsuariosMemoria();
        Usuario usuario1 = new Usuario("1", new Credenciales("usuario1", "password1"));
        Usuario usuario2 = new Usuario("2", new Credenciales("usuario2", "password2"));
        repositorioUsuariosMemoria.crearUsuario(usuario1);
        repositorioUsuariosMemoria.crearUsuario(usuario2);
        validarCredenciales = new ValidadorCredenciales(repositorioUsuariosMemoria);
    }

    @Test
    void validarCredencialesUsuarioNoExiste() {
        //arrange

        //act && assert
        assertThrows(LoginException.class,
                () -> validarCredenciales.validarCredenciales("noExiste", "password"));
    }

    @Test
    void validarCredencialesUsuarioError() {
        //arrange
        Usuario usuario1 = new Usuario("1", new Credenciales("usuario1", "password2"));
        // act
        boolean resultado = validarCredenciales.validarCredenciales(usuario1.getCredenciales().getNombreUsuario(),
                usuario1.getCredenciales().getContrasena());

        //assertNotEquals();
        assertFalse(resultado);
    }

    @Test
    void validarCredencialesOK() {
        Usuario usuario1 = new Usuario("1", new Credenciales("usuario1", "password1"));
        // act
        boolean resultado = validarCredenciales.validarCredenciales(usuario1.getCredenciales().getNombreUsuario(),
                usuario1.getCredenciales().getContrasena());
        //assert
        assertTrue(resultado);
    }
}