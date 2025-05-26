package com.EnergiaIngeligente.microfacturacion.Servicios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.FacturacionEntidad;
import com.EnergiaIngeligente.microfacturacion.Persistencia.Repositorios.FacturacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FacturacionServicio {

    @Autowired
    private FacturacionRepositorio facturacionRepositorio;

    public List<FacturacionEntidad> obtenerTodasLasFacturas() {
        return facturacionRepositorio.findAll();
    }

    public Optional<FacturacionEntidad> obtenerFacturaPorId(UUID id) {
        return facturacionRepositorio.findById(id);
    }

    public FacturacionEntidad crearFactura(FacturacionEntidad factura) {
        return facturacionRepositorio.save(factura);
    }
    public List<FacturacionEntidad> obtenerFacturasPorClienteId(String idCliente) {
        return facturacionRepositorio.findByIdCliente(idCliente);
    }


    public Optional<FacturacionEntidad> actualizarFactura(UUID id, FacturacionEntidad facturaActualizada) {
        return facturacionRepositorio.findById(id)
                .map(factura -> {
                    factura.setConsumoTotal(facturaActualizada.getConsumoTotal());
                    factura.setCostoTotal(facturaActualizada.getCostoTotal());
                    factura.setEstadoPago(facturaActualizada.getEstadoPago());
                    factura.setPeriodoFacturado(facturaActualizada.getPeriodoFacturado());
                    return facturacionRepositorio.save(factura);
                });
    }

    public boolean eliminarFactura(UUID id) {
        if (facturacionRepositorio.existsById(id)) {
            facturacionRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}