package co.edu.javeriana.clean.infraestructura.persistencia.archivos;

import co.edu.javeriana.clean.dominio.entidades.Usuario;
import co.edu.javeriana.clean.dominio.excepciones.LoginException;
import co.edu.javeriana.clean.funcionalidad.interfaces.RepositorioUsuarios;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class RepositorioUsuariosJSON implements RepositorioUsuarios {

    private final String rutaArchivo = "login/archivos/usuarios.json";

    private List<Usuario> usuarios;


    @Override
    public String crearUsuario(Usuario usuario) {
        usuarios.add(usuario);
        //guardar
        return usuario.getIdUsuario();
    }

    @Override
    public String actualizarUsuario(Usuario usuario) {

        return "";
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(rutaArchivo));
            Type personListType = new TypeToken<List<Usuario>>() {}.getType();
            Gson gson = new Gson();

            // Json array to List of objects
            usuarios = gson.fromJson(bufferedReader, personListType);

            return usuarios;
        } catch (FileNotFoundException e) {
            throw new LoginException("Archivo no encontrado " + e.getMessage());
        }


    }

    @Override
    public Usuario obtenerUsuario(String userName) {
        usuarios = obtenerUsuarios();
        return usuarios.stream().
                filter(usuario ->
                        usuario.getCredenciales().getNombreUsuario().equals(userName))
                        .findFirst()
                        .orElseThrow(()-> new LoginException("Usuario no encontrado"));

    }

    @Override
    public void eliminarUsuario(String userId) {
        throw new UnsupportedOperationException("Metodo no implementado");
    }
}
