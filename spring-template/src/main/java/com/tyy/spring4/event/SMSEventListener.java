package com.tyy.spring4.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * SendEmailEvent extends ApplicationEvent
 * 通过指定类型参数类型 来指定处理某一具体的ApplicationEvent
 *
 */
public class SMSEventListener implements ApplicationListener<SendSMSEvent> {

	public void onApplicationEvent(SendSMSEvent event) {
		System.out.println(event);
		System.out.println("deal with sms event: "+ ((Message)event.getSource()).getMsg() );
	}

}
