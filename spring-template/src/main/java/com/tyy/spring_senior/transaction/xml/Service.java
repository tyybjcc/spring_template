package com.tyy.spring_senior.transaction.xml;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Service {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void insert() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into tb1(id,name,age) values(?,'Allen',12)",5);
		jdbcTemplate.update("insert into tb1(id,name,age) values(?,'Allen',12)",5);
	}
	public void delete() {
		
	}
	public void update() {
		
	}
	public void get() {
		
	}

}
