package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intepy.bancapp.entity.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {

}
