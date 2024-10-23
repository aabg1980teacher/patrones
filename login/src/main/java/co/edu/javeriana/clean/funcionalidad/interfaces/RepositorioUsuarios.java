package co.edu.javeriana.clean.funcionalidad.interfaces;

import co.edu.javeriana.clean.dominio.entidades.Usuario;

import java.util.List;

public interface RepositorioUsuarios {

    String crearUsuario(Usuario usuario);

    String actualizarUsuario(Usuario usuario);

    List<Usuario> obtenerUsuarios();

    Usuario obtenerUsuario(String userName);

    void eliminarUsuario(String userId);
}
