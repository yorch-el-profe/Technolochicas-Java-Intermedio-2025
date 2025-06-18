package org.bedu.nesflis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * titulo -> String
 * genero -> String
 * director -> String
 * año -> int
 * 
 * Una entidad de JPA = Una tabla de SQL
 */

// @Entity le indica a Spring que ésto es una entidad de JPA (una tabla de SQL)
@Entity
public class Pelicula {

    /*
     * Es un atributo/campo especial que me ayudará a identificar de manera única
     * cada registro de "Pelicula".
     * 
     * Nota: Esto sería en teoría de base de datos una "LLAVE PRIMARIA"
     * 
     * @Id indica que ese atributo/campo es un identificador (primary key)
     * 
     * @GeneratedValue le asigna un valor en autómatico en cada inserción
     * 
     * Nota 2: Todos los atributos DEBEN de tener getter/setter
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String genero;
    private String director;
    private int año;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
