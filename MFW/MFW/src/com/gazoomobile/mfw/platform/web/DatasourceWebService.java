package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.Table;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.web.impl.MyOwnHashMap;
import java.util.List;

public abstract interface DatasourceWebService
{
  public abstract DataBaseConnectorResult executeDatasource(Datasource paramDatasource);

  public abstract List<Table> getAlldbTables(String paramString, MyOwnHashMap paramMyOwnHashMap);

  public abstract List<Table> getAlldbTablesByOwner(String paramString1, MyOwnHashMap paramMyOwnHashMap, String paramString2);
}