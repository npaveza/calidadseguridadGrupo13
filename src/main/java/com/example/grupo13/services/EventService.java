package com.example.grupo13.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.grupo13.models.Evento;
import com.example.grupo13.repositories.EventRepository;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Evento> listarEventos() {
        return eventRepository.findAll();
    }
    
    public void guardarEvento(Evento event) {
        eventRepository.save(event);
    }

    public List<Evento> buscarEventosPorNombre(String nombre) {
        return eventRepository.findByNombreContaining(nombre);
    }

    public List<Evento> buscarEventosPorUbicacion(String ubicacion) {
        return eventRepository.findByUbicacionContaining(ubicacion);
    }
}
