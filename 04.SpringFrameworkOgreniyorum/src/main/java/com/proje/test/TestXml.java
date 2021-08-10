package com.proje.test;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.proje.aop.repository.ProductRepository;
import com.proje.autowired.Employee;
import com.proje.component.Kisi;
import com.proje.interfaceKullanimi.IDBConnection;
import com.proje.interfaceKullanimi.impl.MySQLConnection;
import com.proje.interfaceKullanimi.impl.OracleConnection;
import com.proje.model.DBConnection;
import com.proje.model.DBConnectionWithInjection;
import com.proje.model.Database;
import com.proje.model.ListeIslemleri;
import com.proje.model.Product;

public class TestXml {

	public static void main(String[] args) {

		Locale locale = new Locale("tr", "TR");

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ProductRepository productRepository = applicationContext.getBean("productRepository", ProductRepository.class);
		
		Product product =new Product("Huawei P Smart 2019", 1950, 3);
		productRepository.save(product);
		
		System.out.println("************************");
		try {
			Product targetProduct=productRepository.getProduct(-2);
			System.out.println(targetProduct);
		} catch (IllegalArgumentException e) {
			System.out.println("Girilen index değerine denk gelen product yoktur!");
		}

		applicationContext.close();
	}
}
