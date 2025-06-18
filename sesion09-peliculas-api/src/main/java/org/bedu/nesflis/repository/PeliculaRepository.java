package org.bedu.nesflis.repository;

import org.bedu.nesflis.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio es un patrón de diseño (Repository Pattern) que expone métodos
 * para interactuar con la BD (es decir, no tenemos que usar SQL).
 * 
 * ¿Porqué ésto funciona?
 * JpaRepository implementa ya el CRUD básico de una base de datos:
 * 
 *  findAll() -> Regresa todos los registros de la tabla
 *  findById(id) -> Regresa un registro en particular por ID
 *  save(entity) -> Crea/actualiza un nuevo registro
 *  deleteById(id) -> Elimina un registro
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
