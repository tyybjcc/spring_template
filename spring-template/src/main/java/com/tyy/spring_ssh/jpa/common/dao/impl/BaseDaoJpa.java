package com.tyy.spring_ssh.jpa.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tyy.spring_ssh.jpa.common.dao.BaseDao;


public class BaseDaoJpa<T> implements BaseDao<T> {
	/**
	 * PersistenceAnnotationBeanPostProcessor 后处理器会处理该注解，
	 * 通过EntityManagerFactory获取线程安全的BaseDao
	 */
	@PersistenceContext
	protected EntityManager entityManager;

	public T get(Class<T> entityClazz, Serializable id) {
		return (T) entityManager.find(entityClazz, id);
	}

	public Serializable save(T entity) {
		System.out.println("save-----------------------");	//TODO
		try {
			System.out.println( entity.getClass().getDeclaredMethod("getName", new Class[]{}).invoke(entity) );
		} catch(Exception e) {
			e.printStackTrace();
		}
		entityManager.persist(entity);
		try {
			return (Serializable) entity.getClass().getMethod("getId").invoke(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(entity + "has no method named getId");
		}
	}

	public void update(T entity) {
		entityManager.merge(entity);
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void delete(Class<T> entityClazz, Serializable id) {
		entityManager.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0").setParameter(0, id)
				.executeUpdate();
		// TODO
	}

	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from " + entityClazz.getSimpleName() + " en");
	}

	public long findCount(Class<T> entityClazz) {
		List<?> l = find("select count(*) from " + entityClazz.getSimpleName());
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql) {
		return (List<T>) entityManager.createQuery(jpql).getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> find(String jpql, Object... params) {
		Query query = entityManager.createQuery(jpql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql, int pageNo, int pageSize) {
		return entityManager.createQuery(jpql)
				.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> findByPage(String jpql, int pageNo, int pageSize, Object... params) {
		Query query = entityManager.createQuery(jpql);
		for (int i = 0, len = params.length; i < len; i++) {
			query.setParameter(i, params[i]);
		}
		return query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).getResultList();
	}
}
