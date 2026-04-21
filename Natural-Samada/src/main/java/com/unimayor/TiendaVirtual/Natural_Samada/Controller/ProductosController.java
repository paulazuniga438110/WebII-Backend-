package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.ProductosService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Productos;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductosController {

    private final ProductosService service;

    public ProductosController(ProductosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Productos> listar() {
        return service.obtenerProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> obtener(@PathVariable Long id) {
        Productos producto = service.obtenerPorId(id);

        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public Productos crear(@RequestBody Productos producto) {
        return service.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> actualizar(@PathVariable Long id, @RequestBody Productos producto) {
        Productos existente = service.obtenerPorId(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(service.actualizarProducto(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Productos producto = service.obtenerPorId(id);

        if (producto == null) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }

    @GetMapping("/buscar")
    public List<Productos> buscar(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }
}