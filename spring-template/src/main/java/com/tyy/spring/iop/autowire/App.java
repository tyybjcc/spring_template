package com.tyy.spring.iop.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/iop/autowire/beans.xml");
		Man man = ac.getBean("man",Man.class);
		
		man.manChop();
		
	}
}
