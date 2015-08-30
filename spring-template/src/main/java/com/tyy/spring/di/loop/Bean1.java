package com.tyy.spring.di.loop;

public class Bean1 {
	String name;
	Bean2 bean2;

	public Bean2 getBean2() {
		return bean2;
	}

	public void setBean2(Bean2 bean2) {
		this.bean2 = bean2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
