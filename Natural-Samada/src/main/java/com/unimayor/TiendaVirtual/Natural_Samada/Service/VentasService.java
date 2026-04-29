package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.VentasRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Ventas;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Detalle;

import java.util.List;

@Service
public class VentasService {

    private final VentasRepository repository;

    public VentasService(VentasRepository repository) {
        this.repository = repository;
    }

    public List<Ventas> listar() {
        return repository.findAll();
    }

    public Ventas obtener(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Ventas guardar(Ventas venta) {
        if (venta.getDetalles() != null && !venta.getDetalles().isEmpty()) {
            // Vincular cada detalle con la venta
            for (Detalle d : venta.getDetalles()) {
                d.setVenta(venta);
            }

            // Calcular el total automaticamente
            double total = venta.getDetalles()
                    .stream()
                    .mapToDouble(d -> d.getCantidad() * d.getPrecio())
                    .sum();

            venta.setTotal(total);
        }

        return repository.save(venta);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

