package com.tyy.spring4.lookup_method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/tyy/spring4/lookup_method/beans.xml");
		
		Student student1 = ctx.getBean("student", Student.class);
		Student student2 = ctx.getBean("student", Student.class);
		
		System.out.println(student1==student2);
		System.out.println(student1.getLesson().getLesson());
		System.out.println(student2.getLesson().getLesson());
	}
}
