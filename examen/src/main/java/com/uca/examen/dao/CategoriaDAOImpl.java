package com.uca.examen.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.examen.domain.Categoria;

@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	
	@PersistenceContext(unitName="examen")
	private EntityManager entityManager;
	
	@Override
	public List<Categoria> findAll() throws DataAccessException
	{
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_categoria");
		javax.persistence.Query query = entityManager.createNativeQuery(sb.toString(), Categoria.class);
		List<Categoria> resulset = query.getResultList();
		
		return resulset;
	}
	
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException
	{
		try
		{
			if(categoria.getC_categoria()== null)
			{
				entityManager.persist(categoria);
			}
			else
			{
				entityManager.merge(categoria);
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
	public void delete(Integer c_categoria) throws DataAccessException
	{
		Categoria categoria= entityManager.find(Categoria.class, c_categoria);
		entityManager.remove(categoria);
	}
	
	
	@Override
	public Categoria findOne(Integer code) throws DataAccessException
	{
		Categoria categoria= entityManager.find(Categoria.class, code);
		return categoria;
	}


}
