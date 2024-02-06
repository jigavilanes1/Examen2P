package ec.edu.espe.segundoparcial.examengavilanes.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Document(collection = "productos")
public class Productos {

    @Id
    private String id;
    @Indexed(unique = true)
    private String codigoUnicoProducto;
    private String rucEmpresa;
    @Indexed
    private String descripcion;
    private Double precio;
    private List<Comentarios> comentarios;
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
        Productos other = (Productos) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (codigoUnicoProducto == null) {
            if (other.codigoUnicoProducto != null)
                return false;
        } else if (!codigoUnicoProducto.equals(other.codigoUnicoProducto))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((codigoUnicoProducto == null) ? 0 : codigoUnicoProducto.hashCode());
        return result;
    }
    
    @Override
    public String toString() {
        return "Productos [id=" + id + ", codigoUnicoProducto=" + codigoUnicoProducto + ", rucEmpresa=" + rucEmpresa
                + ", descripcion=" + descripcion + ", precio=" + precio + ", comentarios=" + comentarios + ", version="
                + version + "]";
    }

    
    

}