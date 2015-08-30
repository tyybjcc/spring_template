package com.tyy.spring_senior.resource.more;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoaderTest {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext();
		/**
		 * Spring可以根据file: http: classpath: 判断要使用的Resource实现类； 如果没有前缀，则根据ApplicationContext实现类判定
		 * ApplicationContext 实现了ResourceLoader接口，可以通过getResource("")获得Resource
		 */
		Resource res = ac.getResource("com/tyy/spring_senior/resource/more/demoFile");
		System.out.println( res.getDescription() );
		
	}
}
