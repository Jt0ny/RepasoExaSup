package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaService {
	
	public void guardar (Materia materia);
	
	public List<Materia>buscarTodos();
	
	public Materia buscarPorId(Integer id);

}
