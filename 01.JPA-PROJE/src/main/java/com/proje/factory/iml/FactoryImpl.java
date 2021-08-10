package com.proje.factory.iml;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.proje.factory.IFactory;

public class FactoryImpl implements IFactory{
	
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlUnit");
		this.em = factory.createEntityManager();
		return em;
	}
}
