package com.example.apirest.service;

import java.util.List;

//import java.util.List;
//import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.Persona;
import com.example.apirest.repository.BaseRepository;
import com.example.apirest.repository.PersonaRepository;



@Service
// reemplazo por extends interface GENERICA - idem linea 83 en adelante
// public class PersonaService implements BaseService<Persona>{

public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

	// atributo
	@Autowired                              // anotacion q reemplaza al constructor y crea una instancia
	private PersonaRepository personaRep;   // instancia de PersonaRepository (metodos CRUD)
	
	// constructores
//	public PersonaService (PersonaRepository personaRep) {
//		this.personaRep = personaRep;
//	}
	
	
	// metodos BaseServiceImpl
	public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepo) {
		super(baseRepo);
	}

	
	// metodo PersonaService
	@Override
	public List<Persona> search(String filtro) throws Exception {
		try {
			// 1- KEYWORDS
			//List<Persona> personas = personaRep.findByNombreContainingOrApellidoContaining(filtro, filtro);
			
			// 2- JPQL
			//List<Persona> personas = personaRep.search(filtro);
			
			// 3- SQL nativa
			List<Persona> personas = personaRep.searchSQL(filtro);
			
			return personas;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	@Override
	public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
		try {
			// 1- KEYWORDS
			//Page<Persona> personas = personaRep.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
			
			// 2- JPQL
			//Page<Persona> personas = personaRep.search(filtro, pageable);
			
			// 3- SQL nativa
			Page<Persona> personas = personaRep.searchSQL(filtro, pageable);
			
			return personas;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}


	

	
// reemplazados al extender la interfaz GENERICA ======================================================
//	// metodos CRUD de BaseService
//	@Override
//	@Transactional                                           // este metodo es una transaccion
//	public List<Persona> findAll() throws Exception {
//		try {
//			List<Persona> personas = personaRep.findAll();   // personas registradas en la BBDD
//			return personas;
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	@Override
//	@Transactional
//	public Persona findById(Long id) throws Exception {
//		try {
//			Optional<Persona> persona = personaRep.findById(id);   // objeto q puede ser nulo o no nulo
//			return persona.get();                                  // persona con el 'id' solicitado
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	@Override
//	@Transactional
//	public Persona save(Persona registro) throws Exception {
//		try {
//			registro = personaRep.save(registro);                     // 'registro' agregado a la BBDD
//			return registro;
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	@Override
//	@Transactional
//	public Persona update(Long id, Persona datosNuevos) throws Exception {
//		try {
//			Optional<Persona> personaOp = personaRep.findById(id);
//			Persona p = personaOp.get();                              // creo un objeto Persona con los datos recuperados
//			p = personaRep.save(datosNuevos);                         // actualizo el registro con los datosNuevos ingresados
//			return p;	
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	@Override
//	@Transactional
//	public boolean delete(Long id) throws Exception {
//		try {
//			if (personaRep.existsById(id)) {
//				personaRep.deleteById(id);                            // borro el registro con el 'id' ingresado
//				return true;
//			} else {
//				throw new Exception();
//			}
//		} catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}

}
