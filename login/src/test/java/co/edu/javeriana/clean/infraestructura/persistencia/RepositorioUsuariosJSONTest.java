package co.edu.javeriana.clean.infraestructura.persistencia;

import co.edu.javeriana.clean.dominio.entidades.Usuario;
import co.edu.javeriana.clean.infraestructura.persistencia.archivos.RepositorioUsuariosJSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioUsuariosJSONTest {

    @Test
    void obtenerUsuarios() {
        // Arrange
        RepositorioUsuariosJSON repositorioUsuariosJSON = new RepositorioUsuariosJSON();

        // Act
        List<Usuario> usuarios = repositorioUsuariosJSON.obtenerUsuarios();
        // Assert
        System.out.println(usuarios);
        assertTrue(usuarios.size() > 0);
    }
}