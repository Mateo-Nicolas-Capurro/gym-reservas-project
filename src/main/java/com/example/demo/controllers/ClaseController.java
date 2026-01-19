package com.example.demo.controllers;

import com.example.demo.models.Clase;
import com.example.demo.repositories.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    @Autowired
    private ClaseRepository claseRepository;
    // GET: Obtener todas las clases
    @GetMapping
    public List<Clase> listar() {
        return claseRepository.findAll();
    }

    // POST: Crear una clase nueva
    @PostMapping
    public Clase guardar(@RequestBody Clase clase) {
        return claseRepository.save(clase);
    }

    // DELETE: Borrar una clase (como el que hiciste para localización)
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        claseRepository.deleteById(id);
    }
}
