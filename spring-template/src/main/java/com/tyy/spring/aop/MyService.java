package com.tyy.spring.aop;

public class MyService implements LoggingInter, AuthenticationInter{
	
	public void serve() {
		System.out.println("MyService: serve()...");
	}

	public void authentication() {
		System.out.println("MyService authentication() executing...");
	}

	public void logging() {
		System.out.println("MyService logging() executing...");
	}
	
	

}
