package com.tyy.spring4.event;

import org.springframework.context.ApplicationEvent;

public class SendSMSEvent extends ApplicationEvent{

	public SendSMSEvent(Message message) {
		super(message);
	}

}
