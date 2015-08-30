package com.tyy.spring.inherit;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/inherit/beans.xml");
		Boy boy = ac.getBean("boy", Boy.class);
		System.out.println("boy name: "+boy.getName());
		
		BoyStudent boyStudent = (BoyStudent)ac.getBean("boyStudent");
		System.out.println("now his grade is:" + boyStudent.getGrade());
		
		//must use bean inherit
		System.out.println(boyStudent.getName());
		
	}

}
