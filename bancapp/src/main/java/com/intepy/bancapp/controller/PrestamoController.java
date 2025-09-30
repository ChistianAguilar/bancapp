package com.intepy.bancapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.intepy.bancapp.entity.Prestamo;
import com.intepy.bancapp.service.PrestamoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {


    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> obtenerPrestamos(){
        return prestamoService.listarPrestamo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamoPorId(@PathVariable Long id){
        Optional<Prestamo> prestamo = prestamoService.obtenerPrestamoPorId(id);
        return prestamo.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Prestamo> crearPrestamo(@RequestBody Prestamo prestamo){
        Prestamo nuevoPrestamo = prestamoService.guardarPrestamo(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPrestamo);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo){
        try {
            Prestamo prestamoActualizado = prestamoService.actualizarPrestamo(id, prestamo);
            return ResponseEntity.ok(prestamoActualizado);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Long id){
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }


}
