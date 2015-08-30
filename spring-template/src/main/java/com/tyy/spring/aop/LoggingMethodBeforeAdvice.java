package com.tyy.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;

public class LoggingMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("LoggingMethodBeforeAdvice before(Method method, Object[] args, Object target) throws Throwable 被织入...");
	}

}
