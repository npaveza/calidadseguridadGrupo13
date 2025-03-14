package com.example.grupo13.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grupo13.models.Evento;
import com.example.grupo13.services.EventService;


@Controller
@RequestMapping("/evetos")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String listarEventos(Model model){
        List<Evento> events = eventService.listarEventos();
        model.addAttribute("eventos", events);
        return "eventos";
    }
    
    @GetMapping("/{id}")
    public String detalleEvento(@PathVariable Long id, Model model){
        Optional<Evento> events = eventService.obtenerEvento(id);
        model.addAttribute("evento", events.orElse(null));
        return "evento-form";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/nuevo")
    public String eventoNuevo(Model model){
        model.addAttribute("evento", new Evento());
        return "evento-form";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute Evento event){
        eventService.guardarEvento(event);
        return "redirect:/eventos";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/eliminar/{id}")
    public String eliminarEvento(@PathVariable Long id){
        eventService.eliminarEvento(id);
        return "redirect:/eventos";
    }
}