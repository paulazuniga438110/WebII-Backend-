package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.ProveedorService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Proveedor;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    private final ProveedorService service;

    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Proveedor> listar() {
        return service.obtenerProveedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtener(@PathVariable Long id) {
        Proveedor proveedor = service.obtenerPorId(id);

        if (proveedor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(proveedor);
    }

    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return service.guardarProveedor(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizar(@PathVariable Long id, @RequestBody Proveedor proveedor) {

        Proveedor actualizado = service.actualizarProveedor(id, proveedor);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        Proveedor proveedor = service.obtenerPorId(id);

        if (proveedor == null) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.ok("Proveedor eliminado correctamente");
    }

    @GetMapping("/buscar")
    public List<Proveedor> buscar(@RequestParam(required = false) String nombre) {

        if (nombre == null || nombre.isEmpty()) {
            return service.obtenerProveedores();
        }

        return service.buscarPorNombre(nombre);
    }
}
