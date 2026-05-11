package com.unimayor.TiendaVirtual.Natural_Samada.Security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generarToken(String correo, String rol) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .subject(correo)
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public String extraerCorreo(String token) {
        return parsearClaims(token).getSubject();
    }

    public String extraerRol(String token) {
        return (String) parsearClaims(token).get("rol");
    }

    public boolean esTokenValido(String token) {
        try {
            parsearClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private Claims parsearClaims(String token) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}