package com.tyy.spring.bean_lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//BeanNameAware可以获取Bean的id
public class Bean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean{
	int memberInt;
	String memberString;
	
	String beanName;
	BeanFactory beanFactory;
	ApplicationContext applicationContext;
	
	public Bean() {
		System.out.println("Bean被创建，Bean()被调用...");
	}


	public int getMemberInt() {
		return memberInt;
	}


	public void setMemberInt(int memberInt) {
		this.memberInt = memberInt;
	}


	public String getMemberString() {
		return memberString;
	}


	public void setMemberString(String memberString) {
		System.out.println("Bean成员set方法被调用...");
		this.memberString = memberString;
	}
	
	@Override
	public String toString() {
		return "Bean: id("+this.memberInt+"), name("+this.memberString+");";
	}


	public void setBeanName(String name) {
		System.out.println("实现BeanNameAware: setBeanName(String name)被调用...");
		this.beanName = name;
	}


	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("实现BeanFactoryAware: setBeanFactory(BeanFactory beanFactory) throws BeansException 被调用...");
		this.beanFactory = beanFactory;
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("实现ApplicationContextAware: setApplicationContext(ApplicationContext applicationContext) throws BeansException 被调用...");
		this.applicationContext = applicationContext;
		
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("实现InitializingBean: afterPropertiesSet() throws Exception 方法被调用...");
	}

	//如果配置了则不可省略,如果在<beans>中配置了default-init-method，则 如果init方法不存在也不会出错
	public void initMethod() {
		System.out.println("配置init-method: init()方法 被调用...");
	}
	
	
	//使用Bean...
	
	//容器关闭！

	//destroy-method不要配置此方法名，与DisposableBean接口方法名冲突
	//该方法在destroy-method调用前调用
	public void destroy() throws Exception {
		System.out.println("实现DisposableBean: destroy() throws Exception 方法被调用...");
	}
	
	public void destroyMethod() {
		System.out.println("配置destroy-method: destroyMethod()方法 被调用...");
	}


	


	
}
