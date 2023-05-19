package com.example.apirest.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;   // permite q una entidad herede propiedades de una clase base

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//permite la herencia de sus propiedades (implementaciones, atributos y metodos)
@MappedSuperclass                             
// anotaciones LOMBOK
@Getter
@Setter
@NoArgsConstructor                            // constructor vacio
@AllArgsConstructor                           // constructor con todos los atributos

public class Base implements Serializable {   // CLASE Padre p/ crear el atributo ID
	
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

}
