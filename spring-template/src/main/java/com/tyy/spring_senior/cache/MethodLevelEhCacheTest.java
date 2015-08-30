package com.tyy.spring_senior.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring_senior.cache.service.MethodLevelService;

public class MethodLevelEhCacheTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/cache/beans_EhCache.xml");
		MethodLevelService service = ac.getBean(MethodLevelService.class);
		
		Object f1_rtn1 = service.f1(1, "Scott");
		Object f1_rtn2 = service.f1(1, "Scott");
		System.out.println( f1_rtn1==f1_rtn2 );
		
		Object f2_rtn1 = service.f2(1, "Scott");
		System.out.println( f1_rtn1==f2_rtn1 );		// 竟然也相等，这说明
		
		
		
		//System.exit(0);
		
		
	}
}
