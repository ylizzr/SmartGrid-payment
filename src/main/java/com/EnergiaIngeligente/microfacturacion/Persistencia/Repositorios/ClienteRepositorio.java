package com.EnergiaIngeligente.microfacturacion.Persistencia.Repositorios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.ClienteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteEntidad, String> {
    // Métodos personalizados opcionales
}