package com.example.demo.controllers;

import com.example.demo.models.Reserva;
import com.example.demo.repositories.ReservaRepository;
import com.example.demo.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/crear")
    public Reserva crearReserva(@RequestParam Long usuarioId, @RequestParam Long claseId) {
        return reservaService.generarReserva(usuarioId, claseId);
    }

}
