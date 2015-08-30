package com.tyy.spring_senior.resource.more.resource_injection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) throws IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/resource/more/resource_injection/beans.xml");
		
		ResourceWrapper rw1 = ac.getBean("resourceWrapper1",ResourceWrapper.class);
		System.out.println( rw1.getRes().getDescription() );
		
		ResourceWrapper rw2 = ac.getBean("resourceWrapper2",ResourceWrapper.class);
		System.out.println( rw2.getRes().getDescription() );
		
		System.out.println("---------------------");
		BufferedReader br = new BufferedReader( new InputStreamReader( rw1.getRes().getInputStream() ) );
		String line;
		while( (line=br.readLine())!=null ) {
			System.out.println(line);
		}
		
		System.out.println("---------------------");
		br = new BufferedReader( new InputStreamReader( rw1.getRes().getInputStream() ) );
		while( (line=br.readLine())!=null ) {
			System.out.println(line);
		}
		
	}
}
