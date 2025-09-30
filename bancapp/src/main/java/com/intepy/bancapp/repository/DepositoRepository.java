package com.intepy.bancapp.repository;

import  org.springframework.data.jpa.repository.JpaRepository;
import com.intepy.bancapp.entity.Deposito;
public interface DepositoRepository extends JpaRepository<Deposito, Long> {

}
