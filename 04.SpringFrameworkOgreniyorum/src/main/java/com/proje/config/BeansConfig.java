package com.proje.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proje.component.Kisi;

@Configuration
public class BeansConfig {

	@Bean(name = "kisi")
	public Kisi beanImportTest()
	{
		return new Kisi("Enes", "Bayram", 22);
	}
	
}
