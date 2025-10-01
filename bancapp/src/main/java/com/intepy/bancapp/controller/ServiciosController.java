package com.intepy.bancapp.controller;

import com.intepy.bancapp.entity.Servicios;
import com.intepy.bancapp.service.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServiciosController {

    @Autowired
    private ServiciosService serviciosService;

    @GetMapping
    public List<Servicios> obtenerServicios() {
        return serviciosService.listarServicios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicios> obtenerServicio(@PathVariable Long id) {
        try {
            Servicios servicio = serviciosService.obtenerServicioPorId(id);
            return ResponseEntity.ok(servicio);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Servicios> crearServicio(@RequestBody Servicios servicio) {
        return ResponseEntity.ok(serviciosService.guardarServicio(servicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicios> actualizarServicio(@PathVariable Long id, @RequestBody Servicios servicio) {
        try {
            return ResponseEntity.ok(serviciosService.actualizarServicio(id, servicio));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable Long id) {
        try {
            serviciosService.eliminarServicio(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}