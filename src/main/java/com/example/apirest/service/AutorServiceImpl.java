package com.example.apirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest.entity.Autor;
import com.example.apirest.repository.AutorRepository;
import com.example.apirest.repository.BaseRepository;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

	@Autowired
	private AutorRepository autorRepo;
	
	public AutorServiceImpl(BaseRepository<Autor, Long> baseRepo) {
		super(baseRepo);
	}

}
