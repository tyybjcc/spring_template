package com.tyy.spring_senior.transaction.xml;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/transaction/xml/beans.xml");
		
		Service service = ac.getBean(Service.class);
		try{
			service.insert();
		} catch(Exception e){}
		
		/**
		 * result： insert插入回滚
		 */
		
	}

}