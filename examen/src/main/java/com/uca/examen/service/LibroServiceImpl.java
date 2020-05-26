package com.uca.examen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.examen.dao.LibroDAO;
import com.uca.examen.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	
	@Autowired
	LibroDAO libroDAO;
	
	@Override
	public List<Libro> findAll() throws DataAccessException
	{
		return libroDAO.findAll();
	}
	
	@Override
	public Libro findOne(Integer code) throws DataAccessException{
		return libroDAO.findOne(code);
	}
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException
	{
		libroDAO.save(libro);
	}
	
	@Override
	@Transactional
	public void delete (Integer codigoLibro) throws DataAccessException
	{
		libroDAO.delete(codigoLibro);
	}


}
