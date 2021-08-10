package com.proje.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

// application-context.xml okunur okunmaz bu bean içindeki metot çalışıyor mantığı bu şekilde yerine göre kullanabiliriz.
public class BeanFactory implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("application-context.xml okundu.");
//		System.out.println("application-context.xml içerisinde toplam bulunan bean sayısı : " + beanFactory.getBeanDefinitionCount());
	}

}
