package com.intepy.bancapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "origen_id")
    private OrigenDeposito origen;


    // Constructor vacío requerido por JPA
    public Deposito() {
    }

    // Getters

    // Para long id
    public Long getId() {
        return id;
    }
 
    // Para Double monto
    public Double getMonto() {
        return monto;
    }

   // Para Cuenta
   public Cuenta getCuanenta(){
    return cuenta;
   }

   // Para Origen
    public OrigenDeposito getOrigen(){
     return origen;
    }

    // Setters
    public void setId(Long id){
    }
    
    // Para Monto
    public void setMonto(Double montoDouble){
        this.monto = montoDouble;
    }   

    // Para Cuenta
    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;   
    }

    // Para Origen
    public void setOrigenDeposito(OrigenDeposito origen){
        this.origen= origen;
    }

    
}
