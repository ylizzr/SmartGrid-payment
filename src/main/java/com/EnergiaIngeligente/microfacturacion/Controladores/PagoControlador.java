package com.EnergiaIngeligente.microfacturacion.Controladores;


import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.PagoEntidad;
import com.EnergiaIngeligente.microfacturacion.Servicios.PagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/pagos")
public class PagoControlador {

    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping
    public List<PagoEntidad> obtenerPagos() {
        return pagoServicio.obtenerTodosLosPagos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoEntidad> obtenerPagoPorId(@PathVariable UUID id) {
        Optional<PagoEntidad> pago = pagoServicio.obtenerPagoPorId(id);
        return pago.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PagoEntidad realizarPago(@RequestBody PagoEntidad pago) {
        return pagoServicio.realizarPago(pago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable UUID id) {
        if (pagoServicio.eliminarPago(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}