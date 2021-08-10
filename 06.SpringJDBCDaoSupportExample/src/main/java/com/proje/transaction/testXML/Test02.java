package com.proje.transaction.testXML;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.UserDetail;
import com.proje.transaction.service.impl.UserDetailServiceImpl;

public class Test02 {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserDetailServiceImpl userDetailServiceImpl = applicationContext.getBean("userDetailService",UserDetailServiceImpl.class);
		
		UserDetail userDetail = new UserDetail(502, "Yasin", "Yazıcı", new Date());
		
		userDetailServiceImpl.save(4,userDetail);
		
		applicationContext.close();
	}
}
