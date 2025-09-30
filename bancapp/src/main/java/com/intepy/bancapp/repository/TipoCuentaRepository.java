package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intepy.bancapp.entity.TipoCuenta; 
public interface TipoCuentaRepository extends JpaRepository<TipoCuenta, Long> {

}
