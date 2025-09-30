package com.intepy.bancapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intepy.bancapp.entity.PagoServicio;
import com.intepy.bancapp.repository.PagoServicioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
@Service
public class PagoServicioService {

    @Autowired
    private PagoServicioRepository pagoServicioRepository;

    public List<PagoServicio> listarPagos(){
        return pagoServicioRepository.findAll();
    }   

    public Optional<PagoServicio> obtenerPagoPorId(Long id){
        return pagoServicioRepository.findById(id);
    }

    public PagoServicio guardarPago(PagoServicio pagoServicio){
        return pagoServicioRepository.save(pagoServicio);
    }

    public PagoServicio actualizarPago(Long id, PagoServicio pagoServicioActualizado){
        return pagoServicioRepository.findById(id)
            .map(pagoServicio -> {
                pagoServicio.setMonto(pagoServicioActualizado.getMonto());
                pagoServicio.setCuenta(pagoServicioActualizado.getCuenta());
                pagoServicio.setServicio(pagoServicioActualizado.getServicio());
                return pagoServicioRepository.save(pagoServicio);
            }).orElseThrow(() -> new RuntimeException("Pago no encontrado con id: " + id));
    }

    public void eliminarPago(Long id){
        pagoServicioRepository.deleteById(id);
    }

}
