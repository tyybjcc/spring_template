package com.tyy.spring4.merge;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/merge/beans.xml");
		Professor professor = ac.getBean("professor", Professor.class);
		
		System.out.println(professor);
		
	}

}
