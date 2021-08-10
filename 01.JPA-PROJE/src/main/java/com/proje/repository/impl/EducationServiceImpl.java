package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import com.proje.factory.IFactory;
import com.proje.factory.iml.FactoryImpl;
import com.proje.model.Education;
import com.proje.repository.IEducationService;

public class EducationServiceImpl implements IEducationService{
	
	private IFactory factory =new FactoryImpl();
	private EntityManager em= factory.getEntityManager();
	private EntityTransaction transaction=this.em.getTransaction();

	@Override
	public boolean save(Education education) {
		try {
			transaction.begin();
				em.persist(education);
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("HATA : " +e);
			try {
				transaction.rollback();
			} catch (RollbackException e2) {
				System.out.println("HATA : " + e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Education education) {
		try {
			transaction.begin();
				em.merge(education);
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("HATA  :" +e);
			try {
				transaction.rollback();
			} catch (Exception e2) {
				System.out.println("HATA : " +e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Education education) {
		Education tEducation;
		try {
			transaction.begin();
				tEducation = em.find(Education.class, education.getEducationId());
				if(tEducation!=null)
				{
					em.remove(tEducation);
				}else {
					System.out.println("Education Bulunamadı :(");
				}
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("HATA :"+e);
			try {
				transaction.rollback();
			} catch (RollbackException e2) {
				System.out.println("HATA : " +e2);
			}
			return false;
		}
		return true;
	}

	@Override
	public List<Education> getAllEducation() {
		List<Education> educationList=null;
		try {
			educationList = em.createNamedQuery("Education.getAllEducation",Education.class).getResultList();
		} catch (Exception e) {
			System.out.println("HATA : " +e);
		}
		return educationList;
	}

	@Override
	public Education getEducationById(Integer educationId) {
		Education education=null;
		try {
			education = em.createNamedQuery("Education.getEducationById", Education.class)
					.setParameter("educationId", educationId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("HATA : " +e);
		}
		return education;
	}

	@Override
	public Education getWithAdvertisement(Integer educationId) {
		Education education =null;
		try {
			education = em.createNamedQuery("Education.getWithAdvertisement",Education.class)
					.setParameter("educationId", educationId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("HATA : " +e);
		}
		return education;
	}

}
