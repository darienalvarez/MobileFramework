package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import java.util.List;

public abstract interface ControlWebService
{
  public abstract List<ControlProperty> getPropertiesByControlType(String paramString);

  public abstract List<ControlType> getAllControlTypes();
}