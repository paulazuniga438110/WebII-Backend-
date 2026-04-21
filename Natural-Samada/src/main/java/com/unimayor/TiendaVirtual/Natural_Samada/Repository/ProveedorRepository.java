package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Proveedor;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    List<Proveedor> findByNombreContainingIgnoreCase(String nombre);
}
