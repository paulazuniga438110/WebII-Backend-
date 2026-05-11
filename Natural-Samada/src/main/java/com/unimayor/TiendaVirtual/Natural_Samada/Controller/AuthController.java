package com.unimayor.TiendaVirtual.Natural_Samada.Controller;

import com.unimayor.TiendaVirtual.Natural_Samada.Auth.LoginRequest;
import com.unimayor.TiendaVirtual.Natural_Samada.Auth.LoginResponse;
import com.unimayor.TiendaVirtual.Natural_Samada.Entity.Usuarios;
import com.unimayor.TiendaVirtual.Natural_Samada.Security.JwtUtil;
import com.unimayor.TiendaVirtual.Natural_Samada.Service.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuariosService usuariosService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuariosService usuariosService,
                          JwtUtil jwtUtil,
                          PasswordEncoder passwordEncoder) {
        this.usuariosService = usuariosService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Usuarios usuario = usuariosService.buscarPorCorreo(request.getCorreo());

        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Correo o contraseña incorrectos");
        }

        if (!passwordEncoder.matches(request.getPass(), usuario.getPass())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Correo o contraseña incorrectos");
        }

        String token = jwtUtil.generarToken(usuario.getCorreo(), usuario.getRol());

        return ResponseEntity.ok(new LoginResponse(
                token,
                usuario.getCorreo(),
                usuario.getNombre(),
                usuario.getRol()
        ));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuarios nuevoUsuario) {
        if (usuariosService.buscarPorCorreo(nuevoUsuario.getCorreo()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("El correo ya está registrado");
        }

        nuevoUsuario.setPass(passwordEncoder.encode(nuevoUsuario.getPass()));

        if (nuevoUsuario.getRol() == null || nuevoUsuario.getRol().isEmpty()) {
            nuevoUsuario.setRol("USER");
        }

        Usuarios guardado = usuariosService.guardar(nuevoUsuario);
        String token = jwtUtil.generarToken(guardado.getCorreo(), guardado.getRol());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new LoginResponse(
                        token,
                        guardado.getCorreo(),
                        guardado.getNombre(),
                        guardado.getRol()
                ));
    }
}