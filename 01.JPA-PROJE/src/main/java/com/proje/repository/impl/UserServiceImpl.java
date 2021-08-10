package com.proje.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.proje.factory.IFactory;
import com.proje.factory.iml.FactoryImpl;
import com.proje.model.User;
import com.proje.model.UserInfo;
import com.proje.repository.IUserService;
// İnsert , Update, Delete metotların da sadece transaction işlemi yapılır onun dışında açmıyoruz.
public class UserServiceImpl implements IUserService{
	
	private IFactory factory =new FactoryImpl();
	private EntityManager em= factory.getEntityManager();
	private EntityTransaction transaction= this.em.getTransaction();

	@Override
	public boolean save(User user) {
		try {
			transaction.begin();
				em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hata : " +e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(User user) {
		try {
			transaction.begin();
				em.merge(user);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hata : " +e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public boolean remove(User user) {
		User tUser=null;
		try {
			tUser = em.find(User.class, user.getUserId());
			if(tUser!=null)
			{
				em.remove(user);
			}else {
				System.out.println("Bu id 'ye sahip User bulunamadı...");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Hata :"+e);
			transaction.rollback();
			return false;
		}
		return true;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList =null;
		try {
			userList = em.createNamedQuery("User.getAllUsers", User.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata :"+e);
		}
		return userList;
	}

	@Override
	public Long getUserCount() {
		Long count=-1L;
		try 
		{
			count = em.createNamedQuery("User.getUserCount",Long.class).getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return count;
	}

	@Override
	public User getUserById(Integer userId) {
			User user =null;
		try {
			user = em.createNamedQuery("User.getUserById",User.class)
					.setParameter("userId", userId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata :"+e);
		}
		return user;
	}

	@Override
	public User getWithUserDetailById(Integer userId) {
		User user =null;
		try {
			user = em.createNamedQuery("User.getWithUserDetailById",User.class)
					.setParameter("userId", userId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return user;
	}

	@Override
	public User getWithUserDetailByUsername(String username) {
		User user =null;
		try {
			user = em.createNamedQuery("User.getWithUserDetailByUsername",User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata : "+e);
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		User user =null;
		try {
			user = em.createNamedQuery("User.getWithUserDetailByUsername",User.class)
					.setParameter("username", username)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata :"+e);
		}
		return user;
	}

	@Override
	public UserInfo fillUserInfoByUserId(Integer userId) {
		UserInfo  userInfo  =null;
		try {
			userInfo = em.createNamedQuery("User.fillUserInfoByUserId",UserInfo.class)
					.setParameter("userId", userId)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata  :" +e);
		}
		return userInfo;
	}

	@Override
	public List<UserInfo> fillUserInfo() {
		List<UserInfo> userInfoList=null;
		try {
			userInfoList = em.createNamedQuery("User.fillUserInfo",UserInfo.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hat : "+e);
		}	
		return userInfoList;
	}
	

}
