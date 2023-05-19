package com.example.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apirest.entity.Base;
import com.example.apirest.service.BaseServiceImpl;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long> > implements BaseController<E, Long> {

	// atributos
	@Autowired
	protected S servicio;
	
	
	// metodos -----------------------------------------------------------------------------------
		@GetMapping("")
		public ResponseEntity<?> getAll() {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						             .body("{\"error\":\"ERROR - por favor intente mas tarde ...\"}");
			}
		}
		
		@GetMapping("/paged")
		public ResponseEntity<?> getAll(Pageable pageable) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						             .body("{\"error\":\"ERROR - por favor intente mas tarde ...\"}");
			}
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> getOne(@PathVariable Long id) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
			}
		}
		
		@PostMapping("")
		public ResponseEntity<?> save(@RequestBody E entidad) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entidad));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
			}
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entidad) {
			try {
				return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entidad));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						             .body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
			try {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("{\"error\":\"ERROR. Por favor intente mas tarde.\"}");
			}
		}
}
