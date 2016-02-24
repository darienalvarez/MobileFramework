package com.gazoomobile.mfw.platform.dao.impl;

import java.util.List;

import com.gazoomobile.mfw.platform.dao.ConnectorTypeDao;
import com.gazoomobile.mfw.platform.dao.GenericDao;
import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;

public class ConnectorTypeDaoImpl extends GenericDao<ConnectorType, Long>
implements ConnectorTypeDao
{
	@SuppressWarnings("unchecked")
	public List<ConnectorProperty> getAllConfigurationProperties(String type)
	{
		String query = "SELECT p.connectorProperties FROM ConnectorType p WHERE p.name = ?1";
		List<ConnectorProperty> props = this.entityManager.createQuery(query)
		.setParameter(1, type).getResultList();

		for (ConnectorProperty prop : props) {
			this.entityManager.refresh(prop);
		}

		return props;
	}
}