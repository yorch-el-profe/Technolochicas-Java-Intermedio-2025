package org.bedu.clientes.service;

import org.bedu.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.bedu.clientes.entity.Cliente;

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

    public List<Cliente> obtenerClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> obtenerCliente(int id) {
        return repository.findById(id);
    }

    public Cliente crearCliente(Cliente nuevo) {
        return repository.save(nuevo);
    }

    public void eliminarCliente(int id) {
        repository.deleteById(id);
    }

    public void actualizarCliente(int id, Cliente nuevo) {
        // 1. Buscar al cliente
        Optional<Cliente> busqueda = repository.findById(id);

        if (busqueda.isEmpty()) {
            // Normalmente se arroja una excepción
            System.out.println("El cliente " + id + " no existe");
            return;
        }

        // 2. Cambiarle sus valores
        Cliente viejo = busqueda.get();

        if(nuevo.getNombre() != null) {
            viejo.setNombre(nuevo.getNombre());
        }

        if (nuevo.getApellido() != null) {
            viejo.setApellido(nuevo.getApellido());
        }

        // 3. Actualizar
        repository.save(viejo);
    }
}
