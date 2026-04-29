package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.ProveedorRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Proveedor;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository repository;

    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    public List<Proveedor> obtenerProveedores() {
        return repository.findAll();
    }

    public Proveedor guardarProveedor(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    public Proveedor obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    public Proveedor actualizarProveedor(Long id, Proveedor proveedor) {
        Proveedor existente = repository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setRuc(proveedor.getRuc());
        existente.setNombre(proveedor.getNombre());
        existente.setTelefono(proveedor.getTelefono());
        existente.setDireccion(proveedor.getDireccion());
        existente.setCorreo(proveedor.getCorreo());
        return repository.save(existente);
    }

    public List<Proveedor> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
}

