package com.intepy.bancapp.entity;

import jakarta.persistence. *; 

import java.util.List;
import java.util.ArrayList;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Cuenta> cuentas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Prestamo> prestamos = new ArrayList<>();

    // Constructor getters

    //Usando Lombok
    public Usuario() {
    }
    public Long getId() {
        return id;
    }
    // No setter para id, ya que es auto-generado
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    // No setters para nombre y email, asumiendo que son inmutables después de la creación
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    // Constructor setters

    // set nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //set email
    public void setEmail(String email) {
        this.email = email;
    }

    // set cuentas
    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    // set prestamos
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    
}
