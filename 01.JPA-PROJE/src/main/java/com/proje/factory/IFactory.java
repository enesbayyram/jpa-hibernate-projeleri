package com.proje.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface IFactory {
	
	EntityManager getEntityManager();
}
