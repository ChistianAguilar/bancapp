package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intepy.bancapp.entity.EstadoPrestamo;  
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long>  {

}
