package com.proje.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.proje.model.DBConnection;

//Bean oluşturulmadan önce ve sonra işlemler yaptırmak için kullanılır.
public class PostProcessor implements BeanPostProcessor{
 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("Bean oluşturultan sonra :");
		if(bean instanceof DBConnection)
		{
			System.out.println("Bean Type: " + bean + " Bean Name : " + beanName);
		}
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean oluşturulmadan önce  Bean Type :" +bean + " Bean Name : " + beanName);
		return bean;
	}
}
