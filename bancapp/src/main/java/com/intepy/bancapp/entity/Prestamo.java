package com.intepy.bancapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;   

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPrestamo estado;


    // Constructor vacío requerido por JPA
    public Prestamo() {}

    // Getters

    // Para long
    public Long getId() {
        return id;
    }
    // Para Monto
    public Double getMonto() {
        return monto;
    }
    // Para Usuario
    public Usuario getUsuario() {
        return usuario;
    }
    // Para Estado
    public EstadoPrestamo getEstado() {
        return estado;
    }

    // Setters

    // Para long
    public void setId(Long id) {
        this.id = id;
    }

    // Para Monto
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    // Para Usuario
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Para Estado
    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

}
