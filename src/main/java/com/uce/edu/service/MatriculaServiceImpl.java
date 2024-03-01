package com.uce.edu.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public void guardar(String codigo, String cedula) {
		
		Matricula matricula=new Matricula();
		Materia materia =this.iMateriaRepository.seleccionarPorCodigo(codigo);
		materia.setNumEstudiantes(materia.getNumEstudiantes()+1);
		this.iMateriaRepository.actualizar(materia);
		Estudiante estudiante=this.estudianteRepository.seleccionarPorCedula(cedula);
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFechaMatricula(LocalDate.now());
		this.iMatriculaRepository.insertar(matricula);
	}

	@Override
	public List<MatriculaDTO> reporte() {
		
		return this.iMatriculaRepository.seleccionarTodos();
	}

}
