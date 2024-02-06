package ec.edu.espe.segundoparcial.examengavilanes.repository;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Productos;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends MongoRepository<Productos, String> {

    List<Productos> findByRucEmpresa(String rucEmpresa, Sort sort);
    Optional<Productos> findByCodigoUnicoProducto(String codigoUnicoProducto);
}