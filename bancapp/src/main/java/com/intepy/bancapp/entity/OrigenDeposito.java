package com.intepy.bancapp.bancapp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class OrigenDeposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion; // aprobado , pendiente, rechazado

    @OneToMany(mappedBy = "origen")
    private List<Deposito> depositos;


}
