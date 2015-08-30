package com.tyy.spring4.create_bean.factory_bean;

import java.lang.reflect.Field;

import org.springframework.beans.factory.FactoryBean;


public class FieldFactoryBean implements FactoryBean<Object> {
	private String targetClass;
	private String targetField;
	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}
	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}
	
	
	public Object getObject() throws Exception {
		Class<?> clazz = Class.forName(targetClass);
		Field field = clazz.getField(targetField);
		return field.get(null);
	}
	
	public Class<?> getObjectType() {
		try {
			return Class.forName(targetClass);
		} catch (ClassNotFoundException e) {
			return Object.class;
		}
	}
	public boolean isSingleton() {
		return false;
	}
	
	

}
