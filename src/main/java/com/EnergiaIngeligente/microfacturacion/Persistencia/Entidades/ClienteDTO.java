package com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClienteDTO {
    private String id;
    private String nombre;
    private String correo;
    private String numeroCuenta;
}
