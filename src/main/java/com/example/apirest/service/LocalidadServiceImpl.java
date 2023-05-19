package com.example.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.Localidad;
import com.example.apirest.repository.BaseRepository;
import com.example.apirest.repository.LocalidadRepository;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

	@Autowired
	private LocalidadRepository localidadREpo;
	
	public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepo) {
		super(baseRepo);
	}

}
