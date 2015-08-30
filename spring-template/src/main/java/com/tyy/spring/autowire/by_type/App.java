package com.tyy.spring.autowire.by_type;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/tyy/spring/autowire/by_type/beans.xml");
		IMaster master = ctx.getBean("master", IMaster.class);
		ISlave slave = ctx.getBean("slave", ISlave.class);
		System.out.println(master);
		System.out.println(slave.getMaster());
		System.out.println();
		System.out.println(slave);
		System.out.println(master.getSlave());
		
	}
}
