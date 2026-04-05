package com.unimayor.TiendaVirtual.Natural_Samada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.unimayor.TiendaVirtual.Natural_Samada.Service.ProductosService;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Productos;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosService service;

    @GetMapping
    public List<Productos> listar() {
        return service.obtenerProductos();
    }


    @PostMapping
    public Productos guardar(@RequestBody Productos producto) {
        return service.guardarProducto(producto);
    }
}