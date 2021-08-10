package com.proje.repository.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.proje.db.model.Product;
//1-veritabanı işlemleri yapılan sınıf üzerinde tanımlanır.
//2- Aynı component anatasyonu gibi bizim yerimize app.xml 'de bean oluşturur.(ÇOK ÖNEMLİ)
@Repository //<bean id="crudDAOServiceImpl2"  class="com.proje.respository.impl.CrudDAOServiceImpl/>
public class CrudDAOServiceImpl2{
	
	private JdbcTemplate jdbcTemplate;

	public Product getProductById(Integer id) {
		
		String query = "SELECT * FROM product WHERE productId=?";
		Product product = null;
		try {
			Map<String, Object> map = this.jdbcTemplate.queryForMap(query, new Object[] {id});
			Integer productId = (Integer)map.get("productId");
			String productname =(String)map.get("productname");
			double price = (double)map.get("price");
			int avaible = (int)map.get("avaible");
			Date createDate =(Date)map.get("createdate");
			product =new Product(productId, productname, price, avaible, createDate);
		} catch (Exception e) {
			System.out.println("Hata : " +e.getMessage());
		}
		return product;
	}
	
	public List<Product> getProductList() {
		String query = "SELECT * FROM product";
		List<Product> productList = new ArrayList<Product>(); 
		Product product = null;
		try {
			List<Map<String, Object>> queryForList = this.jdbcTemplate.queryForList(query);
			for (Map<String, Object> map : queryForList) {
				Integer productId = (Integer)map.get("productId");
				String productname =(String)map.get("productname");
				double price = (double)map.get("price");
				int avaible = (int)map.get("avaible");
				Date createDate =(Date)map.get("createdate");
				product =new Product(productId, productname, price, avaible, createDate);
				productList.add(product);
			}
		} catch (Exception e) {
			System.out.println("Hata :"+e.getMessage());
		}
		return productList;
	}
	
	
	@Autowired
	public void setDrivermanager(DataSource dataSource) { //AppConfig ve xml içindeki bean return type ile bu metotun parametre tipi mapleniyor.
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}

	
}
