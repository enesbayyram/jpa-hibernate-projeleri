package com.proje.model.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.proje.model.BaseEntity;
import com.proje.model.service.ICrudDAOService;

public class CrudDAOServiceImpl implements ICrudDAOService{
	
	private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
		
	@Override
	public <T extends BaseEntity> void save(T dbEntity) {
		Session session= factory.openSession();
		try {
			session.beginTransaction();
				session.save(dbEntity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}	
		finally {
			session.close();
		}
	}

	@Override
	public <T extends BaseEntity> void update(T dbEntity) {
//		Session session = factory.openSession();
		T entity =null;
		try {
//			session.getTransaction().begin();
//		
//			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public <T extends BaseEntity> void remove(T dbEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends BaseEntity> T get(T dbEntity, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
