package com.tyy.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/autowire/beans.xml");
		
		Dog dog = ac.getBean("dog", Dog.class );
		System.out.println("dog "+dog.getName()+", its owner is "+dog.getMaster().getName());
		
	}

}
