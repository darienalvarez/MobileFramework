package com.gazoomobile.mfw.platform.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gazoomobile.mfw.platform.dao.ControlDao;
import com.gazoomobile.mfw.platform.dao.GenericDao;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;

public class ControlDaoImpl extends GenericDao<Control, Long>
implements ControlDao
{
	@SuppressWarnings("unchecked")
	public List<ControlProperty> getControlProperties(String controlType)
	{
		String query = "SELECT p FROM ControlProperty p WHERE p.controlType.type = ?1";
		List<ControlProperty> props = this.entityManager.createQuery(query)
		.setParameter(1, controlType).getResultList();

		for (ControlProperty prop : props) {
			this.entityManager.refresh(prop);
		}

		return props;
	}

	@SuppressWarnings("unchecked")
	public List<ControlType> getAllControlTypes()
	{
		String query = "SELECT cp FROM ControlType cp";
		List<ControlType> types = this.entityManager.createQuery(query).getResultList();

		for (ControlType type : types) {
			this.entityManager.refresh(type);
		}

		return types;
	}

	@SuppressWarnings("unchecked")
	public void removeOptionsByParentId(long parentControlId) {
		String query = "SELECT c FROM Control c WHERE c.parentControl.idControl = ?1";
		List<Control> controls =  this.entityManager.createQuery(query)
			.setParameter(1, parentControlId).getResultList();
		
		for (Control c : controls) {
			removeControlDefinitions(c.getIdControl());
			removeControl(c.getIdControl());
		}
	}
	
	private void removeControl(Long controlId) {
		Session session = (Session)this.entityManager.getDelegate();
		Transaction t = session.beginTransaction();
		
		try {
			String query = "DELETE FROM Control c WHERE c.id = ?1";
			this.entityManager.createQuery(query).setParameter(1, controlId).executeUpdate();
		} catch (Exception e) {
			t.rollback();
			throw new PersistenceException(e);
		}
		
		t.commit();
	}

	private void removeControlDefinitions(long controlId) {
		Session session = (Session)this.entityManager.getDelegate();
		Transaction t = session.beginTransaction();
		
		try {
			String query = "DELETE FROM ControlDefinition cd WHERE cd.control.id = ?1";
			this.entityManager.createQuery(query).setParameter(1, controlId).executeUpdate();
		} catch (Exception e) {
			t.rollback();
			throw new PersistenceException(e);
		}
		
		t.commit();
	}
}