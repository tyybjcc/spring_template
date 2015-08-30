package com.tyy.spring_senior.transaction.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tyy.spring_senior.transaction.annotation.dao.User;
import com.tyy.spring_senior.transaction.annotation.dao.UserDao;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring_senior/transaction/annotation/beans.xml");
		UserDao userDao = ac.getBean(UserDao.class);
		
		User user = new User();
		user.setName("Scott2");
		user.setAge(25);
		try{
			userDao.insertWithTransactionSupport(3, user);
		} catch(Exception e) {}
		try{
			userDao.insertWithoutTransactionSupport(4, user);
		} catch(Exception e) {}
		
		//结果：3记录不会被插入（出现异常回滚），4会
		
		
	}

}
