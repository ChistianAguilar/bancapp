package com.intepy.bancapp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class EstadoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion; // aprobado , pendiente, rechazado      

    @OneToMany(mappedBy = "estado")
    private List<Prestamo> prestamos;   
}
