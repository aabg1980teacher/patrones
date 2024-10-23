package co.edu.javeriana.clean.infraestructura.persistencia.archivos;

import co.edu.javeriana.clean.dominio.entidades.Usuario;

import java.util.HashMap;
import java.util.List;

public class CacheUsuarios {

    private HashMap<String, Usuario> cacheUsuarios;

    private static CacheUsuarios instancia;

    private CacheUsuarios() {
        cacheUsuarios = new HashMap<>();
    }

    public static CacheUsuarios getInstancia() {
        synchronized (instancia)  {
            if (instancia == null)
                instancia = new CacheUsuarios();
            return instancia;
        }
    }

    private void crearMapa(List<Usuario> usuarioList) {
        for(Usuario u: usuarioList) {
            cacheUsuarios.put(u.getCredenciales().getNombreUsuario(), u);
        }
    }

    public void cargarCache() {
        //leer
        List<Usuario> listaUsuarios = null;
        crearMapa(listaUsuarios);
    }
}
