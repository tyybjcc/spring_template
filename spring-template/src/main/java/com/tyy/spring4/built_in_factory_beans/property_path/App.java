package com.tyy.spring4.built_in_factory_beans.property_path;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/tyy/spring4/built_in_factory_beans/beans.xml",
				"com/tyy/spring4/built_in_factory_beans/property_path/beans.xml");
		System.out.println( ctx.getBean("field1") );
		
		InfoWrapper wrapper = ctx.getBean("infoWrapper", InfoWrapper.class);
		System.out.println(wrapper.getInfo());
		
		InfoWrapper wrapper2 = ctx.getBean("infoWrapper2", InfoWrapper.class);
		System.out.println(wrapper2.getInfo());
	}
}
