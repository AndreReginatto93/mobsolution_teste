package com.mobsolution.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mobsolution.model.Presenca;

public class PresencasRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public PresencasRepository() {

	}

	public PresencasRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Presenca porId(Long id) {
		return manager.find(Presenca.class, id);
	}

	public List<Presenca> pesquisar(Long participanteId) {
		String jpql = "from Presencas where participante_id = :participante_id";
		
		TypedQuery<Presenca> query = manager
				.createQuery(jpql, Presenca.class);
		
		query.setParameter("participante_id", participanteId);
		
		return query.getResultList();
	}

	public Presenca guardar(Presenca presenca) {
		return manager.merge(presenca);
	}

	public void remover(Presenca presenca) {
		presenca = porId(presenca.getId());
		manager.remove(presenca);
	}
}