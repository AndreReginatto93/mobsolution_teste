package com.mobsolution.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.mobsolution.model.Presenca;
import com.mobsolution.repository.PresencasRepository;
import com.mobsolution.util.Transacional;

public class presencaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PresencasRepository presencas;
	
	@Transacional
	public void salvar(Presenca presenca) {
		presencas.guardar(presenca);
	}
	
	@Transacional
	public void excluir(Presenca presenca) {
		presencas.remover(presenca);
	}

}