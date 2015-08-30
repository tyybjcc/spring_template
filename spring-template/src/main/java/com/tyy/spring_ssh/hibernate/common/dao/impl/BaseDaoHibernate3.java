package com.tyy.spring_ssh.hibernate.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.tyy.spring_ssh.hibernate.common.dao.BaseDao;

// 这种方式已经废弃，Spring4为了向后兼容才提供了HibernateDaoSupport HibernateTemplate
// 推荐使用BaseDaoHibernate4.java中的方式：sessionFactory().getCurrentSession()来获取session
public class BaseDaoHibernate3<T> extends HibernateDaoSupport implements BaseDao<T> {	
	public T get(Class<T> entityClazz, Serializable id) {
		return getHibernateTemplate().get(entityClazz, id);
	}

	public Serializable save(T entity) {
		return getHibernateTemplate().save(entity);
	}

	public void update(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> entityClazz) {
		return (List<T>) getHibernateTemplate().find("select en from " + entityClazz.getSimpleName() + " en");
	}

	@SuppressWarnings("unchecked")
	public long findCount(Class<T> entityClazz) {
		List<Long> list = (List<Long>) getHibernateTemplate()
				.find("select count(*) from " + entityClazz.getSimpleName() + " en");
		return list.get(0);
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(final String hql, final int pageNo, final int pageSize) {
		List<T> list = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session) {
				List<T> result = session
						.createQuery(hql)
						.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
		});
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(final String hql, final int pageNo, final int pageSize, final Object... params) {
		List<T> list = getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session) {
				Query query = session.createQuery(hql);
				for (int i = 0, len = params.length; i < len; i++) {
					query.setParameter(i + "", params[i]);
				}
				List<T> result = query
						.setFirstResult((pageNo - 1) * pageSize)
						.setMaxResults(pageSize)
						.list();
				return result;
			}
		});
		return list;
	}

}
