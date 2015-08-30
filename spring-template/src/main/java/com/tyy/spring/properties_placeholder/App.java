package com.tyy.spring.properties_placeholder;

import java.awt.font.MultipleMaster;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.mysql.fabric.xmlrpc.base.Data;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/properties_placeholder/beans.xml");
		
		DataSource ds1 = ac.getBean("dataSource1", DataSource.class);
		System.out.println(ds1);
		System.out.println();
		
		DataSource ds2 = ac.getBean("dataSource2", DataSource.class);
		System.out.println(ds2);
		System.out.println();
		
	}

}
