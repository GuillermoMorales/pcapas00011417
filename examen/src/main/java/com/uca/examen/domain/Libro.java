package com.uca.examen.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.uca.examen.domain.Categoria;

@Entity
@Table(schema="public", name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)	
	@Column(name="c_libro")
	private Integer codigoLibro;
	

	@Size(message="El campo sobrepasa la cantidad de 500 caracteres", max=500)
	@NotEmpty(message="El campo no debe estar vacío")
	@Pattern(regexp="^\\S.*$",message="El campo titulo no puede tener solo espacio")
	@Column(name="s_titulo")
	private String titulo;
	
	@Size(message="El campo sobrepasa la cantidad de 150 caracteres", max=150)
	@NotEmpty(message="El campo no debe estar vacío")
	@Pattern(regexp="^\\S.*$",message="El campo autor no puede tener solo espacio")
	@Column(name="s_autor")
	private String autor;
	
	@NotEmpty(message="ISBN no puede estar vacío")
	@Pattern(regexp="\\d{10}", message="Debe ser 10 digitos exactos")
	@Column(name="s_isbn")
	String isbn;
	
	
	@CreationTimestamp
	@Column(name = "f_ingreso")
	private Date fecha;
	

	@Column(name = "b_estado")
	private Boolean bestado;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;


	public Integer getCodigoLibro() {
		return codigoLibro;
	}


	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Boolean getBestado() {
		return bestado;
	}


	public void setBestado(Boolean bestado) {
		this.bestado = bestado;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String getFechaDelegate(){
		if(this.fecha == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			String shortdate = sdf.format(this.fecha.getTime());
			return shortdate;
		}
	}
	//Delegate para activo o inactivo
	public String getBactivoDelegate()
	{
		if(this.bestado == null)
		{
			return "";
		}
		else
		{
			if(this.bestado) return "ACTIVO";
			else return "INACTIVO";
		}
	}
	


}
