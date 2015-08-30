package com.tyy.spring4.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * SendEmailEvent extends ApplicationEvent
 * 通过指定类型参数类型 来指定处理某一具体的ApplicationEvent
 *
 */
public class EmailEventListener implements ApplicationListener<SendEmailEvent> {

	
	public void onApplicationEvent(SendEmailEvent event) {
		System.out.println(event);
		System.out.println("deal with email event: send mail...");
		
		
		if(event instanceof SendEmailEvent) {
			System.out.println("event -> instanceof SendEmailEvent");
		} else {
			System.out.println("event **not** instanceof SendEmailEvent");
		}
	}

}
