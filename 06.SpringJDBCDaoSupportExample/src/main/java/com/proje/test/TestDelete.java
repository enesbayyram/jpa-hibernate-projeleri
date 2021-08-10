package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestDelete {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository crudDAORepository  = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		
		crudDAORepository.delete(100);
		
		
		applicationContext.close();
	}
}
