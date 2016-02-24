package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ConnectorTypeDao;
import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import com.gazoomobile.mfw.platform.service.ConnectorTypeService;
import java.util.List;

public class ConnectorTypeServiceImpl
  implements ConnectorTypeService
{
  private ConnectorTypeDao connectorTypeDao;

  public ConnectorType createConnectorType(ConnectorType type)
  {
    return (ConnectorType)this.connectorTypeDao.InsertOrUpdate(type);
  }

  public List<ConnectorProperty> getAllConfigurationProperties(ConnectorType type)
  {
    return this.connectorTypeDao.getAllConfigurationProperties(type.getName());
  }

  public List<ConnectorProperty> getAllConfigurationProperties(String type)
  {
    return this.connectorTypeDao.getAllConfigurationProperties(type);
  }

  public List<ConnectorType> getAllConnectorTypes()
  {
    return this.connectorTypeDao.getAll();
  }

  public ConnectorTypeDao getConnectorTypeDao() {
    return this.connectorTypeDao;
  }

  public void setConnectorTypeDao(ConnectorTypeDao connectorTypeDao) {
    this.connectorTypeDao = connectorTypeDao;
  }
}