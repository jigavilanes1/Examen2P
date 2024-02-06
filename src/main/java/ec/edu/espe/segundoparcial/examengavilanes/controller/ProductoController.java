package ec.edu.espe.segundoparcial.examengavilanes.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Comentarios;
import ec.edu.espe.segundoparcial.examengavilanes.domain.Productos;
import ec.edu.espe.segundoparcial.examengavilanes.service.ProductoService;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/empresa/{ruc}")
    public ResponseEntity<List<Productos>> listarProductosEmpresa(@PathParam("ruc") String ruc) {
        log.info("Va listar productos para la empresa con RUC: {}", ruc);
        List<Productos> productos = productoService.listarProductoEmpresa(ruc);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{codigoUnicoProducto}")
    public ResponseEntity<Productos> obtenerProducto(@PathParam("codigoUnicoProducto") String codigoUnicoProducto) {
        log.info("Va obtener producto con código único: {}", codigoUnicoProducto);
        return productoService.obtenerProducto(codigoUnicoProducto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{codigoUnicoProducto}/comentarios")
    public ResponseEntity<List<Comentarios>> obtenerComentariosProducto(@PathParam("codigoUnicoProducto") String codigoUnicoProducto) {
        log.info("Va obtener comentarios para el producto con código único: {}", codigoUnicoProducto);
        try {
            List<Comentarios> comentarios = productoService.obtenerComentariosProducto(codigoUnicoProducto);
            return ResponseEntity.ok(comentarios);
        } catch (RuntimeException e) {
            log.error("Comentarios del producto no existen", e);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Productos> crearProducto(Productos producto) {
        log.info("Creando nuevo producto");
        Productos nuevoProducto = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevoProducto);
    }

    @PostMapping("/{codigoUnicoProducto}/comentarios")
    public ResponseEntity<Productos> agregarComentarioProducto(@PathParam("codigoUnicoProducto") String codigoUnicoProducto,Comentarios comentario) {
        log.info("Va agregar comentario al producto con código único: {}", codigoUnicoProducto);
        Productos productoActualizado = productoService.agregarComentarioProducto(codigoUnicoProducto, comentario);
        return ResponseEntity.ok(productoActualizado);
    }
}
