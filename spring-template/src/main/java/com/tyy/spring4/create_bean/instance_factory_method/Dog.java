package com.tyy.spring4.create_bean.instance_factory_method;

public class Dog implements AnimalInter {
	int age;
	
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	public void descItself() {
		System.out.println("Dog: age("+age+")");
		
	}

}
