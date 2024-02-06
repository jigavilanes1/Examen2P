package ec.edu.espe.segundoparcial.examengavilanes.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Comentarios {

    private Integer calificacion;
    private String comentario;
    private String usuario;
    private Date fechaComentario;
}