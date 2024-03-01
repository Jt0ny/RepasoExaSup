package com.uce.edu.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {
	
	private String cedulaEstu;
	
	private String apellidoEstu;
	
	private String nombreMate;
	
	private String codigoMate;
	
	private LocalDate fechaMatricula;

	
	
	public MatriculaDTO() {
		super();
	}



	public MatriculaDTO(String cedulaEstu, String apellidoEstu, String nombreMate, String codigoMate,
			LocalDate fechaMatricula) {
		super();
		this.cedulaEstu = cedulaEstu;
		this.apellidoEstu = apellidoEstu;
		this.nombreMate = nombreMate;
		this.codigoMate = codigoMate;
		this.fechaMatricula = fechaMatricula;
	}



	public String getCedulaEstu() {
		return cedulaEstu;
	}



	public void setCedulaEstu(String cedulaEstu) {
		this.cedulaEstu = cedulaEstu;
	}



	public String getApellidoEstu() {
		return apellidoEstu;
	}



	public void setApellidoEstu(String apellidoEstu) {
		this.apellidoEstu = apellidoEstu;
	}



	public String getNombreMate() {
		return nombreMate;
	}



	public void setNombreMate(String nombreMate) {
		this.nombreMate = nombreMate;
	}



	public String getCodigoMate() {
		return codigoMate;
	}



	public void setCodigoMate(String codigoMate) {
		this.codigoMate = codigoMate;
	}



	public LocalDate getFechaMatricula() {
		return fechaMatricula;
	}



	public void setFechaMatricula(LocalDate fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}
	
	

}
