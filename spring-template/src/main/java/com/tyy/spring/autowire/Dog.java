package com.tyy.spring.autowire;

public class Dog {
	String name;
	Master master;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Master getMaster() {
		return master;
	}
	public void setMaster(Master master) {
		this.master = master;
	}
	
}
