package com.tyy.spring_senior.aop.spring_aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring_senior.aop.spring_aop.annotation.service.HelloService;

public class App {
	
	public static void main(String... args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/aop/spring_aop/annotation/beans.xml");
		
		HelloService helloService = ac.getBean("helloService",HelloService.class);
		
		helloService.sayHello();	//无返回值则不会调用@AfterReturning Advice
		
		System.out.println();
		helloService.getNumber();
		
		System.out.println();
		try{
			helloService.throwError();
		} catch(Exception e) {
			System.out.println("App main 捕获了异常");
		}
		
		System.out.println();
		System.out.println();
		helloService.fun(0, "a", null);
		
	}
}
