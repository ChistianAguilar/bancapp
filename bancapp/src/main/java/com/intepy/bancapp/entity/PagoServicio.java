package com.intepy.bancapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class PagoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    // Constructor vacío requerido por JPA
    public PagoServicio() {
    }

    public PagoServicio(Double monto, Servicio servicio, Cuenta cuenta) {
        this.monto = monto;
        this.servicio = servicio;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "PagoServicio{" +
                "id=" + id +
                ", monto=" + monto +
                ", servicio=" + servicio +
                ", cuenta=" + cuenta +
                '}';
    }

    
}
