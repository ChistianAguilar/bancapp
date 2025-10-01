package com.intepy.bancapp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "servicio", cascade = CascadeType.ALL)
    private List<PagoServicio> pagos = new ArrayList<>();
    
    // Constructor vacío
    public Servicios() {
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public List<PagoServicio> getPagos() {
        return pagos;
    }
    
    public void setPagos(List<PagoServicio> pagos) {
        this.pagos = pagos;
    }
}