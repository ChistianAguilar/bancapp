package com.intepy.bancapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.intepy.bancapp.repository.PrestamoRepository;
import com.intepy.bancapp.entity.Prestamo;
import org.springframework.stereotype.Service; 

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> listarPrestamo(){
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPrestamoPorId(Long id){
        return prestamoRepository.findById(id);
    }

    public Prestamo guardarPrestamo(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    public Prestamo actualizarPrestamo(Long id, Prestamo prestamoActualizado){
        return prestamoRepository.findById(id)
            .map(prestamo -> {
                prestamo.setMonto(prestamoActualizado.getMonto());
                prestamo.setEstado(prestamoActualizado.getEstado());
                return prestamoRepository.save(prestamo);
            }).orElseThrow(() -> new RuntimeException("Prestamo no encontrado con id: " + id));
    }

    public void eliminarPrestamo(Long id){
        prestamoRepository.deleteById(id);
    }
}
