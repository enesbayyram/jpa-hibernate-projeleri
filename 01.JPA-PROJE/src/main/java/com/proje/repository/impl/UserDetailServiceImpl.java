package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.proje.factory.IFactory;
import com.proje.factory.iml.FactoryImpl;
import com.proje.model.UserDetail;
import com.proje.repository.IUserDetailService;

public class UserDetailServiceImpl implements IUserDetailService{
	
	private IFactory factory =new FactoryImpl();
	private EntityManager em= factory.getEntityManager();
	private EntityTransaction transaction= this.em.getTransaction();

	@Override
	public boolean save(UserDetail userDetail) {
		try {
			transaction.begin();
				em.persist(userDetail);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("HATA :" +e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(UserDetail userDetail) {
		try {
			transaction.begin();
				em.merge(userDetail);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hata : " +e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	public boolean remove(UserDetail userDetail) {
		UserDetail tUserDetail=null;
		try {
			transaction.begin();
				tUserDetail = em.find(UserDetail.class, userDetail.getUserDetailId());
				if(tUserDetail!=null)
				{
					em.remove(tUserDetail);
				}else {
					System.out.println("Bu UserDetail yoktur.");
				}
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hata : " +e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public List<UserDetail> getAllUserDetail() {
		List<UserDetail> userDetailList = null;
		try {
			userDetailList = em.createNamedQuery("UserDetail.getAllUserDetail",UserDetail.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata :" +e);
			}
		return userDetailList;
	}

	@Override
	public UserDetail getUserDetailByUsername(String username) {
		UserDetail userDetail =null;
		try {
			userDetail = em.createNamedQuery("UserDetail.getUserDetailByUsername",UserDetail.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return userDetail;
	}

	@Override
	public UserDetail getWithPhoneListUserDetailByUsername(String username) {
		UserDetail userDetail = null;
		try {
			userDetail = em.createNamedQuery("UserDetail.getWithPhoneListUserDetailByUsername",UserDetail.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : " +e);
		}
		return userDetail;
	}

}
