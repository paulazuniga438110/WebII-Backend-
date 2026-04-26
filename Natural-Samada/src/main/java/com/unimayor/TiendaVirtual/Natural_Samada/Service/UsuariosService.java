package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.UsuariosRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Usuarios;

import java.util.List;

@Service
public class UsuariosService {

    private final UsuariosRepository repository;

    public UsuariosService(UsuariosRepository repository) {
        this.repository = repository;
    }

    public List<Usuarios> listar() {
        return repository.findAll();
    }

    public Usuarios obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuarios guardar(Usuarios usuario) {
        return repository.save(usuario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Usuarios buscarPorCorreo(String correo) {
        return repository.findByCorreo(correo).orElse(null);
    }
}
