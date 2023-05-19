package com.example.apirest.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;                  // clase p/ representar respuestas HTTP (codigo, header, body, etc)
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.Persona;
import com.example.apirest.service.PersonaServiceImpl;

@RestController                             // equivalente a @Controller y @ResponseBody
                                            // @ResponseBody es usada en SpringMVC para marcar un método que retorna un objeto 
                                            // que debe ser serializado en el cuerpo de la respuesta HTTP (en lugar de una vista o plantilla).
@CrossOrigin(origins = "*")                 // permite el acceso a la API desde distintos origenes
@RequestMapping(path = "api/v1/personas")   // especifica la URI (url) q necesito p/ acceder a los metodos

public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

	// metodo p/ usar la Query
	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam String filtro) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
		}
	}
	
	
	// metodo p/ usar la Query con respuesta paginada
	@GetMapping("/searchPaged")
	public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
		}
	}
	
	
	
	// lineas reemplazadas por la Extension de la Clase GENERICA
//	// atributos
//	private PersonaServiceImpl personaServ;
//	// constructor
//	public PersonaController (PersonaServiceImpl personaServ) {
//		this.personaServ = personaServ;
//	}
		
	
	// metodos -----------------------------------------------------------------------------------
//	@GetMapping("")
//	public ResponseEntity<?> getAll() {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(personaServ.findAll());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					             .body("{\"error\":\"ERROR - por favor intente mas tarde ...\"}");
//		}
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getOne(@PathVariable Long id) {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(personaServ.findById(id));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
//		}
//	}
//	
//	@PostMapping("")
//	public ResponseEntity<?> save(@RequestBody Persona p) {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(personaServ.save(p));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
//		}
//	}
//	
//	@PostMapping("/{id}")
//	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona p) {
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(personaServ.update(id, p));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
//		}
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable Long id) {
//		try {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaServ.delete(id));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					.body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
//		}
//	}
	
}
