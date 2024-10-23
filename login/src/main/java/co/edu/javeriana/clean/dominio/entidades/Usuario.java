package co.edu.javeriana.clean.dominio.entidades;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Usuario {

    private String idUsuario;
    //private LocalDa//teTime fechaCreacion;
    //private LocalDateTime fechaUltimoIngreso;
    private Boolean estaBloqueado;
    private Integer numeroIntentos;

    private Credenciales credenciales;

    public Usuario(String idUsuario, Credenciales credenciales) {
        this.idUsuario = idUsuario;
        this.credenciales = credenciales;
        //this.fechaCreacion = LocalDateTime.now();
        ///this.fechaUltimoIngreso = LocalDateTime.now();
        this.estaBloqueado = false;
        this.numeroIntentos = 0;
    }





    public boolean login(String password) {
        if(password.isEmpty()) {
            numeroIntentos++;
            return false;
        }
        if(!credenciales.getContrasena().equalsIgnoreCase(password)) {
            numeroIntentos++;
            return false;
        }
        numeroIntentos = 0;
        //fechaUltimoIngreso = LocalDateTime.now();
        return true;
    }
}
