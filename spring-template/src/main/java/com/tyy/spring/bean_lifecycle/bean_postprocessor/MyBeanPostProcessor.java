package com.tyy.spring.bean_lifecycle.bean_postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("实现并配置BeanPostProcessor: Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException 方法 被调用...");
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("实现并配置BeanPostProcessor: Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 方法 被调用...");
		return bean;
	}

}
