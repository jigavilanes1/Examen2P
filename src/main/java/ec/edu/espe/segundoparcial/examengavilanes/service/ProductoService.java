package ec.edu.espe.segundoparcial.examengavilanes.service;

import ec.edu.espe.segundoparcial.examengavilanes.domain.Productos;
import ec.edu.espe.segundoparcial.examengavilanes.domain.Comentarios;
import ec.edu.espe.segundoparcial.examengavilanes.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Productos> listarProductoEmpresa(String ruc) {
        log.info("Va listar productos de la empresa con RUC: {}", ruc);
        return productoRepository.findByRucEmpresa(ruc, Sort.by(Sort.Direction.ASC, "nombre"));
    }


    

    public Optional<Productos> obtenerProducto(String codigoUnicoProducto) {
        log.info("Va obtener productos con código único: {}", codigoUnicoProducto);
        return productoRepository.findByCodigoUnicoProducto(codigoUnicoProducto);
    }

    public List<Comentarios> obtenerComentariosProducto(String codigoUnicoProducto) {
        log.info("Va obtener comentarios para el producto con código único: {}", codigoUnicoProducto);
        Optional<Productos> producto = productoRepository.findByCodigoUnicoProducto(codigoUnicoProducto);
        if (producto.isPresent()) {
            return producto.get().getComentarios();
        } else {
            throw new RuntimeException("Producto no encontrado con código único: " + codigoUnicoProducto);
        }
    }

    public Productos crearProducto(Productos producto) {
        log.info("Creando nuevo producto: {}", producto);
        return productoRepository.save(producto);
    }

    public Productos agregarComentarioProducto(String codigoUnicoProducto, Comentarios comentario) {
        log.info("Va crear comentario al producto con código único: {}", codigoUnicoProducto);
        Productos producto = productoRepository.findByCodigoUnicoProducto(codigoUnicoProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con código único: " + codigoUnicoProducto));
        producto.getComentarios().add(comentario);
        return productoRepository.save(producto);
    }
}
