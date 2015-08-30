package com.tyy.spring_ssh.hibernate.common.dao;

import java.util.List;
import java.io.Serializable;

public interface BaseDao<T>
{
	T get(Class<T> entityClazz , Serializable id);
	Serializable save(T entity);
	//更新或保存
	void update(T entity);
	void delete(T entity);
	void delete(Class<T> entityClazz , Serializable id);
	// 获取所有实体
	List<T> findAll(Class<T> entityClazz);
	long findCount(Class<T> entityClazz);
}
