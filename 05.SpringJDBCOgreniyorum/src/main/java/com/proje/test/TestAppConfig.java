package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.config.AppConfig;
import com.proje.db.model.Product;
import com.proje.repository.ICrudDAOService;
import com.proje.repository.impl.CrudDAOServiceImpl1;

public class TestAppConfig {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ICrudDAOService crudDAOService = applicationContext.getBean("crudDAOServiceImpl",CrudDAOServiceImpl1.class);
		Product product = crudDAOService.getProductById(1);
		System.out.println(product);
		applicationContext.close();
	}
}
