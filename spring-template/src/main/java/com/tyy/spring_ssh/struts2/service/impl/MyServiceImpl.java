package com.tyy.spring_ssh.struts2.service.impl;

import com.tyy.spring_ssh.struts2.service.MyService;

public class MyServiceImpl implements MyService
{
	public int validLogin(String username , String pass)
	{
		if ( username.equals("Scott")
			&& pass.equals("123") )
		{
			return 99;
		}
		return -1;
	}
}
