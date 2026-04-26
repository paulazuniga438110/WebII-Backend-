package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.DetalleService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Detalle;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
@CrossOrigin(origins = "*")
public class DetalleController {

    private final DetalleService service;

    public DetalleController(DetalleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Detalle>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle> obtener(@PathVariable Long id) {
        Detalle detalle = service.obtener(id);
        if (detalle == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalle);
    }

    @PostMapping
    public ResponseEntity<Detalle> crear(@RequestBody Detalle detalle) {
        Detalle nuevoDetalle = service.guardar(detalle);
        return ResponseEntity.ok(nuevoDetalle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle> actualizar(@PathVariable Long id, @RequestBody Detalle detalle) {
        if (service.obtener(id) == null) {
            return ResponseEntity.notFound().build();
        }
        detalle.setId(id);
        return ResponseEntity.ok(service.guardar(detalle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.obtener(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<Detalle>> obtenerPorVenta(@PathVariable Long idVenta) {
        List<Detalle> detalles = service.porVenta(idVenta);
        return ResponseEntity.ok(detalles);
    }
}

