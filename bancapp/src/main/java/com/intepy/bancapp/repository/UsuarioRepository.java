package com.intepy.bancapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intepy.bancapp.entity.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
