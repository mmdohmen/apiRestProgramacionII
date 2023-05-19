package com.example.apirest.controller;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.apirest.entity.Base;

public interface BaseController <E extends Base, ID extends Serializable> {

	// ResponseEntity() es una clase utilizada p/ enviar una respuesta HTTP desde el servidor al cliente
	// el objeto ResponseEntity incluye el codigo de estado, el header y body de la respuesta HTTP
	public ResponseEntity<?> getAll();
	public ResponseEntity<?> getAll(Pageable pageable);     // Pageable: interfaz q devuleve datos de la pagina solicitada
	public ResponseEntity<?> getOne(@PathVariable ID id);   // @PathVarialbe vincula la variable id con el id especificado en la URI
	public ResponseEntity<?> save(@RequestBody E entity);   // @RequestBody vincula el cuerpo de la solicitud HTTP al objeto 'entity'
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
	
}
