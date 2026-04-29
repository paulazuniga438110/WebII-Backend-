package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {
}


