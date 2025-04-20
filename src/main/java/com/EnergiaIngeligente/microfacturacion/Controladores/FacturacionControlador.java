package com.EnergiaIngeligente.microfacturacion.Controladores;


import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.FacturacionEntidad;
import com.EnergiaIngeligente.microfacturacion.Servicios.FacturacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionControlador {

    @Autowired
    private FacturacionServicio facturacionServicio;

    @GetMapping
    public List<FacturacionEntidad> obtenerFacturas() {
        return facturacionServicio.obtenerTodasLasFacturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturacionEntidad> obtenerFacturaPorId(@PathVariable UUID id) {
        Optional<FacturacionEntidad> factura = facturacionServicio.obtenerFacturaPorId(id);
        return factura.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FacturacionEntidad crearFactura(@RequestBody FacturacionEntidad factura) {
        return facturacionServicio.crearFactura(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturacionEntidad> actualizarFactura(@PathVariable UUID id, @RequestBody FacturacionEntidad facturaActualizada) {
        return facturacionServicio.actualizarFactura(id, facturaActualizada)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable UUID id) {
        if (facturacionServicio.eliminarFactura(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}