package ec.edu.espe.segundoparcial.examengavilanes.controller;

//import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Empresas;
import ec.edu.espe.segundoparcial.examengavilanes.service.EmpresaService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/{ruc}")
    public ResponseEntity<Empresas> obtenerEmpresaPorRuc(@PathParam("ruc") String ruc) {
        log.info("Va obtener empresa con RUC: {}", ruc);
        return empresaService.obtenerEmpresaPorRuc(ruc)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresas> crearEmpresa( Empresas empresas) {
        log.info("Va crear nueva empresa: {}", empresas);
        try {
            Empresas nuevaEmpresa = empresaService.crearEmpresa(empresas);
            return ResponseEntity.ok(nuevaEmpresa);
        } catch (Exception e) {
            log.error("Error al crear una empresa", e);
            return ResponseEntity.badRequest().body(null);
        }
    }
}

