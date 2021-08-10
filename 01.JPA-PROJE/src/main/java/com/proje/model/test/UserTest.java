package com.proje.model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.proje.factory.IFactory;
import com.proje.factory.iml.FactoryImpl;
import com.proje.model.Address;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserDetail;
import com.proje.model.UserInfo;
import com.proje.model.util.PhoneType;
import com.proje.repository.IUserService;
import com.proje.repository.impl.UserServiceImpl;

public class UserTest {
	private static IFactory factory =new FactoryImpl();
	private static EntityManager em = factory.getEntityManager();
	private static EntityTransaction transaction =em.getTransaction();
	
	private static IUserService userService =new UserServiceImpl();
	
	public static void main(String[] args) {
		
//		List<User> userList = userService.getAllUsers();
//		for (User user : userList) {
//			System.out.println(user);
//		}
		
//		Long count= userService.getUserCount();
//		System.out.println("User Count : "+count);
//		
//		User user = userService.getUserById(1);
//		System.out.println(user);

		
//		List<User> userList = userService.getAllUsers();
//		for (User user : userList) {
//			System.out.println(user);
//		}
//		
//		User tUser = userService.getWithUserDetailById(2);
//		System.out.println(tUser);
		
//		User tUser =userService.getWithUserDetailByUsername("bilocan");
//		System.out.println(tUser);
		
		List<UserInfo> userInfoList = userService.fillUserInfo();
		for (UserInfo userInfo : userInfoList) {
			System.out.println(userInfo);
		}
		
	}

	public static void insertData()
	{
		Map<PhoneType, String> phoneList =new HashMap<>();
		phoneList.put(PhoneType.WORK, "0216 256 78 12");
		phoneList.put(PhoneType.HOME, "0216 678 32 65");
		phoneList.put(PhoneType.CELL, "0535 678 34 56");
		
		List<Address> adressList=new ArrayList<>();
		adressList.add(new Address("Dilek", "Çekmeköy", "İstanbul", "34000"));
		adressList.add(new Address("Sevgi", "Bağcılar", "İstanbul", "35654"));
		
		List<Education> educationList =new ArrayList<>();
		educationList.add(new Education("Yazılım Mühendisi", 4));
		
		List<Advertisement> advertisementList =new ArrayList<>();
		advertisementList.add(new Advertisement("Yazılım Geliştiricisi", "Mobil uygulama geliştirici arıyoruz","Yazılım Mühendisliği bölümü mezunu", true,educationList));
		

		UserDetail userDetail =new UserDetail("Enes", "Bayram", new Date(), phoneList, adressList, advertisementList);
		advertisementList.get(0).addUserDetail(userDetail);
		User user =new User("kahtali21", "123",userDetail,new Date());
		userDetail.addUser(user);
		//********************************************************************************************************************************************
		
		Map<PhoneType, String> phoneList2 =new HashMap<>();
		phoneList2.put(PhoneType.WORK, "0216 765 78 12");
		phoneList2.put(PhoneType.HOME, "0216 456 32 65");
		phoneList2.put(PhoneType.CELL, "0535 123 34 56");
		
		List<Address> adressList2=new ArrayList<>();
		adressList2.add(new Address("Pembe", "Üsküdar", "İstanbul", "34000"));
		adressList2.add(new Address("Sevgi", "Bağcılar", "İstanbul", "35654"));
		
		List<Education> educationList2 =new ArrayList<>();
		educationList2.add(new Education("Bilgisayar Mühendisi", 4));
		
		List<Advertisement> advertisementList2 =new ArrayList<>();
		advertisementList2.add(new Advertisement("Web Developer", "Web geliştiricisi aramaktayız uygun şartları sağlayan bize ulaşmasını rica ederiz","Bilgisiyar Mühendisi Mezunu", true,educationList2));
		

		UserDetail userDetail2 =new UserDetail("Bilal", "Çamur", new Date(), phoneList2, adressList2, advertisementList2);
		advertisementList2.get(0).addUserDetail(userDetail2);
		User user2 =new User("bilocan", "444",userDetail2,new Date());
		userDetail2.addUser(user2);
		
		transaction.begin();
			em.persist(user);
			em.persist(userDetail);
			
			em.persist(user2);
			em.persist(userDetail2);
		transaction.commit();
	}
}
