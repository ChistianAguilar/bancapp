package com.intepy.bancapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.intepy.bancapp.entity.Servicio;
import com.intepy.bancapp.repository.ServicioRepository;

import java.util.List;

@Service
@Transactional
public class ServicioService {

    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado con id: " + id));
    }

    public Servicio guardarServicio(Servicio servicio) {
        if (servicio.getNombre() == null || servicio.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre del servicio no puede estar vacío");
        }
        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Long id, Servicio servicioActualizado) {
        if (servicioActualizado.getNombre() == null || servicioActualizado.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre del servicio no puede estar vacío");
        }
        
        return servicioRepository.findById(id)
            .map(servicio -> {
                servicio.setNombre(servicioActualizado.getNombre());
                servicio.setDescripcion(servicioActualizado.getDescripcion());
                return servicioRepository.save(servicio);
            }).orElseThrow(() -> new RuntimeException("Servicio no encontrado con id: " + id));
    }

    public void eliminarServicio(Long id) {
        Servicio servicio = obtenerServicioPorId(id);
        if (!servicio.getPagos().isEmpty()) {
            throw new RuntimeException("No se puede eliminar el servicio porque tiene pagos asociados");
        }
        servicioRepository.deleteById(id);
    }
}