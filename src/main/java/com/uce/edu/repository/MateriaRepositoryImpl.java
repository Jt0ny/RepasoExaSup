package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertar(Materia materia) {
		this.entityManager.persist(materia);
		
	}

	@Override
	public Materia seleccionarPorCodigo(String codigo) {
		TypedQuery<Materia>query=this.entityManager.createQuery("select ma from Materia ma where ma.codigo=:codigo",Materia.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();
	}

	@Override
	public List<Materia> seleccionarTodos() {
		TypedQuery<Materia>query=this.entityManager.createQuery("select ma from Materia ma",Materia.class);
		return query.getResultList();
	}

	@Override
	public Materia seleccionar(Integer id) {
		TypedQuery<Materia>query=this.entityManager.createQuery("select ma from Materia ma where ma.id=:id",Materia.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public void actualizar(Materia materia) {
		this.entityManager.merge(materia);
	}

}
