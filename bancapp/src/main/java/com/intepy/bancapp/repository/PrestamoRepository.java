package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intepy.bancapp.entity.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
