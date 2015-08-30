package com.tyy.spring4.event;

public class Message {
	int id;
	String msg;
	
	public Message(int id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
