package com.example.apirest.service;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;       // pagina de resultados en una consulta paginada
import org.springframework.data.domain.Pageable;   // interfaz q define los parametros de paginacion

import com.example.apirest.entity.Base;

// interfaz GENERICA
public interface BaseService <E extends Base, ID extends Serializable> {
	
	// metodos CRUD
	public List<E> findAll() throws Exception;
	public Page<E> findAll(Pageable pageable) throws Exception;   // datos paginados
	public E findById(ID id) throws Exception;
	public E save(E entity) throws Exception;
	public E update(ID id, E entity) throws Exception;
	public boolean delete(ID id) throws Exception;

}



// reemplazada por la Interfaz GENERICA con tipos de datos, E (entidad) y ID, genericos
//public interface BaseService<E> {
//	
//	// metodos CRUD
//	public List<E> findAll() throws Exception;
//	public E findById(Long id) throws Exception;
//	public E save(E entity) throws Exception;
//	public E update(Long id, E entity) throws Exception;
//	public boolean delete(Long id) throws Exception;
//
//}
