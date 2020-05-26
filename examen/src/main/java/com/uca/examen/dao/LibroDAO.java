package com.uca.examen.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.examen.domain.Libro;

public interface LibroDAO {
	
public List<Libro>findAll() throws DataAccessException;
	
	public Libro findOne(Integer code) throws DataAccessException;
		
	public void save(Libro libro) throws DataAccessException;
	
	public void delete(Integer codigoLibro) throws DataAccessException;

}
