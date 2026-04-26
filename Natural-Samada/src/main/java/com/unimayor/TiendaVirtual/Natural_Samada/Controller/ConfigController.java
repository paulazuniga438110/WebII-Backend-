package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.ConfigService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Config;

import java.util.List;

@RestController
@RequestMapping("/api/config")
@CrossOrigin(origins = "*")
public class ConfigController {

    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Config>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Config> obtener(@PathVariable Long id) {
        Config config = service.obtener(id);
        if (config == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(config);
    }

    @PostMapping
    public ResponseEntity<Config> crear(@RequestBody Config config) {
        return ResponseEntity.ok(service.guardar(config));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Config> actualizar(@PathVariable Long id, @RequestBody Config config) {
        if (service.obtener(id) == null) {
            return ResponseEntity.notFound().build();
        }
        config.setId(id);
        return ResponseEntity.ok(service.guardar(config));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.obtener(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

