package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intepy.bancapp.entity.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Long> {
    // Aquí puedes agregar métodos personalizados de consulta si los necesitas
}