package com.tyy.spring.di.loop;

public class Bean2 {
	String name;
	Bean1 bean1;

	public Bean1 getBean1() {
		return bean1;
	}

	public void setBean1(Bean1 bean1) {
		this.bean1 = bean1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
