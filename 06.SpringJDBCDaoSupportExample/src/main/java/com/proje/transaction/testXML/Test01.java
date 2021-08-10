package com.proje.transaction.testXML;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.User;
import com.proje.transaction.service.IUserService;
import com.proje.transaction.service.impl.UserServiceImpl;

public class Test01 {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		IUserService userService = applicationContext.getBean("userService",UserServiceImpl.class);
		
		User user = new User(4, "crazy01", "1234", new Date(), true);
		userService.save(user);
		
		
		applicationContext.close();
	}
}
