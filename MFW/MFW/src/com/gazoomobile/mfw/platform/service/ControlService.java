package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import java.util.List;

public interface ControlService
{
  public Control createControl(Control paramControl);

  public List<ControlProperty> getPropertiesByControlType(String paramString);

  public List<ControlType> getAllControlTypes();
  
  public void removeOldOptions(long parentControlId); 
}