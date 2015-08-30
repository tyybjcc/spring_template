package com.tyy.spring.collection;

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
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring/collection/beans.xml");
		Employee e1 = ac.getBean("employee1", Employee.class);
		Employee e2 = ac.getBean("employee2", Employee.class);
		Department depart = (Department)ac.getBean("department");
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println("Department: "+depart.getId()+" "+depart.getName() );
		
		
		System.out.println("\nArray:");
		for(Employee e:depart.getEmployeeArray()) {
			System.out.println(e);
		}
		
		System.out.println("\nList:");
		System.out.println(depart.getEmployeeList().getClass());
		for(Employee e:depart.getEmployeeList()) {
			System.out.println(e);
		}
		
		//Set元素具有唯一性，多次添加不会报错，但无效（本例中应该重写Employee的equals方法和hashCode方法）
		System.out.println("\nSet:");
		System.out.println(depart.getEmployeeSet().getClass());
		for(Employee e:depart.getEmployeeSet()) {
			System.out.println(e);
		}
		
		System.out.println("\nMap:");
		System.out.println(depart.getEmployeeMap().getClass());
		for(Entry<String,Employee> entry : depart.getEmployeeMap().entrySet()) {
			System.out.println("key: "+entry.getKey()+"; value: "+entry.getValue()); 
		}
		
		System.out.println("\nProperties:");
		System.out.println(depart.getEmployeeProperties().getClass());
		Properties prop =  depart.getEmployeeProperties();
		Enumeration<String> propNames = (Enumeration<String>) prop.propertyNames();
		while(propNames.hasMoreElements()) {
			String propName = propNames.nextElement();
			System.out.println("Property -> key: "+propName + ", value: " + prop.getProperty(propName));
		}
		
		
		
	}

}
