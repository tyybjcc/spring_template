package com.tyy.spring4.built_in_factory_beans;

import java.util.Random;

public class DemoBean {
	String demoField;
	public static int demoStaticField;
	
	public String method() {
		return "method invoked!";
	}
	
	public static String staticMethod() {
		return "static method invoked!";
	}

	public String getDemoField() {
		return demoField;
	}

	public void setDemoField(String demoField) {
		this.demoField = demoField;
	}
	
	public void setDemoStaticField(int input) {
		DemoBean.demoStaticField = input;
	}
	
	

}
