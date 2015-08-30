package com.tyy.spring.locale;

import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Locale.Category;

import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/locale/beans.xml");
		
		String hello = ac.getMessage("hello", new String[]{"孙悟空"}, Locale.getDefault());
		String now = ac.getMessage("now", new Object[]{new Date()}, Locale.getDefault(/*Locale.Category.FORMAT*/));
		System.out.println(hello);
		System.out.println(now);
		
		String hello2 = ac.getMessage("hello", new String[]{"孙悟空"}, Locale.US);
		String now2 = ac.getMessage("now", new Object[]{new Date()}, Locale.US);
		System.out.println(hello2);
		System.out.println(now2);
				
		
	}

}
