package com.proje.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import com.proje.beanFactoryPostProcessor.BeanFactory;
import com.proje.beanPostProcessor.PostProcessor;
import com.proje.component.Kisi;
import com.proje.model.DBConnection;
import com.proje.model.DBConnectionWithInjection;
import com.proje.model.Database;
import com.proje.model.Employee;
import com.proje.model.ListeIslemleri;

//@PropertySources({
//	@PropertySource("db.properties")
//})
@Configuration
@ComponentScan(value = "com.proje") //@Component anatasyonunu kullanmamı sağlayan ve nerede bulmak gerektiğini söyleyen anatasyondur.
@EnableAspectJAutoProxy //@Aspect anatasyonunu kullanımını aktif edip aspect kullanmayı açmış olduk
@Import(value = {DatabaseConfig.class,BeansConfig.class})
@PropertySource(value = "classpath:db.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
//	public void setEnv(Environment env) { @Autowired anatasyonunun yaptığı şey bu aslında contextten gelen Environment 'i metota parametre olarak gönderip
//		this.env = env;//sınıf içinde tanımlanmış Environment değişkenine setliyor çok basit aslında. Birbirine bağlama yöntime name'e göre değil TÜRE GÖRE!!!
//	}
	
	@Bean
	public Database database()
	{
		String url= this.env.getProperty("url");
		String username = this.env.getProperty("usernamee");
		String password = this.env.getProperty("password");
		return new Database(url, username, password);
	}
	
	
//	@Bean(name = "messages")
//	public ResourceBundleMessageSource messageSourceBean()
//	{
//		ResourceBundleMessageSource messageSource =new ResourceBundleMessageSource();
//		messageSource.setBasename("messages/msg");
//		messageSource.setDefaultEncoding("UTF-8");
//		return messageSource;
//	}

//	@Value(value = "${url}")
//	private String url;
//	
//	@Value(value = "${username}")
//	private String username;
//	
//	@Value(value = "${password}")
//	private String password;
//	
//	@Bean(name = "database")
//	public Database databaseBean()
//	{
//		return new Database(url, username, password);
//	}
//	
//	@Bean
//	public BeanFactoryPostProcessor createBeanFactory()
//	{
//		return new BeanFactory();
//	}
//	
//	@Bean
//	public BeanPostProcessor createPostProcessor()
//	{
//		return new PostProcessor();
//	}
//	
//	
//	@Bean(name ="dbConnectionInitialize" , initMethod = "validation")
//	public DBConnection createDbConnection()
//	{
//		DBConnection dbConnection =new DBConnection();
//		dbConnection.setUrl("mysql:localhost");
//		dbConnection.setUsername("bayramenes");
//		return dbConnection;
//	}
//	
//	
//	@Bean(name = "dbConnectionWithInjectionMultipleObject")
//	public DBConnectionWithInjection createDbConnectionWithInjectionBean()
//	{
//		Database database =new Database("mysql:localhost", "bayramenes", "2123");
//		Employee employee =new Employee("Enes", "Bayram", 22);
//		
//		DBConnectionWithInjection dbConnect =new DBConnectionWithInjection(database, employee);
//		
//		return dbConnect;
//	}
//	
//
//	
//	
//	@Bean(name = "dbConnectionMySql")
//	
//	public DBConnection createDBConnectionMySql()
//	{
//		return new DBConnection("jdbc:mysql://localhost:8080/veritabani_adi", "enes11", "2223312");
//	}
//	
//	@Bean(name = "dbConnectionOracle")
//	public DBConnection createDBConnectionOracle()
//	{
//		return new DBConnection("jdbc:oracle://localhost:8080/veritabani_adi", "oracleuser", "45234");
//	}
//		
//	@Bean
//	public ListeIslemleri createListeIslemleriBean()
//	{
//		ListeIslemleri listeIslemleri =new ListeIslemleri();
//		listeIslemleri.setFirstName("Enes");
//		listeIslemleri.setLastName("Bayram");
//		
//		List<String> userList =new ArrayList<>();
//		userList.add("Enes");
//		userList.add("Ahmet");
//		userList.add("Mehmet");
//		userList.add("Murat");
//		listeIslemleri.setUsersList(userList);
//		
//		Map<String, String> userMap=new HashMap<>();
//		userMap.put("1", "Enes");
//		userMap.put("2", "Ahmet");
//		userMap.put("3", "Mehmet");
//		userMap.put("4", "Murat");
//		listeIslemleri.setUsersMap(userMap);
//		
//		return listeIslemleri;
//	}
	
}
