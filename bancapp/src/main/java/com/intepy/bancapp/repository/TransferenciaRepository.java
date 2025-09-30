package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intepy.bancapp.entity.Transferencia;
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

}
