package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.DetalleRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Detalle;

import java.util.List;

@Service
public class DetalleService {

    private final DetalleRepository repository;

    public DetalleService(DetalleRepository repository) {
        this.repository = repository;
    }

    public List<Detalle> listar() {
        return repository.findAll();
    }

    public Detalle obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Detalle guardar(Detalle detalle) {
        return repository.save(detalle);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<Detalle> porVenta(Long idVenta) {
        return repository.findByVentaId(idVenta);
    }
}

