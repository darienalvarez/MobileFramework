package com.gazoomobile.mfw.client.interfaces;

import com.gazoomobile.mfw.platform.clientapi.Control;

public interface IControl {
 public Control getControl();
 public void modifyControlPropetieValue(String propertie, String value);
 public void setControlId(Long controlID);
 public Long getGlobalID();
}
