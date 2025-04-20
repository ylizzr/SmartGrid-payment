package com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
public class PagoEntidad {

    @Id
    @GeneratedValue
    @Column(name = "id_pago", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "id_factura", columnDefinition = "uuid", nullable = false)
    private UUID idFactura;

    @Column(name = "monto_pagado", nullable = false)
    private double montoPagado;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago = LocalDateTime.now();

}
