package com.tyy.spring_senior.aop.aspectj;

public class App {
	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.sayHello();
		hello.addUser("Scott", "ScottPassword");
		
		World world = new World();
		world.sayWorld();
		
	}
}
