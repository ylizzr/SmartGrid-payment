package com.EnergiaIngeligente.microfacturacion.Persistencia.Repositorios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.FacturacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FacturacionRepositorio extends JpaRepository<FacturacionEntidad, UUID> {
    List<FacturacionEntidad> findByIdCliente(String idCliente);



}