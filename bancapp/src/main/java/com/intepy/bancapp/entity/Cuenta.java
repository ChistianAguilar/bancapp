package com.intepy.bancapp.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroCuenta;
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tipo_cuenta_id")
    private TipoCuenta tipoCuenta;
    
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    private List <Deposito> depositos = new ArrayList<>();

    @OneToMany(mappedBy = "cuentaOrigen")
    private List <Transferencia> transferenciasOrigen = new ArrayList<>();

    @OneToMany(mappedBy = "cuentaDestino")
    private List <Transferencia> transferenciasdestino = new ArrayList<>();

    // Constructor vacío requerido por JPA
    public Cuenta() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    public List<Transferencia> getTransferenciasOrigen() {
        return transferenciasOrigen;
    }

    public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
        this.transferenciasOrigen = transferenciasOrigen;
    }

    public List<Transferencia> getTransferenciasdestino() {
        return transferenciasdestino;
    }

    public void setTransferenciasdestino(List<Transferencia> transferenciasdestino) {
        this.transferenciasdestino = transferenciasdestino;
    }
}
