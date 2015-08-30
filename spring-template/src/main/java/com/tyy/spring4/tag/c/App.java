package com.tyy.spring4.tag.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring4.tag.Cellphone;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/tag/c/beans.xml");
		
		System.out.println(ac.getBean("cellphone1",Cellphone.class).getInfo());
		System.out.println(ac.getBean("cellphone2",Cellphone.class).getInfo());
		
	}

}
