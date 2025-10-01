package com.intepy.bancapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.intepy.bancapp.entity.Servicios;
import com.intepy.bancapp.repository.ServiciosRepository;
import java.util.List;

@Service
public class ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    public List<Servicios> listarServicios() {
        return serviciosRepository.findAll();
    }

    public Servicios obtenerServicioPorId(Long id) {
        return serviciosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Servicio no encontrado con id: " + id));
    }

    public Servicios guardarServicio(Servicios servicio){
        return serviciosRepository.save(servicio);
    }

    public Servicios actualizarServicio(Long id, Servicios servicioActualizado){
        return serviciosRepository.findById(id)
            .map(servicio -> {
                servicio.setNombre(servicioActualizado.getNombre());
                servicio.setDescripcion(servicioActualizado.getDescripcion());
                return serviciosRepository.save(servicio);
            }).orElseThrow(() -> new RuntimeException("Servicio no encontrado con id: " + id));
    }

    public void eliminarServicio(Long id){
        serviciosRepository.deleteById(id);
    }
}
