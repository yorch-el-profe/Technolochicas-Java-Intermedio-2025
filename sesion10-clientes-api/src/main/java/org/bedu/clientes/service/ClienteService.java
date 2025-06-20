package org.bedu.clientes.service;

import org.bedu.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Capas de un proyecto de Spring
 * 1. Controller: Se encarga de recibir y responder las peticiones.
 * El controlador sabe cómo obtener la info de las peticiones y puede
 * invocar al servicio.
 * 
 * 2. Service: Se encarga de ejecutar valiciones, lógica de negocio y
 * puede invocar al repositorio.
 * 
 * 3. Repository: Se encarga de realizar consultar a base de datos.
 * 
 * Petición <-> Controller <-> Service <-> Repository
 */

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;
}
