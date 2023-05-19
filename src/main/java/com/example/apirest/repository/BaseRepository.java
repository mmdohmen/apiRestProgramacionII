package com.example.apirest.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;   // interfaz q proporciona metodos CRUD
import org.springframework.data.repository.NoRepositoryBean;

import com.example.apirest.entity.Base;

// interfaz GENERICA

@NoRepositoryBean   // evita q esta interface sea instanciada
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {

}

