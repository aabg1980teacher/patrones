package co.edu.javeriana.clean.funcionalidad.servicios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class RespuestaDTO<T>
{

    private Integer codigo;
    private String mensaje;
    private T data;


}
