package com.EnergiaIngeligente.microfacturacion.Servicios;

import com.EnergiaIngeligente.microfacturacion.Persistencia.Entidades.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteRemoteService {

    private final RestTemplate restTemplate;

    public ClienteRemoteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDTO obtenerClientePorCorreo(String correo) {
        String url = "http://localhost:8080/api/admin/clientes/correo/" + correo;
        try {
            ResponseEntity<ClienteDTO> response = restTemplate.getForEntity(url, ClienteDTO.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println("Error consultando cliente por correo: " + e.getMessage());
            return null;
        }
    }
}
