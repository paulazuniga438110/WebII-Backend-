package com.unimayor.TiendaVirtual.Natural_Samada.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "config")
public class Config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer ruc;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(columnDefinition = "TEXT")
    private String direccion;

    @Column(length = 255)
    private String mensaje;

    public Config() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getRuc() { return ruc; }
    public void setRuc(Integer ruc) { this.ruc = ruc; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}

