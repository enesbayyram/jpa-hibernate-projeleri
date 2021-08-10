package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proje.model.Advertisement;
import com.proje.repository.IAdvertisementService;

public class AdvertisementServiceImpl implements IAdvertisementService{
	
	private EntityManager em = factory.getEntityManager();
	private EntityTransaction transaction=this.em.getTransaction();
	private Logger log=LogManager.getLogger();

	@Override
	public boolean save(Advertisement advertisement) {
		
		try {
			transaction.begin();
				em.persist(advertisement);
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("Hata : " + e);
			try {
				transaction.rollback();
			} catch (RollbackException e2) {
				System.out.println("Hata : "+e2);
				log.info("Advertisement Eklernirken hata oldu");
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Advertisement advertisement) {
		try {
			transaction.begin();
				em.merge(advertisement);
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("Hata : " +e);
			try {
				this.transaction.rollback();
			} catch (RollbackException e2) {
				System.out.println("Hata : "+ e2);
				log.info("Advertisement güncellenirken hata oldu");
			}
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(Advertisement advertisement) {
		Advertisement tAdvertisement = null;
		try {
			transaction.begin();
				tAdvertisement = em.find(Advertisement.class, advertisement.getAdvertisementId());
				em.remove(tAdvertisement);
			transaction.commit();
		} catch (RuntimeException e) {
			System.out.println("Hata : " +e);
			try {
				transaction.rollback();
			} catch (RollbackException e2) {
				System.out.println("Hata :"+e2);
				
			}
			return false;
		}
		return true;
	}

	@Override
	public List<Advertisement> getAllAdvertisement() {
		List<Advertisement> advertisementList =null;
		try {
			advertisementList = em.createNamedQuery("Advertisement.getAllAdvertisement",Advertisement.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return advertisementList;
	}

	@Override
	public	Advertisement getAdvertisementById(Integer advertisementId) {
		Advertisement advertisement =null;
		try {
			advertisement = em.createNamedQuery("Advertisement.getAdvertisementById", Advertisement.class)
					.setParameter("advertisementId", advertisementId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return advertisement;
	}

	@Override
	public List<Advertisement> getAdvertisementByUsername(String username) {
		List<Advertisement> advertisementList =null;
		try {
			advertisementList = em.createNamedQuery("Advertisement.getAdvertisementByUsername", Advertisement.class)
					.setParameter("username", username)
					.getResultList();
		} catch (Exception e) {
			System.out.println("Hata :"+e);
		}
		return advertisementList;
	}

}
