package ec.edu.espe.segundoparcial.examengavilanes.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "empresas")
public class Empresas {

    @Id
    private String id;
    @Indexed(unique = true)
    private String ruc;
    @Indexed
    private String razonSocial;
    private Date fechaCreacion;
    @Version
    private Long version;


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresas other = (Empresas) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", ruc=" + ruc + ", razonSocial=" + razonSocial + ", fechaCreacion="
                + fechaCreacion + ", version=" + version + "]";
    }
    

}