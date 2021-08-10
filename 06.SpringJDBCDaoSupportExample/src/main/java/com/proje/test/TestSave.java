package com.proje.test;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Employee;
import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestSave {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository  crudDAORepository = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		
//		Employee employee =new Employee(100, "Enes", "Bayram", "Erkek", createCustomDate(7, 9, 1999), new Date());
		Employee employee1 =new Employee(101, "Yakup", "Reçber", "Erkek", createCustomDate(11, 4, 1999), new Date());
		Employee employee2 =new Employee(102, "Bilal", "Çamur", "Erkek", createCustomDate(15, 3, 1999), new Date());
		
		crudDAORepository.save(employee1);
		crudDAORepository.save(employee2);
		
		applicationContext.close();
	}
	
	public static Date createCustomDate(int day, int month, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}
}
