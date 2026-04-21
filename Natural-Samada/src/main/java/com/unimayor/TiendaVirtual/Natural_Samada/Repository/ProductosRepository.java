package com.unimayor.TiendaVirtual.Natural_Samada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Productos;

import java.util.List;

public interface ProductosRepository extends JpaRepository<Productos, Long> {

    @Query("SELECT p FROM Productos p WHERE LOWER(p.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Productos> buscarPorNombre(@Param("nombre") String nombre);

}

