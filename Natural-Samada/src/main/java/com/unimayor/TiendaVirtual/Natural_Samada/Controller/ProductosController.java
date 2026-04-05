package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

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
    public Productos obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Productos crear(@RequestBody Productos producto) {
        return service.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Productos actualizar(@PathVariable Long id, @RequestBody Productos producto) {
        return service.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Productos> buscar(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }
}