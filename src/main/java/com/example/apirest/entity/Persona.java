package com.example.apirest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
// anotaciones LOMBOK
@NoArgsConstructor     // constructor vacio
@AllArgsConstructor    // constructor con todos los atributos
@Getter
@Setter
// anotacion ENVERS (auditoria)
@Audited

//lineas reemplazadas al usar la superClase Base
//public class Persona implements Serializable {          // se puede convertir en un flujo de bytes
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)   // autoincrementable
//	private Long id;
	
public class Persona extends Base {
	
	private String nombre;
	private String apellido;
	private int dni;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_domicilio")
	private Domicilio domicilio;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)   // la entidad hija debe ser eliminada
	@JoinTable(                                                   // 3er tabla de relacion
			name = "persona_libro",
			joinColumns = @JoinColumn(name = "persona_id"),
			inverseJoinColumns = @JoinColumn(name = "libro_id")
			)
	private List<Libro> libros = new ArrayList<Libro>();
	
}
