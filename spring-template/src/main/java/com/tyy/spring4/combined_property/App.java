package com.tyy.spring4.combined_property;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/combined_property/beans.xml");
		
		Man man = ac.getBean("man", Man.class);
		System.out.println( man.getDog().getName() );
		
	}
}
