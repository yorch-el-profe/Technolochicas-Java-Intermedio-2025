package org.bedu.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller: Transmitir datos y páginas web
// @RestController: Transmitir datos

// Un controlador es un conjunto de puntos de entrada
// (endpoints)

@RestController
public class MiPrimerController {

    // Definiendo un endpoint con ruta "/helloworld"
    // Para comunicarse con éste endpoint
    // se debe enviar una petición a: "http://localhost:8080/helloworld"
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }
}
