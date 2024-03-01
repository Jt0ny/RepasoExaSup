package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
		
	}

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		TypedQuery<Estudiante>query=this.entityManager.createQuery("select e from Estudiante e where e.cedula=:cedula",Estudiante.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

}
