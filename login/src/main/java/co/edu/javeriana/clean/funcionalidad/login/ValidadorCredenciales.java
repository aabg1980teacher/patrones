package co.edu.javeriana.clean.funcionalidad.login;

import co.edu.javeriana.clean.dominio.entidades.Usuario;
import co.edu.javeriana.clean.dominio.excepciones.LoginException;
import co.edu.javeriana.clean.funcionalidad.interfaces.RepositorioUsuarios;

import java.util.List;

public class ValidadorCredenciales {

    private RepositorioUsuarios repositorioUsuarios;

    private List<Usuario> usuarios;

    public ValidadorCredenciales(RepositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;

    }

    public boolean validarCredenciales(String usuario, String password) {
        //buscar
        Usuario usuarioEncontrado = repositorioUsuarios.obtenerUsuario(usuario);
        if(usuarioEncontrado == null) {
            throw new LoginException("Usuario no encontrado");
        }
        boolean resultado = usuarioEncontrado.login(password);

        return resultado;

    }
}
