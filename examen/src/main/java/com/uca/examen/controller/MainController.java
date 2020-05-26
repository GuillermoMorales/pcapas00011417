package com.uca.examen.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.examen.domain.Categoria;
import com.uca.examen.service.CategoriaService;
import com.uca.examen.service.LibroService;
import com.uca.examen.domain.Libro;

@Controller
public class MainController {
	

	@Autowired
	private LibroService libroService;
	@Autowired
	private CategoriaService categoriaService;
	

	@RequestMapping("/index")
	public ModelAndView initMain()
	{
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	@RequestMapping("/nuevaCategoria")
	public ModelAndView initCategoria()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoria", new Categoria());
		mav.setViewName("nCategoria");
		return mav;
	}
	
	@RequestMapping("/saveC")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			mav.setViewName("nCategoria");
		}
		else
		{			
			categoriaService.save(categoria);
			mav.addObject("resultado", 1);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/nuevoLibro")
	public ModelAndView initLibro()
	{
		ModelAndView mav = new ModelAndView();
		List<Categoria> listado = null;
		
		try
		{
			listado = categoriaService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("listado",listado);		
		mav.addObject("libro", new Libro());
		mav.setViewName("nLibro");
		return mav;
	}
	
	@RequestMapping("/lista")
	public ModelAndView lista()
	{
		ModelAndView mav = new ModelAndView();
		
		List<Libro> libro= null;
		try
		{
			libro= libroService.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mav.addObject("libro",libro);
		mav.setViewName("lista");
		return mav;
	}
	
	@RequestMapping("/regresar")
	public ModelAndView initR()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/saveL")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			
			List<Categoria> listado = null;
			try
			{
				listado = categoriaService.findAll();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			mav.addObject("listado",listado);
			mav.setViewName("nLibro");
		}
		else
		{			
			libroService.save(libro);
			mav.addObject("resultado2", 2);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
}
