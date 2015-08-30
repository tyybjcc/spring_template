package com.tyy.spring_senior.resource.classpath_resource;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class App {
	public static void main(String[] args) throws IOException {
		ClassPathResource cRes = new ClassPathResource("com/tyy/spring_senior/resource/classpath_resource/student.xml");
		System.out.println( cRes.getFile().getAbsolutePath() );
		System.out.println(cRes.getDescription());
		
	}
}
