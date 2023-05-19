package com.example.apirest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.JpaRepository;   // interfaz q proporciona metodos CRUD
import org.springframework.stereotype.Repository;

import com.example.apirest.entity.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
	
	// buscamos registros de Personas segun su nombre o apellido
	// QUERIES - opciones:
	
	// 1- KEYWORDS
	List<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido);
	
	Page<Persona> findByNombreContainingOrApellidoContaining (String nombre, String apellido, Pageable pageagle);
	
	boolean existsByDni (int dni);       // verificamos la existencia o no de un cierto 'dni'
	
	
	// 2- JPQL
	@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
	List<Persona> search(@Param("filtro") String filtro);
	
	@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
	Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);
	
	
	// 3- SQL nativa
	@Query(
			value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
			nativeQuery = true
	)
	List<Persona> searchSQL(@Param("filtro") String filtro);
	
	@Query(
			value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
			countQuery = "SELECT count(*) FROM persona",   // atributo p/ contar el numero de registros q cumplen con el filtro y evitar recuperar todos los resultados
			nativeQuery = true
	)
	Page<Persona> searchSQL(@Param("filtro") String filtro, Pageable pageable);
	
}

// reemplazada por la Interfaz GENERICA
//public interface PersonaRepository extends JpaRepository<Persona, Long> {
//
//}
