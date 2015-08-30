package com.tyy.spring.iop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/iop/beans.xml");
		ConverterInter converter = ac.getBean("converter", ConverterInter.class);
		System.out.println( converter.convert("abc") );
		ConverterInter converter2 = ac.getBean("converter2", ConverterInter.class);
		System.out.println( converter2.convert("abc") );
	}
}
