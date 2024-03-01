package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		this.entityManager.persist(matricula);
		
	}

	@Override
	public List<MatriculaDTO> seleccionarTodos() {
		TypedQuery<MatriculaDTO>query=this.entityManager.createQuery("select new "
				+ "com.uce.edu.repository.modelo.dto.MatriculaDTO"
				+ "(m.estudiante.cedula,m.estudiante.apellido,"
				+ "m.materia.nombre,m.materia.codigo,"
				+ "m.fechaMatricula)"
				+ "FROM Matricula m",MatriculaDTO.class);
		
		return query.getResultList();
	}

}
