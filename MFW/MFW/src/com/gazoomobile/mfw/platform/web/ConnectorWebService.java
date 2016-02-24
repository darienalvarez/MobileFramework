package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import java.util.List;

public abstract interface ConnectorWebService
{
  public abstract List<ConnectorType> getAllConectorTypes();

  public abstract List<ConnectorProperty> getAllConnectorProperties(ConnectorType paramConnectorType);

  public abstract List<ConnectorProperty> getAllConnectorPropertiesByName(String paramString);
}