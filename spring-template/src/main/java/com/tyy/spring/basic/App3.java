package com.tyy.spring.basic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App3 {
	/**
	 * 通过别名取bean，
	 * @param args
	 */
	public static void main(String[] args) {
		Resource res = new ClassPathResource("com/tyy/spring/basic/beans.xml");		//或者通过FileSystemResource实现类
		DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader( lbf ).loadBeanDefinitions( res );
		
		Student stu = lbf.getBean("\\1a",Student.class);
		System.out.println(stu);
		
		stu = lbf.getBean("\\b*", Student.class);
		System.out.println(stu);
		
	}

}
