package co.edu.javeriana.clean.infraestructura.persistencia.memoria;

import co.edu.javeriana.clean.dominio.entidades.Usuario;
import co.edu.javeriana.clean.funcionalidad.interfaces.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuariosMemoria implements RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuariosMemoria() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public String crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario.getIdUsuario();
    }

    @Override
    public String actualizarUsuario(Usuario usuario) {
        return "";
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public Usuario obtenerUsuario(String userName) {
        return usuarios.stream().
                filter(usuario ->
                        usuario.getCredenciales().getNombreUsuario().equals(userName)).findFirst().orElse(null);
    }

    @Override
    public void eliminarUsuario(String userId) {
        //TODO implementar mas adelante
        throw new UnsupportedOperationException("Medoto no implementado");
    }
}
