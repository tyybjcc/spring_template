package com.tyy.spring4.built_in_factory_beans.field_retrieving;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		//可以获取静态field或实例field，实例field还需要指定对象（不常用）。 field必须是public修饰的
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/tyy/spring4/built_in_factory_beans/beans.xml",
				"com/tyy/spring4/built_in_factory_beans/field_retrieving/beans.xml");
		System.out.println( ctx.getBean("field1") );
		
		System.out.println( ctx.getBean("sql_transaction_mode") );
		
		System.out.println( ctx.getBean("transaction") );
		
	}
		
}
