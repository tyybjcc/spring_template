package com.tyy.spring_senior.aop.spring_aop.annotation.aspect;

import java.util.jar.JarException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogAspect {
	
	// 无论是否正常返回、返回什么、是否抛出异常，@After增强都会执行，且在@AfterReturning @AfterThrowing之前执行
	@After("execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..))")
	public void log() {
		System.out.println("logging");
	}
	
	@AfterReturning(returning="result", pointcut="execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..)))")
	public void printResult(int result) {	//如果要匹配所有类型，包括null，则形参类型应设为Object （基本类型与装箱类型适配），类型不适配该Advice不会被触发
		System.out.println("返回值为："+result);
	}
	
	//该Advice不能catch异常，因此异常传播不会影响
	@AfterThrowing(throwing="e", pointcut="execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..)))")
	public void recover(Throwable e) {	// Throwable可以匹配任何异常
		System.out.println("发现了异常"+e.getMessage()+", Throwable会继续传播");
	}
	
	@Around("execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..)))")
	public Object process(ProceedingJoinPoint jp) throws java.lang.Throwable {	//ProceedingJointPoint是JointPoint的子类
		System.out.println("process: 执行之前");
		Object[] args;
		{
			args = jp.getArgs();
			//处理参数
		}
		Object rtn = jp.proceed(args);
		{
			//返回之前可以操纵rtn
		}
		System.out.println("process: 执行之后");
		return rtn;
	}
	
	
	//测试以下exccution表达式
	@Before("execution(* *(int,String, ..))")
	public void testExecution() {
		System.out.println("测试execution表达式.............匹配成功！");
	}
}
