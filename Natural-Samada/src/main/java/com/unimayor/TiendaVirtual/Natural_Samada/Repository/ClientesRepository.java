package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Clientes;

import java.util.List;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    List<Clientes> findByNombreContainingIgnoreCase(String nombre);

}
