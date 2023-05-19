package com.example.apirest.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

public class Domicilio extends Base {

	// atributos
	private String calle;
	private int numero;
	
	@ManyToOne(optional = false)         // esta realacion no puede ser nula
	@JoinColumn(name = "fk_localidad")
	private Localidad localidad;
	
	
}
