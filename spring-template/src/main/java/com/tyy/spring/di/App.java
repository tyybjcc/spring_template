package com.tyy.spring.di;

import java.awt.font.MultipleMaster;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/di/beans.xml");
		//Master leader = (Master) ac.getBean("master");
		Dog dog = ac.getBean("dog",Dog.class);
		System.out.println("dog is: " + dog.getName());
		System.out.println("dog's master is: "+ dog.getMaster().getName());
		
		//默认bean的scope是singleton
		Dog dog2 = ac.getBean("dog",Dog.class);
		System.out.println(dog==dog2);
		
		
		
		
	}

}
