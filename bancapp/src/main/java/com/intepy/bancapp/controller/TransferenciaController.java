package com.intepy.bancapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.intepy.bancapp.entity.Transferencia;
import com.intepy.bancapp.service.TransferenciaService;
@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> listarTransferencias(){
        return transferenciaService.listarTransferencias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transferencia> obtenerTransferencia(@PathVariable Long id){
        return transferenciaService.obtenerTransferenciaPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transferencia crearTransferencia(@RequestBody Transferencia transferencia){
        return transferenciaService.guardarTransferencia(transferencia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transferencia> actualizarTransferencia(@PathVariable Long id, @RequestBody Transferencia transferencia){
        try {
            return ResponseEntity.ok(transferenciaService.actualizarTransferencia(id, transferencia));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransferencia(@PathVariable Long id){
        transferenciaService.eliminarTransferencia(id);
        return ResponseEntity.noContent().build();
    }
}
