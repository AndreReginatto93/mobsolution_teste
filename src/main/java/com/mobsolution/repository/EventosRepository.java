package com.mobsolution.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mobsolution.model.Evento;

public class EventosRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public EventosRepository() {

	}

	public EventosRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Evento porId(Long id) {
		return manager.find(Evento.class, id);
	}

	public List<Evento> pesquisar(String nome) {
		String jpql = "from Eventos where nome like :nome";
		
		TypedQuery<Evento> query = manager
				.createQuery(jpql, Evento.class);
		
		query.setParameter("nome", nome + "%");
		
		return query.getResultList();
	}

	public Evento guardar(Evento evento) {
		return manager.merge(evento);
	}

	public void remover(Evento evento) {
		evento = porId(evento.getId());
		manager.remove(evento);
	}
}