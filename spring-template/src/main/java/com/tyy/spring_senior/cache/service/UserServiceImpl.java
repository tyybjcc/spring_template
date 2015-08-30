package com.tyy.spring_senior.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tyy.spring_senior.cache.domain.User;

@Service("userService")
@Cacheable(value="default")
public class UserServiceImpl {

	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getInt(int id) {
		return 0;
	}

}
