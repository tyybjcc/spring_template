package com.tyy.spring4.create_bean.static_factory_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/create_bean/static_factory_method/beans.xml");
		
		AnimalInter animal = ac.getBean("dog", AnimalInter.class);
		
		animal.descItself();
		
	}
}
