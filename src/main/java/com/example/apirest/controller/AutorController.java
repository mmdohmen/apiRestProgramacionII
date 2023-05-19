package com.example.apirest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.entity.Autor;
import com.example.apirest.service.AutorServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")

public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {

}
