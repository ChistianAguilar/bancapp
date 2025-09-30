package com.intepy.bancapp.entity;

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

    public OrigenDeposito() {
    }

    public OrigenDeposito(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }   

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    @Override
    public String toString() {
        return "OrigenDeposito [id=" + id + ", descripcion=" + descripcion + "]";
    }

    
}
