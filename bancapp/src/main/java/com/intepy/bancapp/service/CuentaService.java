package com.intepy.bancapp.service;

import java.util.List;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepostory cuentaRepository;

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
                cuenta.setTipoCuenta(cuentaActualizada.getTipoCuenta());
            }).orElseThrow(() -> new RuntimeException("Cuenta no encontrada con id: " + id));
    }

    public void eliminarCuenta(Long id){
        cuentaRepository.deleteById(id);
    }

}
