package com.tyy.spring_senior.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring_senior.cache.service.UserServiceImpl;

/**
 * 
 类级级的缓存：
@Cacheable 用于类，则如果 函数参数列表相同（不论方法、返回值如何），就会返回缓存值，使用时要注意（可能很少用到）。
 */
public class ClassLevelEhCacheTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/cache/beans_EhCache.xml");
		UserServiceImpl userService = ac.getBean(UserServiceImpl.class);
		
		System.out.println( userService.get(1));
		//System.out.println( userService.getInt(1) );	//因为缓存中返回类型和函数实际返回类型不符 而 出现异常
	}
}
