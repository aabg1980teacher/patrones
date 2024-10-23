package co.edu.javeriana.clean.dominio.entidades;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private static Usuario usuario;

    @BeforeAll
    public static void setUp() {
        Credenciales credenciales = new Credenciales("usuario", "password");
        usuario = new Usuario("1", credenciales);
    }

    @Test
    void testPasswordVacio() {
        // Arrange
        String password = "";
        // Act
        boolean result = usuario.login(password);
        // Assert
        assertFalse(result);
    }

    @Test
    void testPasswordInvalido() {
        // Arrange
        String password = "12345678";
        // Act
        boolean result = usuario.login(password);
        // Assert
        assertFalse(result);
    }

    @Test
    void testPasswordValido() {
        // Arrange
        String password = "password";
        // Act
        boolean result = usuario.login(password);
        // Assert
        assertTrue(usuario.getNumeroIntentos()==0 && result);
    }
}