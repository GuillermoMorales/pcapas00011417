package com.uca.examen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.examen.domain.Libro;

public interface LibroService {

	
public List<Libro> findAll()throws DataAccessException;
	
	public Libro findOne(Integer code) throws DataAccessException;
	
	public void save(Libro libro) throws DataAccessException;
	
	public void delete(Integer codigoLibro) throws DataAccessException;
}
