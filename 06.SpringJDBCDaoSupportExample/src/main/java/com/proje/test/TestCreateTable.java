package com.proje.test;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.repository.ICrudDAORepository;
import com.proje.repository.impl.CrudDAOServiceImpl;

public class TestCreateTable {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ICrudDAORepository crudDAORepository = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl.class);
		
		boolean result = crudDAORepository.createEmployeeTable();
		if(result)
		{
			System.out.println("Tablo oluşturuldu");
		}else {
			System.out.println("Tablo oluşturulurken bir hata oldu.");
		}
		
		applicationContext.close();
	}
}
