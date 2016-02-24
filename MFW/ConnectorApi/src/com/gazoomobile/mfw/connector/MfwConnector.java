package com.gazoomobile.mfw.connector;

import java.util.List;

public abstract interface MfwConnector
{
  public abstract List<String> getConfigurationProperties();

  public abstract Object execute(String paramString)
    throws ConnectorException;
}