package com.uca.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.examen.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {
	
	
	@PersistenceContext(unitName="examen")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		javax.persistence.Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException
	{
		try
		{
			if(libro.getCodigoLibro()== null)
			{
				entityManager.persist(libro);
			}
			else
			{
				entityManager.merge(libro);
				entityManager.flush();
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional
	public void delete(Integer codigoLibro) throws DataAccessException
	{
		Libro libro= entityManager.find(Libro.class, codigoLibro);
		entityManager.remove(libro);
	}
	
	
	@Override
	public Libro findOne(Integer code) throws DataAccessException
	{
		Libro libro= entityManager.find(Libro.class, code);
		return libro;
	}


}
