package com.gazoomobile.mfw.platform.web.impl;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.Table;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.service.DatasourceService;
import com.gazoomobile.mfw.platform.web.DatasourceWebService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class DatasourceWebServiceImpl
  implements DatasourceWebService
{
  private DatasourceService datasourceService;

  @WebMethod
  public DataBaseConnectorResult executeDatasource(Datasource ds)
  {
    return this.datasourceService.executeDatasource(ds);
  }

  @WebMethod
  public List<Table> getAlldbTables(String connectorType, MyOwnHashMap conf) {
    return this.datasourceService.getAlldbTables(connectorType, conf);
  }

  @WebMethod
  public List<Table> getAlldbTablesByOwner(String connectorType, MyOwnHashMap conf, String owner)
  {
    return this.datasourceService.getAlldbTablesByOwner(connectorType, conf, owner);
  }
  @WebMethod(exclude=true)
  public DatasourceService getDatasourceService() {
    return this.datasourceService;
  }
  @WebMethod(exclude=true)
  public void setDatasourceService(DatasourceService datasourceService) {
    this.datasourceService = datasourceService;
  }
}