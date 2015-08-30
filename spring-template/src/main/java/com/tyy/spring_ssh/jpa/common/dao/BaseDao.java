package com.tyy.spring_ssh.jpa.common.dao;

import java.util.List;
import java.io.Serializable;

public interface BaseDao<T>
{
	T get(Class<T> entityClazz , Serializable id);
	Serializable save(T entity);
	void update(T entity);
	void delete(T entity);
	void delete(Class<T> entityClazz , Serializable id);
	List<T> findAll(Class<T> entityClazz);
	long findCount(Class<T> entityClazz);
}
