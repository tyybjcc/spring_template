package com.tyy.spring_ssh.hibernate.common.dao.impl;


import com.tyy.spring_ssh.hibernate.common.dao.BaseDao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;



public class BaseDaoHibernate4<T> implements BaseDao<T> {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public T get(Class<T> entityClazz, Serializable id) {
		return (T) getSessionFactory().getCurrentSession().get(entityClazz, id);
	}

	public Serializable save(T entity) {
		System.out.println("save-----------------------");	//TODO
		try {
			System.out.println( entity.getClass().getDeclaredMethod("getName", new Class[]{}).invoke(entity) );
		} catch(Exception e) {
			e.printStackTrace();
		}
		return getSessionFactory().getCurrentSession().save(entity);
	}

	public void update(T entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
		getSessionFactory().getCurrentSession()
				.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0")
				.setParameter("0", id)
				.executeUpdate();
	}

	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	public long findCount(Class<T> entityClazz) {
		List<?> list = find("select count(*) from " + entityClazz.getSimpleName());	//List<?> 相当于 List
		if (list != null && list.size() == 1) {
			return (Long) list.get(0);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql) {
		return (List<T>) getSessionFactory().getCurrentSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String hql, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return (List<T>) query.list();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize) {
		return getSessionFactory().getCurrentSession().createQuery(hql)
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i + "", params[i]);
		}
		return query
				.setFirstResult((pageNo - 1) * pageSize)
				.setMaxResults(pageSize)
				.list();
	}
}
