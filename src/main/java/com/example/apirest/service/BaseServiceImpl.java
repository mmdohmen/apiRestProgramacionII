package com.example.apirest.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.apirest.entity.Base;
import com.example.apirest.repository.BaseRepository;



// implementacion ABSTRACTA de la Interfaz GENERICA BaseService()
// la declaro 'abstract' p/ q no se pueda instanciar ya que solo la usare como GENERICA (plantilla)
public abstract class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID> {

	// atributo
	protected BaseRepository<E, ID> baseRepo;

	// constructor
	public BaseServiceImpl(BaseRepository<E, ID> baseRepo) {
		this.baseRepo = baseRepo;
	}
	
	
	// metodos CRUD
	@Override
	@Transactional                                           // este metodo es una transaccion
	public List<E> findAll() throws Exception {
		try {
			List<E> entidades = baseRepo.findAll();          // entidades registradas en la BBDD
			return entidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional 
	public Page<E> findAll(Pageable pageable) throws Exception {
		try {
			Page<E> entidades = baseRepo.findAll(pageable);   // objeto q contiene una lista de registros paginados
			return entidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		try {
			Optional<E> entidad = baseRepo.findById(id);   // objeto q puede ser nulo o no nulo
			return entidad.get();                          // entidad con el 'id' solicitado
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E save(E entidad) throws Exception {
		try {
			entidad = baseRepo.save(entidad);                     // 'registro' agregado a la BBDD
			return entidad;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public E update(ID id, E datosNuevos) throws Exception {
		try {
			Optional<E> entidadOp = baseRepo.findById(id);       // objeto q puede ser nulo o no nulo
			E entidad = entidadOp.get();
			System.out.println(entidad);
			entidad = baseRepo.save(datosNuevos);                // actualizo el registro con el 'id' ingresado
			return entidad;	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(ID id) throws Exception {
		try {
			if (baseRepo.existsById(id)) {
				baseRepo.deleteById(id);                            // borro el registro con el 'id' ingresado
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
}
