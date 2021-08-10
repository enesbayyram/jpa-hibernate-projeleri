package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Employee;
import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestSingleEmployee {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository  crudDAORepository = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		
		Employee employee = crudDAORepository.getEmployeeById(100);
		System.out.println(employee);
		
		applicationContext.close();
	}
}
