package com.tyy.spring4.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/tyy/spring4/event/beans.xml");
		
		SendEmailEvent sendEmail = new SendEmailEvent(new Object());
		ac.publishEvent(sendEmail);
		
		System.out.println();
		
		SendSMSEvent sendSMS = new SendSMSEvent(new Message(2,"no.02 msg"));
		ac.publishEvent(sendSMS);
		
	}

}
