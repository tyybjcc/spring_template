package com.tyy.spring.aop;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Map.Entry;

import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/aop/beans.xml");
		
		
		//MyService myService = (MyService)ac.getBean("myServiceWithLogging");	//虽然是MyService代理对象，但却不能强转为MyService类型
		
		// 动态代理bean只能被转换为  **被代理 ** 的接口类型
		LoggingInter logging = ac.getBean("myServiceWithLogging", LoggingInter.class );
		logging.logging();
		
		
		// toString(), wait()等方法也被织入了
		System.out.println( logging.toString() );
		
		//MyService还是MyService，没有发生变化，只不过用户获得了MyService实现接口的代理
		
		
	}

}
