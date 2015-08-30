package com.tyy.spring_senior.transaction.annotation.dao;

public interface UserDao {
	public boolean insertWithTransactionSupport(int id,User user);
	public boolean insertWithoutTransactionSupport(int id,User user);
}
