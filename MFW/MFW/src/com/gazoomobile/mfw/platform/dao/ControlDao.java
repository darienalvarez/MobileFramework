package com.gazoomobile.mfw.platform.dao;

import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.domain.ControlType;
import java.util.List;

public interface ControlDao extends Dao<Control, Long>
{
  public List<ControlProperty> getControlProperties(String paramString);

  public List<ControlType> getAllControlTypes();
  
  public void removeOptionsByParentId(long parentControlId);
}