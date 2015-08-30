package com.tyy.spring_ssh.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.tyy.spring_ssh.struts2.service.MyService;

public class LoginAction extends ActionSupport
{
	private String username;
	private String password;
	private MyService ms;
	public void setMs(MyService ms)
	{
		this.ms = ms;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}

	public String execute() throws Exception
	{
		
		if (ms.validLogin(getUsername(), getPassword()) > 0)
		{
			addActionMessage("验证成功！");
			return SUCCESS;
		}
		return ERROR;
	}
}
