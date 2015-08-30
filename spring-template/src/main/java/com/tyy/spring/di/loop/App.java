package com.tyy.spring.di.loop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	// Spring可以处理循环依赖
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/di/loop/beans.xml");
		Bean1 bean1 = ac.getBean("bean1", Bean1.class);
		Bean2 bean2 = ac.getBean("bean2", Bean2.class);
		
		System.out.println(bean1);
		System.out.println(bean2.getBean1());
		
		System.out.println(bean2);
		System.out.println(bean1.getBean2());
		
		
		System.out.println("\nBy autowire:");
		Bean1 bean12 = ac.getBean("bean12", Bean1.class);
		Bean2 bean22 = ac.getBean("bean22", Bean2.class);
		
		System.out.println(bean12);
		System.out.println(bean22.getBean1());
		
		System.out.println(bean22);
		System.out.println(bean12.getBean2());
		
	}

}
