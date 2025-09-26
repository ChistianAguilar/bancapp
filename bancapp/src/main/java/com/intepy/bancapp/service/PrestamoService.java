package com.intepy.bancapp.service;

import jav.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> listaPrestamo(){
        return prestamoRepository.findAll();
    }

    public Optional<Prestamo> obtenerPrestamoPorId(Long id){
        return prestamoRepository.findById(id);
    }

    public Prestamo guardarPrestamo(Prestamo prestamo){
        return prestamoRepository.findById(prestamo);
    }

    public Prestamo actualizarPrestamo(Long id, Prestamo prestamoActualizado){
        return prestamoRepository.findById(id)
            .map(prestamo -> {
                prestamo.setMonto(prestamoActualizado.getMonto());
                prestamo.setInteres(prestamoActualizado.getInteres());
                return prestamoRepository.save(prestamo);
            }).orElseThrow(() -> new RuntimeException("Prestamo no encontrado con id: " + id));
    }

    public void eliminarCuenta(Long id){
        prestamoRepository.deleteById(id);
    }
}
