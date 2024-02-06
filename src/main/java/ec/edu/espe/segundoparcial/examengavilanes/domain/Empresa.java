package ec.edu.espe.segundoparcial.examengavilanes.domain;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "empresa")
public class Empresa {
    @Id
    private String id;
    @Indexed(unique = true)
    private String ruc;
    private String razonSocial;
    private Date fechaCreacion;
}