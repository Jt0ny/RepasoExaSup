package com.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository  iMateriaRepository;
	
	@Override
	public void guardar(Materia materia) {
		materia.setNumEstudiantes(0);
		this.iMateriaRepository.insertar(materia);
		
	}

	@Override
	public List<Materia> buscarTodos() {
		return this.iMateriaRepository.seleccionarTodos();
	}

	@Override
	public Materia buscarPorId(Integer id) {
		
		return this.iMateriaRepository.seleccionar(id);
	}

}
