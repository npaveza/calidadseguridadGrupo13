package com.example.grupo13.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.grupo13.models.Evento;


@Controller
@RequestMapping("eventos")
public interface EventRepository extends JpaRepository<Evento, Long>{
    List<Evento> findByCategoria(String categoria);
    List<Evento> findByOrganizador(String organizador);
    
}
