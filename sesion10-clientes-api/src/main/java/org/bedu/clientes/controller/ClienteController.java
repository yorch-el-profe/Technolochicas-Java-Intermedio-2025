package org.bedu.clientes.controller;

import java.util.List;
import java.util.Optional;

import org.bedu.clientes.entity.Cliente;
import org.bedu.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    // 1. Obtener todos los clientes (GET /clientes)
    @GetMapping
    public List<Cliente> obtenerClientes() {
        return service.obtenerClientes();
    }

    // 2. Obtener un cliente por ID (GET /clientes/:id)
    // Nota: Los ":" significan que ese pedazo de URL es una "variable"
    // Es decir:    /clientes/20     /alumnos/brenda
    @GetMapping(":id")
    public Optional<Cliente> obtenerCliente(@PathParam("id") int id) {
        return service.obtenerCliente(id);
    }

    // 3. Crear un cliente (POST /clientes)
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente nuevo) {
        return service.crearCliente(nuevo);
    }

    // 4. Actualizar un cliente (PUT /clientes/:id)
    @PutMapping(":id")
    public void actualizarCliente(@PathParam("id") int id, @RequestBody Cliente nuevo) {
        service.actualizarCliente(id, nuevo);
    }

    // 5. Eliminar un cliente por ID (DELETE /clientes/:id)
    @DeleteMapping(":id")
    public void eliminarCliente(@PathParam("id") int id) {
        service.eliminarCliente(id);
    }
}
