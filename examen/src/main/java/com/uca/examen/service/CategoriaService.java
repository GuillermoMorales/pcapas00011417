package com.uca.examen.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.examen.domain.Categoria;

public interface CategoriaService {
	
public List<Categoria> findAll()throws DataAccessException;
	
	public Categoria findOne(Integer code) throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;
	
	public void delete(Integer c_categoria) throws DataAccessException;

}
