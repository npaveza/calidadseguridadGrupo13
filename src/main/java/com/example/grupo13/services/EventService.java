package com.example.grupo13.services;

import java.util.List;
import java.util.Optional;

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

    public Optional<Evento> obtenerEvento(Long id) {
        return eventRepository.findById(id);
    }
    
    public void guardarEvento(Evento event) {
        eventRepository.save(event);
    }

    public void eliminarEvento(Long id) {
        eventRepository.deleteById(id);
    }
}
