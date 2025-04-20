package com.EnergiaIngeligente.microfacturacion.Servicios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.PagoEntidad;
import com.EnergiaIngeligente.microfacturacion.Persistencia.Repositorios.PagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PagoServicio {

    @Autowired
    private PagoRepositorio pagoRepositorio;

    public List<PagoEntidad> obtenerTodosLosPagos() {
        return pagoRepositorio.findAll();
    }

    public Optional<PagoEntidad> obtenerPagoPorId(UUID id) {
        return pagoRepositorio.findById(id);
    }

    public PagoEntidad realizarPago(PagoEntidad pago) {
        return pagoRepositorio.save(pago);
    }

    public boolean eliminarPago(UUID id) {
        if (pagoRepositorio.existsById(id)) {
            pagoRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}