package com.tyy.spring4.tag.p;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring4.tag.Cellphone;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/tag/p/beans.xml");
		
		System.out.println(ac.getBean("galaxys6",Cellphone.class).getInfo());
		
	}

}
