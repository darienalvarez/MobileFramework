package com.gazoomobile.mfw.platform.engine.util.builder;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

import java.util.List;
import java.util.Map;

public abstract interface MXALMBuilder
{
  public abstract TComponent AddItemToContainer(Object paramObject, Control paramControl, Map<String, DataBaseConnectorResult> paramMap, List<Control> paramList);
}