package com.intepy.bancapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.intepy.bancapp.entity.Cuenta;
import com.intepy.bancapp.repository.CuentaRepository;
import org.springframework.stereotype.Service;


@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> listaCentas(){
        return cuentaRepository.findAll();
    }

    public Optional<Cuenta> obtenerCuentaPorId(Long id){
        return cuentaRepository.findById(id);
    }

    public Cuenta guardarCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    public Cuenta actualizarCuenta(Long id, Cuenta cuentaActualizada){
        return cuentaRepository.findById(id)
            .map(cuenta -> {
                cuenta.setNumeroCuenta(cuentaActualizada.getNumeroCuenta());
                cuenta.setSaldo(cuentaActualizada.getSaldo());
                return cuentaRepository.save(cuenta);
            }).orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id: " + id));
    }

    public void eliminarCuenta(Long id){
        cuentaRepository.deleteById(id);
    }

}
