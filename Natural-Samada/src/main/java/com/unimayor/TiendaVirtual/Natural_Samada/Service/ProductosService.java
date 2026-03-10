package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.ProductosRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Productos;

import java.util.List;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Productos> obtenerProductos(){
        return productosRepository.findAll();
    }

    public Productos guardarProducto(Productos producto){
        return productosRepository.save(producto);
    }

}
