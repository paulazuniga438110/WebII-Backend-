package com.unimayor.TiendaVirtual.Natural_Samada.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detalle")
public class Detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pro", referencedColumnName = "id")
    private Productos productos;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @JsonBackReference
    private Ventas venta;

    public Detalle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Productos getProductos() { return productos; }
    public void setProductos(Productos productos) { this.productos = productos; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Ventas getVenta() { return venta; }
    public void setVenta(Ventas venta) { this.venta = venta; }
}


