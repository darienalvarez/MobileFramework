package com.gazoomobile.mfw.platform.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.DataAccessException;

public abstract class GenericDao<T extends Serializable, K extends Serializable>
implements Dao<T, K>
{
	private Class<T> persistenceClass;
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericDao()
	{
		ParameterizedType type = (ParameterizedType)getClass().getGenericSuperclass();
		this.persistenceClass = ((Class<T>)type.getActualTypeArguments()[0]);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		Session session = (Session)this.entityManager.getDelegate();
		Transaction t = session.beginTransaction();

		List<T> result = null;
		try {
			Criteria criteria = session.createCriteria(this.persistenceClass);
			criteria.setCacheMode(CacheMode.IGNORE);

			result = criteria.list();
		} catch (DataAccessException e) {
			t.rollback();
			throw e;
		}

		t.commit();
		return result;
	}

	public T getById(K id) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();

		T result = null;
		try {
			result = this.entityManager.find(this.persistenceClass, id);
			this.entityManager.refresh(result);
		} catch (DataAccessException e) {
			t.rollback();
			throw e;
		}

		t.commit();
		return result;
	}

	public T InsertOrUpdate(T entity) {
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		try
		{
			T result = this.entityManager.merge(entity);
			this.entityManager.flush();

			t.commit();
			
			return result;
		} catch (PersistenceException e) {
			t.rollback();
			throw e;
		}
	}

	public void Delete(T entity)
	{
		EntityTransaction t = this.entityManager.getTransaction();
		t.begin();
		try
		{
			this.entityManager.remove(entity);
			this.entityManager.flush();
		} catch (DataAccessException e) {
			t.rollback();
			throw e;
		}

		t.commit();
	}

	public void setEntityManagerFactory(EntityManagerFactory factory) {
		this.entityManager = factory.createEntityManager();
	}
}