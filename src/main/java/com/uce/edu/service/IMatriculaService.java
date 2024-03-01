package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.dto.MatriculaDTO;

public interface IMatriculaService {
	
	public void guardar (String codigo,String cedula);

	public List<MatriculaDTO> reporte();
}
