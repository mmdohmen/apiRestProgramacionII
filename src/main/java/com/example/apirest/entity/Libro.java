package com.example.apirest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.hibernate.envers.Audited;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// anotaciones LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// anotacion ENVERS
@Audited

public class Libro extends Base {

	private String titulo;
	private int fecha;       // año de publicacion
	private String genero;
	private int paginas;
	
	@ManyToMany(cascade = CascadeType.REFRESH)   // actualiza ante cualquier cambio
	private List<Autor> autores;
	
}
