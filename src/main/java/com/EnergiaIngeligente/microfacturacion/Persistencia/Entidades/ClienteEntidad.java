package com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes") // Mapeo a la tabla "clientes"
@Getter
@Setter
@NoArgsConstructor
public class ClienteEntidad {

    @Id
    @Column(name = "id", nullable = false) // Clave primaria
    private String id; // Cambiado de UUID a String

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "usuario_id")
    private String usuarioId;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;
}