package com.proje.test;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.proje.db.model.Product;
import com.proje.repository.ICrudDAOService;
import com.proje.repository.impl.CrudDAOServiceImpl1;
import com.proje.repository.impl.CrudDAOServiceImpl2;

public class Test {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CrudDAOServiceImpl2 crudDAOService = applicationContext.getBean("crudDAOServiceImpl2",CrudDAOServiceImpl2.class);

//		Product product1 =new Product(2, "Iphone 7", 3230, 2, new Date());
//		Product product2 =new Product(3, "Laptop", 5200, 5, new Date());
//		Product product3 =new Product(4, "Mouse", 220, 1, new Date());
//		Product product4 =new Product(5, "Power Bank", 80, 25, new Date());
//		
//		List<Product> productList=new ArrayList<Product>();
//		productList.add(product1);
//		productList.add(product2);
//		productList.add(product3);
//		productList.add(product4);
		
//		int saveCount=crudDAOService.saveProductList(productList);
//		if(saveCount>0)
//		{
//			System.out.println(saveCount+" adet ürün eklenmiştir");
//		}else {
//			System.out.println("Ürünler eklenemedi.");
//		}
//		Product product = crudDAOService.getProductById(5);
//		System.out.println(product);
		
		
//		List<Product> productList = crudDAOService.getProductList();
//		for (Product product : productList) {
//			System.out.println(product);
//		}
		
//		Product product = crudDAOService.getProductById(1);
//		product.setPrice(2332);
//		boolean result = crudDAOService.update(product);
//		if(result)
//		{
//			System.out.println("Product güncellendi");
//		}else {
//			System.out.println("Product güncellenirken bir hata oluştu!");
//		}
		
//		Product product= crudDAOService.getProductByIdBPRM(1);
//		System.out.println(product);
		
		List<Product> productList = crudDAOService.getProductList();
		for (Product product : productList) {
			System.out.println(product);
		}
		applicationContext.close();
	}
}
