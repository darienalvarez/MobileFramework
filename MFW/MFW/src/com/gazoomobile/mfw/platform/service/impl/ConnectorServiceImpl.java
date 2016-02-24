package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ConnectorDao;
import com.gazoomobile.mfw.platform.domain.Connector;
import com.gazoomobile.mfw.platform.service.ConnectorService;

public class ConnectorServiceImpl
  implements ConnectorService
{
  private ConnectorDao connectorDao;

  public Connector createConnector(Connector connector)
  {
    return (Connector)this.connectorDao.InsertOrUpdate(connector);
  }

  public ConnectorDao getConnectorDao() {
    return this.connectorDao;
  }

  public void setConnectorDao(ConnectorDao connectorDao) {
    this.connectorDao = connectorDao;
  }
}