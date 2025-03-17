package com.example.grupo13.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.grupo13.models.Evento;
import com.example.grupo13.services.EventService;

@Controller
public class EventController {
    private final EventService eventoService;

    public EventController(EventService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping("/eventos")
    public String listEvents(@RequestParam(required=false) String nombre,
                            @RequestParam(required=false) String fecha,
                            @RequestParam(required=false) String ubicacion,
                            Model model
                            ) {
        List<Evento> eventos;
        if (nombre != null && !nombre.isEmpty()) {
            eventos = eventoService.buscarEventosPorNombre(nombre);
        } else if (ubicacion != null && !ubicacion.isEmpty()) {
            eventos = eventoService.buscarEventosPorUbicacion(ubicacion);
        } else {
            eventos = eventoService.listarEventos();
        }
        model.addAttribute("eventos", eventos);
        return "eventos";
    }
}