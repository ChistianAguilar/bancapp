package com.intepy.bancapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intepy.bancapp.repository.DepositoRepository;

import com.intepy.bancapp.entity.Deposito;
import java.util.List;
import java.util.Optional;
@Service
public class DepositoService {

    @Autowired
    private DepositoRepository depositoRepository;
        
    public List<Deposito> listarDepositos(){
        return depositoRepository.findAll();
    }

    public Optional<Deposito> obtenerDepositoPorId(Long id){
        return depositoRepository.findById(id);
    }

    public Deposito guardarDeposito(Deposito deposito){
        return depositoRepository.save(deposito);
    }

    public Deposito actualizarDeposito(Long id, Deposito depositoActualizado){
        return depositoRepository.findById(id)
            .map(deposito -> {
                deposito.setMonto(depositoActualizado.getMonto());
                return depositoRepository.save(deposito);
            }).orElseThrow(() -> new RuntimeException("Deposito no encontrado con id: " + id));
    }

    public void eliminarDeposito(Long id){
        depositoRepository.deleteById(id);
    }
}
