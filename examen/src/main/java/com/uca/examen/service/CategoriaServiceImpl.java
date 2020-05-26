package com.uca.examen.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.examen.dao.CategoriaDAO;
import com.uca.examen.domain.Categoria;


@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	CategoriaDAO categoriaDAO;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException
	{
		return categoriaDAO.findAll();
	}
	
	@Override
	public Categoria findOne(Integer code) throws DataAccessException{
		return categoriaDAO.findOne(code);
	}
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException
	{
		categoriaDAO.save(categoria);
	}
	
	@Override
	@Transactional
	public void delete (Integer c_categoria) throws DataAccessException
	{
		categoriaDAO.delete(c_categoria);
	}


}
