package com.example.demo.services;

import com.example.demo.models.Clase;
import com.example.demo.models.Reserva;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.ClaseRepository;
import com.example.demo.repositories.ReservaRepository;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ClaseRepository claseRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Reserva generarReserva(Long usuarioId, Long claseId){
        //Buscar clase y usuario
        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrada"));
        //verificar cupo
        if(clase.getCapacidadMaxima()<= 0){
            throw new RuntimeException("Lo sentimos, no quedan cupos para esta clase");
        }
        //restar un cupo a la clase
        clase.setCapacidadMaxima(clase.getCapacidadMaxima()-1);
        claseRepository.save(clase);

        //crear y guardar la reserva
        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setUsuario(usuarioRepository.getReferenceById(usuarioId));
        nuevaReserva.setClase(clase);
        nuevaReserva.setFechaReserva(LocalDate.now());

        return  reservaRepository.save(nuevaReserva);
    }
}
