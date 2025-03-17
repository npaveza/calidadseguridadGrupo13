package com.example.grupo13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.grupo13.models.Evento;

public interface EventRepository extends JpaRepository<Evento, Long>{
    List<Evento> findByNombreContaining(String categoria);
    List<Evento> findByUbicacionContaining(String ubicacion);
    
}
