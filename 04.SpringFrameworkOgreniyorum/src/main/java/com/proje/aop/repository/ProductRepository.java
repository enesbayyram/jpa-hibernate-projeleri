package com.proje.aop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proje.model.Product;

@Component("productRepository")
public class ProductRepository {

	private List<Product> productList = new ArrayList<>();

	public void save(Product product) {
		this.productList.add(product);
		System.out.println("Product Eklendi.");
	}

	public void delete(int index) {
		this.productList.remove(index);
		System.out.println("Product silindi.");
	}

	public Product getProduct(int index)
	{
		if(index<0)
		{
			throw new IllegalArgumentException("Geçersiz index değeri : "+ index);
		}
			Product product = this.productList.get(index);
			return product;
	}

	public List<Product> getProductList() {
		System.out.println("Product Listesi getirildi.");
		return this.productList;

	}

}
