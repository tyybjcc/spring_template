package com.tyy.spring.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App1 {
	
	public static void main(String[] args) {
		/**
		1.ClassPathXmlApplicationContext:从类路径中加载。
		2.FileSystemXmlApplicationContext:从文件系统加载。
		3.XmlWebApplicationContext:从web系统中加载。
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/basic/beans.xml");		//String... configurationLocations
		Student stu = ac.getBean("student", Student.class );
		System.out.println(stu.getName());
		
		
		
		//通过构造器初始化bean（而不是setters）
		Student stuByConstructor = ac.getBean("student2", Student.class );
		System.out.println(stuByConstructor.getName());
		
	}

}
