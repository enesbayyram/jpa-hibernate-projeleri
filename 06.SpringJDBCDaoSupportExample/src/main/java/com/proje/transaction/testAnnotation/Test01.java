package com.proje.transaction.testAnnotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.config.AppConfig;
import com.proje.model.User;
import com.proje.transaction.service.IUserService;
import com.proje.transaction.service.impl.UserServiceImpl;

public class Test01 {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IUserService userService = applicationContext.getBean("userService",UserServiceImpl.class);
		
//		List<User> userList = userService.getUserList();
//		for (User user : userList) {
//			System.out.println(user);
//		}
		
//		User user = userService.getUserById(4);
//		System.out.println(user);	
		
		User user= userService.getUserListWithUserDetailById(4);
		
		System.out.println(user);
		System.out.println(user.getUserDetail());
		
		applicationContext.close();
	}
}
