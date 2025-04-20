package com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "facturacion")
public class FacturacionEntidad {

    @Id
    @Column(name = "id_factura", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "id_cliente", columnDefinition = "character varying(255)")
    private String idCliente; // Cambiar de UUID a String

    @Column(name = "consumo_total")
    private double consumoTotal;

    @Column(name = "costo_total")
    private double costoTotal;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "estado_pago")
    private String estadoPago; // pendiente, pagado

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "periodo_facturado")
    private String periodoFacturado; // formato: 2025-04

    // Getters y Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getPeriodoFacturado() {
        return periodoFacturado;
    }

    public void setPeriodoFacturado(String periodoFacturado) {
        this.periodoFacturado = periodoFacturado;
    }
}