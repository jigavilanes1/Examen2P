package ec.edu.espe.segundoparcial.examengavilanes.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Empresas;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresas, String>{
    Optional<Empresas> findByRuc(String ruc);
}