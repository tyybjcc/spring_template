package com.tyy.spring_senior.aop.spring_aop.annotation.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AuthAspect {
	@Before("execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..))")
	public void auth() {
		System.out.println("模拟权限检查");
	}
}
