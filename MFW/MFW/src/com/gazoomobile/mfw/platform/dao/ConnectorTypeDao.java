package com.gazoomobile.mfw.platform.dao;

import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import java.util.List;

public abstract interface ConnectorTypeDao extends Dao<ConnectorType, Long>
{
  public abstract List<ConnectorProperty> getAllConfigurationProperties(String paramString);
}