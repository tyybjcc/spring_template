package com.tyy.spring_senior.aop.aspectj;

public class Hello {
	
	public void sayHello() {
		System.out.println("执行Hello sayHello() 方法...");
	}
	
	public int addUser(String name, String password) {
		System.out.println("Hello 组件执行addUser操作");
		return 1;
	}

}
