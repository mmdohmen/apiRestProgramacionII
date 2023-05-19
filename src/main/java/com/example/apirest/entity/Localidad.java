package com.example.apirest.entity;

import javax.persistence.Entity;
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

public class Localidad extends Base {

	private String denominacion;
	
}
