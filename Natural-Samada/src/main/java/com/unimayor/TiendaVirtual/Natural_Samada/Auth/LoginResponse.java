package com.unimayor.TiendaVirtual.Natural_Samada.Auth;

public class LoginResponse {
    private String token;
    private String correo;
    private String nombre;
    private String rol;

    public LoginResponse(String token, String correo, String nombre, String rol) {
        this.token = token;
        this.correo = correo;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getToken() { return token; }
    public String getCorreo() { return correo; }
    public String getNombre() { return nombre; }
    public String getRol() { return rol; }
}