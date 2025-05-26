package com.EnergiaIngeligente.microfacturacion.Controladores;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.ClienteDTO;
import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.FacturacionEntidad;
import com.EnergiaIngeligente.microfacturacion.Servicios.ClienteRemoteService;
import com.EnergiaIngeligente.microfacturacion.Servicios.FacturacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ClienteRemoteService clienteRemoteService;

    @GetMapping("/mis-facturas")
    public ResponseEntity<List<FacturacionEntidad>> obtenerFacturasCliente(@RequestParam String correo) {
        ClienteDTO cliente = clienteRemoteService.obtenerClientePorCorreo(correo.trim());
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<FacturacionEntidad> facturas = facturacionServicio.obtenerFacturasPorClienteId(cliente.getId());
        return ResponseEntity.ok(facturas);
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