package com.intepy.bancapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;

@Entity
public class Transferencia {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Double monto;   

    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    private Cuenta cuentaOrigen;

    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private Cuenta cuentaDestino;

    // Constructor vacío requerido por JPA
    public Transferencia() {}

    // Getters

    // Para long
    public Long getId() {
        return id;
    }

    // Para Monto
    public Double getMonto() {
        return monto;
    }

    // Para Cuenta Origen
    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    // Para Cuenta Destino
    public Cuenta getCuentaDestino() {
        return cuentaDestino;
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

    // Para Cuenta Origen
    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    // Para Cuenta Destino
    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

}
