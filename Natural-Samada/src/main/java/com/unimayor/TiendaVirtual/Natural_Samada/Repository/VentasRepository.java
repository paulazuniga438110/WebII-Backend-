package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Ventas;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    @Query("SELECT DISTINCT d.venta FROM Detalle d WHERE d.producto.id = :idProducto")
    List<Ventas> findByProductoId(@Param("idProducto") Long idProducto);

}
