package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Employee;
import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestEmployeeList {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository crudDAORepository = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		List<Employee> employeeList = crudDAORepository.getEmployeeList();
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
		applicationContext.close();
	}
}
