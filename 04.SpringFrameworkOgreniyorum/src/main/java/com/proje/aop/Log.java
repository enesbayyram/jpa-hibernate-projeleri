package com.proje.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.proje.model.Product;

@Aspect // bu sınıfın bir aop sınıfı olduğunu söylemiş olduk.Bu log sınıfını kullanabilmek için app.xml içine autoproxy ekle.
@Component("log") // applicationContext'e benim yerime bu sınftan bean oluşturup id değerine log koysun dedik.
public class Log {

	
	
	@AfterThrowing(pointcut = "execution  (public * com.proje.aop.repository.ProductRepository.getProduct(*))",throwing = "exception")
	public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException exception)
	{
		System.out.println("Hata konumu :"+joinPoint.getSignature());
		System.out.println("Hata  : "+ exception.getMessage());
	}
	
	
//	@AfterReturning(pointcut = "execution (public * com.proje.aop.repository.ProductRepository.getProduct(*))",returning = "product")
	public void afterReturninAdvice(JoinPoint joinPoint,Product product)
	{
		System.out.println("Return ettikten sonra burası çalıştı :" + joinPoint.getSignature());
		System.out.println("Return edilen deger : "+ product);
	}
	
	
//	@Before(value = "execution (public void com.proje.aop.repository.ProductRepository.save(*))")
//	@Before(value = "execution (public * com.proje.aop.repository.ProductRepository.save(*))")
//	@Before(value = "execution (public * *.save(*))")
//	@Before(value = "pointCutProductRepository()")
	public void beforeSave(JoinPoint joinPoint)
	{
		System.out.println("Product işlemi başlıyor : " + joinPoint.getSignature());
		//sessionFactory.openSession();
	}
	
//	@After(value = "pointCutProductRepository()")
	public void afterSave(JoinPoint joinPoint)
	{
		System.out.println("Product işlemi bitiyor : " + joinPoint.getSignature());
		//sessionFactory.closeSession();
	}
//  @Pointcut(value = "within (com.proje.aop.repository.*)")
//	@Pointcut(value = "execution (public void com.proje.aop.repository.ProductRepository.save(*))")
//  @Pointcut(value = "within (com.proje.aop.repository.ProductRepository)")
	public void pointCutProductRepository()
	{	
		//metot ismi ile pointcut içinde ki sorgumuz tetikleniyor unutma.
	}
	
	
	
	
	
}
