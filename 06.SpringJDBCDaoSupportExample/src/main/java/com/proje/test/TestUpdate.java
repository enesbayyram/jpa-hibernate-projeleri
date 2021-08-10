package com.proje.test;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.model.Employee;
import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestUpdate {

	public static void main(String[] args) {
		
ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository  crudDAORepository = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		
		Employee employee = crudDAORepository.getEmployeeById(100);
		employee.setBirthOfDate(createCustomDate(7, 9, 1999));
		
		crudDAORepository.update(employee);
		
		
		applicationContext.close();
	}
	
	public static Date createCustomDate(int day, int month, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.YEAR, year);
		return calendar.getTime();
	}
}
