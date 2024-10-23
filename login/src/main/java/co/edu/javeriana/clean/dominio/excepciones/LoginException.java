package co.edu.javeriana.clean.dominio.excepciones;

import lombok.Getter;

@Getter
public class LoginException extends RuntimeException {

    private Integer codigoError;

    public LoginException(Integer codigoError, String message) {
        super(message);
        this.codigoError = codigoError;
    }

    public LoginException(String message) {
        super(message);
    }
}
