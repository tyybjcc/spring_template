package com.tyy.spring_senior.transaction.annotation.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// @Transactional 可用在类和方法上
public class UserDaoImpl implements UserDao {

	
	DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.DEFAULT,
			timeout=5
			)
	public boolean insertWithTransactionSupport(int id, User user) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		jt.update("insert into tb1"
				+ " values(?, ? , ?)"
				,id
				,user.getName(),
				user.getAge());
		jt.update("insert into tb1"
				+ " values(?, ? , ?)"
				,id
				,user.getName(),
				user.getAge());
		return false;
	}
	
	public boolean insertWithoutTransactionSupport(int id, User user) {
		JdbcTemplate jt = new JdbcTemplate(ds);
		jt.update("insert into tb1"
				+ " values(?, ? , ?)"
				,id
				,user.getName(),
				user.getAge());
		jt.update("insert into tb1"
				+ " values(?, ? , ?)"
				,id
				,user.getName(),
				user.getAge());
		return false;
	}


}
