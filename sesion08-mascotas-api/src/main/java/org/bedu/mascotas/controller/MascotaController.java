package org.bedu.mascotas.controller;

import java.util.LinkedList;
import java.util.List;

import org.bedu.mascotas.model.Mascota;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    private List<Mascota> baseDatos = new LinkedList<>();

    // CRUD: Create, Read, Update, Delete
    /**
     * Cuando se hace un CRUD se utilizan los métodos de HTTP
     * para representar las distintas operaciones.
     * 
     * GET -> Leer datos
     * POST -> Crear
     * PUT -> Actualizar (o reeemplazar)
     * DELETE -> Eliminar
     * 
     * Los nombres de las URLs sean sustantivos
     * 
     * /obtenerCarros -> GET /carros
     * /crearCarro -> POST /carros
     * /actualizarCarro  -> PUT /carros
     * 
     * 
     * Suponiendo un API de una escuela
     * 
     *  GET /alumnos/selena/calificaciones -> 
     *      Obtener las calificaciones del alumno Selena
     */
    
    // 1. Obtener todas las mascotas (Read)
    @GetMapping("/mascotas")
    public List<Mascota> obtener() {
        return baseDatos;
    }

    // 2. Agregar una nueva mascota (Create)
    /*
     * Es una buena práctica que el endpoint
     * que se encarga de crear cosas, regrese lo que ha creado
     */
    @PostMapping("/mascotas")
    public Mascota agregar(@RequestBody Mascota nueva) {
        baseDatos.add(nueva);
        return nueva;
    }
}
