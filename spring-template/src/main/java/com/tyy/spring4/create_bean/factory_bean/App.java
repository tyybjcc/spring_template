package com.tyy.spring4.create_bean.factory_bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/create_bean/factory_bean/beans.xml");
		System.out.println( ac.getBean("field1") );
	}
}
