package com.gazoomobile.mfw.connector.db;

import java.util.Properties;

public abstract class GenericDataBaseConnector
  implements DataBaseConnector
{
  protected Properties conf;

  public GenericDataBaseConnector()
  {
  }

  public GenericDataBaseConnector(Properties conf)
  {
    this.conf = conf;
  }
}