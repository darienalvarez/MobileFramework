package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import java.util.List;

public abstract interface ConnectorTypeService
{
  public abstract ConnectorType createConnectorType(ConnectorType paramConnectorType);

  public abstract List<ConnectorProperty> getAllConfigurationProperties(ConnectorType paramConnectorType);

  public abstract List<ConnectorProperty> getAllConfigurationProperties(String paramString);

  public abstract List<ConnectorType> getAllConnectorTypes();
}