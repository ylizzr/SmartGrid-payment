package com.EnergiaIngeligente.microfacturacion.Persistencia.Repositorios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.PagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagoRepositorio extends JpaRepository<PagoEntidad, UUID> {
}