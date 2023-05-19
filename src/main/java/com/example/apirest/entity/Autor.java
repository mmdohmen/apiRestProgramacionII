package com.example.apirest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autor")
// anotaciones LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// anotacion ENVERS
@Audited

public class Autor extends Base {
	
	// atributos
	private String nombre;
	private String apellido;
	@Column(length = 1600)      // columna de hasta 1600 caracteres
	private String biografia;

}
