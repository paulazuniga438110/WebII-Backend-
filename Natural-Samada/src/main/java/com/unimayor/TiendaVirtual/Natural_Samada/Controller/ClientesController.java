package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.ClientesService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Clientes;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClientesController {

    private final ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Clientes> listar() {
        return service.obtenerClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtener(@PathVariable Long id) {
        Clientes cliente = service.obtenerPorId(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public Clientes crear(@RequestBody Clientes cliente) {
        return service.guardarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizar(@PathVariable Long id, @RequestBody Clientes cliente) {
        Clientes actualizado = service.actualizarCliente(id, cliente);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        Clientes cliente = service.obtenerPorId(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        service.eliminarPorId(id);
        return ResponseEntity.ok("Cliente eliminado correctamente");
    }

    @GetMapping("/buscar")
    public List<Clientes> buscar(@RequestParam(required = false) String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return service.obtenerClientes();
        }
        return service.buscarPorNombre(nombre);
    }
}
