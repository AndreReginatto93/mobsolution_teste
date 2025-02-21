package com.mobsolution.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.mobsolution.model.Evento;
import com.mobsolution.repository.EventosRepository;
import com.mobsolution.util.Transacional;

public class EventoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EventosRepository eventos;
	
	@Transacional
	public void salvar(Evento evento) {
		eventos.guardar(evento);
	}
	
	@Transacional
	public void excluir(Evento evento) {
		eventos.remover(evento);
	}

}