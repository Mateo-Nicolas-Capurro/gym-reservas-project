package com.example.demo.controllers;

import com.example.demo.dtos.LoginRequestDtos;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    // Obtener todos los socios
    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    // Registrar un nuevo socio
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDtos loginRequest) {
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginRequest.getEmail()) &&
                        u.getPassword().equals(loginRequest.getPassword()))
                .findFirst()
                .map(usuario -> ResponseEntity.ok(usuario)) // Si coincide, devolvemos el usuario
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()); // Si no, error 401
    }
}
