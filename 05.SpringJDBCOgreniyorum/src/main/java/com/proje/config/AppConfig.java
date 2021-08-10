package com.proje.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.proje.db.model.Database;

@Configuration
@ComponentScan("com.proje") // @Autowired , @Component, @Repository gibi anatasyonları aktif etti bu anatasyon.
public class AppConfig {

	@Bean(name = "database")
	public Database database()
	{
		return new Database("jdbc:mysql://localhost:3306/spring_jdbc", "com.mysql.cj.jdbc.Driver", "root", "1234");
	}
	
	@Bean
	public DataSource dataSource()
	{
		//Implemente ettiği interface olarak dönüyorum 10 kat daha hızlı çalıştığı için classa göre.
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
}
