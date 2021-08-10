package com.proje.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje.aop.repository.ProductRepository;
import com.proje.component.Kisi;
import com.proje.config.AppConfig;
import com.proje.model.Database;
import com.proje.model.Product;

public class TestAppConfig {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Database database = applicationContext.getBean(Database.class);
		
		System.out.println("URL : "+ database.getUrl());
		System.out.println("Username : " +database.getUsername());
		System.out.println("Password : " +database.getPassword());
		
		applicationContext.close();
	}
}
