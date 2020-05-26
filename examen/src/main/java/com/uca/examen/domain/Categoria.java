package com.uca.examen.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.uca.examen.domain.Libro;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {

	@Id
	@GeneratedValue(generator="cat_categoria_c_categoria_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_categoria_c_categoria_seq", sequenceName = "public.cat_categoria_c_categoria_seq", allocationSize = 1)
	@Column(name="c_categoria")
	private Integer c_categoria;
	
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max=50)
	@NotEmpty(message="El campo categoria no debe estar vacío")
	@Column(name="s_categoria")
	private String  s_categoria;
	
	@OneToMany(mappedBy="categoria",fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Libro> libros;

	public Integer getC_categoria() {
		return c_categoria;
	}

	public void setC_categoria(Integer c_categoria) {
		this.c_categoria = c_categoria;
	}

	public String getS_categoria() {
		return s_categoria;
	}

	public void setS_categoria(String s_categoria) {
		this.s_categoria = s_categoria;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
}
