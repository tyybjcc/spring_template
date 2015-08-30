package com.tyy.spring_senior.aop.spring_aop.annotation.service;

import org.springframework.stereotype.Service;

@Service	//默认bean id 为 helloService
public class HelloService {
	public void sayHello() {
		System.out.println("hello");
	}
	
	public int getNumber() {
		System.out.println("get Number...");
		return 5;
	}
	
	public void throwError() throws Exception {
		throw new Exception();
	}
	
	public void fun(int a, String s, Object o) {
		System.out.println("fun(int a, String s, Object o)执行。。。");
	}

}
