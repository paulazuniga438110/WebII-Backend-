package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.VentasService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Ventas;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentasController {

    private final VentasService service;

    public VentasController(VentasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Ventas>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> obtener(@PathVariable Long id) {
        Ventas venta = service.obtener(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(venta);
    }

    @PostMapping
    public ResponseEntity<Ventas> crear(@RequestBody Ventas venta) {
        Ventas nuevaVenta = service.guardar(venta);
        return ResponseEntity.ok(nuevaVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> actualizar(@PathVariable Long id, @RequestBody Ventas venta) {
        Ventas existente = service.obtener(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        venta.setId(id);
        return ResponseEntity.ok(service.guardar(venta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Ventas venta = service.obtener(id);
        if (venta == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.ok("Venta eliminada correctamente");
    }
}

