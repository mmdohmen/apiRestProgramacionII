package com.example.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.apirest.entity.Persona;

public interface PersonaService extends BaseService<Persona, Long> {

	// metodos
	List<Persona> search(String filtro) throws Exception;
	Page<Persona> search(String filtro, Pageable pageable) throws Exception;
	
}
