package com.tyy.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AuthenticationMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AuthenticationMethodBeforeAdvice before(Method method, Object[] args, Object target) throws Throwable ±ª÷Ø»Î...");
	}

}
