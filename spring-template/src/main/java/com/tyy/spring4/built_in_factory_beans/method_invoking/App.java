package com.tyy.spring4.built_in_factory_beans.method_invoking;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/tyy/spring4/built_in_factory_beans/beans.xml",
				"com/tyy/spring4/built_in_factory_beans/method_invoking/beans.xml");
		System.out.println(ctx.getBean("rtn1"));
		System.out.println(ctx.getBean("rtn2"));
	}
}
