package com.intepy.bancapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.intepy.bancapp.entity.Deposito;
import com.intepy.bancapp.service.DepositoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/api/depositos")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    @GetMapping
    public List<Deposito> listarDepositos(){
        return depositoService.listarDepositos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposito> obtenerDeposito(@PathVariable Long id){
        return depositoService.obtenerDepositoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deposito crearDeposito(@RequestBody Deposito deposito){
        return depositoService.guardarDeposito(deposito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deposito> actualizarDeposito(@PathVariable Long id, @RequestBody Deposito deposito){
        try {
            return ResponseEntity.ok(depositoService.actualizarDeposito(id, deposito));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDeposito(@PathVariable Long id){
        depositoService.eliminarDeposito(id);
        return ResponseEntity.noContent().build();
    }

    
}
