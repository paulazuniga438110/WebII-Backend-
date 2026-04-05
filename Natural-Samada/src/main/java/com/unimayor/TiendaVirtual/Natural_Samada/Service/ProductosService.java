package com.unimayor.TiendaVirtual.Natural_Samada.Service;

import org.springframework.stereotype.Service;
import com.unimayor.TiendaVirtual.Natural_Samada.Repository.ProductosRepository;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Productos;

import java.util.List;

@Service
public class ProductosService {

    private final ProductosRepository productosRepository;

    public ProductosService(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    public List<Productos> obtenerProductos(){
        return productosRepository.findAll();
    }

    public Productos guardarProducto(Productos producto){
        return productosRepository.save(producto);
    }

    public Productos obtenerPorId(Long id){
        return productosRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(Long id){
        productosRepository.deleteById(id);
    }

    public Productos actualizarProducto(Long id, Productos producto){
        producto.setId(id);
        return productosRepository.save(producto);
    }

    public List<Productos> buscarPorNombre(String nombre){
        return productosRepository.buscarPorNombre(nombre);
    }
}