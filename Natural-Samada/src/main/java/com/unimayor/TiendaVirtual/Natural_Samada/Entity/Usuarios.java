package com.unimayor.TiendaVirtual.Natural_Samada.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Column(nullable = false, unique = true, length = 200)
    private String correo;

    @Column(nullable = false, length = 50)
    private String pass;

    @Column(nullable = false, length = 20)
    private String rol;

    public Usuarios() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}

