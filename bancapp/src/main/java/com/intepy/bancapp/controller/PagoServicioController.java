package com.intepy.bancapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.intepy.bancapp.entity.PagoServicio;
import com.intepy.bancapp.service.PagoServicioService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/pagos-servicios")
public class PagoServicioController {

    @Autowired
    private PagoServicioService pagoServicioService;

    @GetMapping
    public List<PagoServicio> listarPagos(){
        return pagoServicioService.listarPagos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoServicio> obtenerPago(@PathVariable Long id){
        return pagoServicioService.obtenerPagoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PagoServicio crearPago(@RequestBody PagoServicio pago){
        return pagoServicioService.guardarPago(pago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoServicio> actualizarPago(@PathVariable Long id, @RequestBody PagoServicio pago){
        try {
            return ResponseEntity.ok(pagoServicioService.actualizarPago(id, pago));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id){
        pagoServicioService.eliminarPago(id);
        return ResponseEntity.noContent().build();  
    }
    
}
