package com.intepy.bancapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intepy.bancapp.repository.TransferenciaRepository;
import com.intepy.bancapp.entity.Transferencia;
import java.util.List;
@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> listarTransferencias(){
        return transferenciaRepository.findAll();
    }

    public java.util.Optional<Transferencia> obtenerTransferenciaPorId(Long id){
        return transferenciaRepository.findById(id);
    }

    public Transferencia guardarTransferencia(Transferencia transferencia){
        return transferenciaRepository.save(transferencia);
    }

    public Transferencia actualizarTransferencia(Long id, Transferencia transferenciaActualizada){
        return transferenciaRepository.findById(id)
            .map(transferencia -> {
                transferencia.setMonto(transferenciaActualizada.getMonto());
                transferencia.setCuentaOrigen(transferenciaActualizada.getCuentaOrigen());
                transferencia.setCuentaDestino(transferenciaActualizada.getCuentaDestino());
                return transferenciaRepository.save(transferencia);
            }).orElseThrow(() -> new RuntimeException("Transferencia no encontrada con id: " + id));
    }

    public void eliminarTransferencia(Long id){
        transferenciaRepository.deleteById(id);
    }

    
}
