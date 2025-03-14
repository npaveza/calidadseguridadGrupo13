package com.example.grupo13.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String categoria;
    private String direccion;
    private LocalDateTime fechahora;
    private String organizador;

    private boolean estacionamiento;
    private boolean locomocion;
    private boolean comidas;
    private boolean alojamiento;
}
