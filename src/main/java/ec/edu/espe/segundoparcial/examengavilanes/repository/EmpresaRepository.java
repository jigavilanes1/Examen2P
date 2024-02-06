package ec.edu.espe.segundoparcial.examengavilanes.repository;

import java.util.Optional;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Empresas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmpresaRepository extends MongoRepository<Empresas, String>{
    Optional<Empresas> findByRuc(String ruc);
}