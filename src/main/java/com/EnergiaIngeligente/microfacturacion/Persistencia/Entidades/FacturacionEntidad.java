package com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "facturas")
@Getter
@Setter
public class FacturacionEntidad {

    @Id
    @GeneratedValue
    @Column(name = "id_factura", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "id_cliente", columnDefinition = "character varying(255)")
    private String idCliente;

    @Column(name = "consumo_total")
    private double consumoTotal;

    @Column(name = "costo_total")
    private double costoTotal;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision = LocalDateTime.now();

    @Column(name = "estado_pago")
    private String estadoPago = "pendiente";


    @Column(name = "periodo_facturado")
    private String periodoFacturado; // formato: 2025-04
}