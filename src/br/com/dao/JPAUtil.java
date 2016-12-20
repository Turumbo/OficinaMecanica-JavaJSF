package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("oficinamecanica");
	
	public EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
