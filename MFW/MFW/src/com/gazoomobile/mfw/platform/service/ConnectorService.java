package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.domain.Connector;

public abstract interface ConnectorService
{
  public abstract Connector createConnector(Connector paramConnector);
}