package com.gazoomobile.mfw.platform.web.impl;

import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import com.gazoomobile.mfw.platform.service.ControlService;
import com.gazoomobile.mfw.platform.web.ControlWebService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ControlWebServiceImpl
  implements ControlWebService
{
  private ControlService controlService;

  @WebMethod
  public List<ControlProperty> getPropertiesByControlType(String controlType)
  {
    return this.controlService.getPropertiesByControlType(controlType);
  }

  @WebMethod
  public List<ControlType> getAllControlTypes() {
    return this.controlService.getAllControlTypes();
  }
  @WebMethod(exclude=true)
  public ControlService getControlService() {
    return this.controlService;
  }
  @WebMethod(exclude=true)
  public void setControlService(ControlService controlService) {
    this.controlService = controlService;
  }
}