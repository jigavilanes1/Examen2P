package ec.edu.espe.segundoparcial.examengavilanes.service;
import ec.edu.espe.segundoparcial.examengavilanes.domain.Empresas;
import ec.edu.espe.segundoparcial.examengavilanes.repository.EmpresaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Slf4j
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Optional<Empresas> obtenerEmpresaPorRuc(String ruc) {
        log.info("Va listar la empresa con el siguiente RUC: {}", ruc);
        return empresaRepository.findByRuc(ruc);
    }

    public Empresas crearEmpresa(Empresas empresas) {
        log.info("Va crear la empresa: {}", empresas);
        try {
            return empresaRepository.save(empresas);
        } catch (Exception e) {
            log.error("Error al crear la empresa", e);
            throw new RuntimeException("Error al crear la empresa.", e);
        }
    }
}