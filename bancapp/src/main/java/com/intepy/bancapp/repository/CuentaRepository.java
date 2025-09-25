package com.intepy.bancapp.com.intepy.bancapp.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intepy.bancapp.com.intepy.bancapp.bancapp.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
