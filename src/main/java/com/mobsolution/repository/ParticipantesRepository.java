package com.mobsolution.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mobsolution.model.Participante;

public class ParticipantesRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public ParticipantesRepository() {

	}

	public ParticipantesRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Participante porId(Long id) {
		return manager.find(Participante.class, id);
	}

	public List<Participante> pesquisar(Long eventoId) {
		String jpql = "from Participantes where evento_id = :evento_id";
		
		TypedQuery<Participante> query = manager
				.createQuery(jpql, Participante.class);
		
		query.setParameter("evento_id", eventoId);
		
		return query.getResultList();
	}

	public Participante guardar(Participante participante) {
		return manager.merge(participante);
	}

	public void remover(Participante participante) {
		participante = porId(participante.getId());
		manager.remove(participante);
	}
}