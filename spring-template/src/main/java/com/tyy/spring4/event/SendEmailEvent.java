package com.tyy.spring4.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailEvent extends ApplicationEvent {
	String message;

	public SendEmailEvent(Object source) {
		super(source);
		//this.message = "an sending email event occurs...";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
