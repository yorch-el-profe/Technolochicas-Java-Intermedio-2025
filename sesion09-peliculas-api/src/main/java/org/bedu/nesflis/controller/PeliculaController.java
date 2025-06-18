package org.bedu.nesflis.controller;

import java.util.List;

import org.bedu.nesflis.entity.Pelicula;
import org.bedu.nesflis.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeliculaController {

    // Spring Core utiliza algo llamado "IoC" (Inversion of Control)
    // IoC es una herramienta que administra las instancias
    // de los objetos que usa Spring. Es decir, NOSOTROS NO USAMOS NEW
    // EN LAS CLASES DE SPRING (Controller, Service, Repository, etc...)


    // Para pedir una instancia del repositorio, se usa @Autowired
    // Nota: Se usa @Autowired por cada instancia
    @Autowired
    private PeliculaRepository repo;
    
    @GetMapping("peliculas")
    public List<Pelicula> obtenerPeliculas() {
        return repo.findAll();
    }

    @PostMapping("peliculas")
    public Pelicula crearPelicula(@RequestBody Pelicula nueva) {
        Pelicula guardada = repo.save(nueva);
        return guardada;
    }
}

/*
    class A {
        public A(B b) {
            this.b = b;
        }
    }

    class B {
        public B(C c) {
            this.c = c;
        }
    }

    class C {
        public C(D d) {}
    }

    A obj = new A(new B(new C(new D())));


    Spring utiliza un patrón llamado "Dependency Injection (DI)"
    para resolver éste problema.

    Dependency Injection es "pedir" a la clase lo que necesito
    y que el IoC me de la instancia automáticamente.

 */