package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.ClientesRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Clientes;

import java.util.List;

@Service
public class ClientesService {

    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public List<Clientes> obtenerClientes() {
        return repository.findAll();
    }

    public Clientes guardarCliente(Clientes cliente) {
        return repository.save(cliente);
    }

    public Clientes obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }

    public Clientes actualizarCliente(Long id, Clientes cliente) {
        Clientes existente = repository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }
        existente.setDni(cliente.getDni());
        existente.setNombre(cliente.getNombre());
        existente.setCorreo(cliente.getCorreo());
        existente.setPassword(cliente.getPassword());
        existente.setTelefono(cliente.getTelefono());
        existente.setDireccion(cliente.getDireccion());
        return repository.save(existente);
    }

    public List<Clientes> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public Clientes buscarPorCorreo(String correo) {
        return repository.findByCorreo(correo).orElse(null);
    }
}
