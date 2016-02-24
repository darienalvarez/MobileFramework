package com.gazoomobile.mfw.platform.web.impl;

import com.gazoomobile.mfw.platform.domain.ConnectorProperty;
import com.gazoomobile.mfw.platform.domain.ConnectorType;
import com.gazoomobile.mfw.platform.service.ConnectorTypeService;
import com.gazoomobile.mfw.platform.web.ConnectorWebService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ConnectorWebServiceImpl
  implements ConnectorWebService
{
  private ConnectorTypeService connectorTypeService;

  @WebMethod
  public List<ConnectorType> getAllConectorTypes()
  {
    return this.connectorTypeService.getAllConnectorTypes();
  }

  @WebMethod
  public List<ConnectorProperty> getAllConnectorProperties(ConnectorType type) {
    return this.connectorTypeService.getAllConfigurationProperties(type);
  }

  @WebMethod
  public List<ConnectorProperty> getAllConnectorPropertiesByName(String name) {
    return this.connectorTypeService.getAllConfigurationProperties(name);
  }
  @WebMethod(exclude=true)
  public ConnectorTypeService getConnectorTypeService() {
    return this.connectorTypeService;
  }
  @WebMethod(exclude=true)
  public void setConnectorTypeService(ConnectorTypeService connectorTypeService) {
    this.connectorTypeService = connectorTypeService;
  }
}