package com.tyy.spring.bean_lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/bean_lifecycle/beans.xml");
		Bean b = ac.getBean("bean", Bean.class);
		System.out.println("使用Bean: "+b);
		
		//程序优雅地关闭
		ac.registerShutdownHook();
		
	}

}
