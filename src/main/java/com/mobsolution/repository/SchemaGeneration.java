package com.mobsolution.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mobsolution.model.Evento;

public class SchemaGeneration {
	
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MobSolutionPU");
		
		EntityManager em = emf.createEntityManager();
		
		List<Evento> lista = em.createQuery("FROM Evento", Evento.class)
				.getResultList();
		
		System.out.println(lista);
		
		em.close();
		emf.close();
	}

}