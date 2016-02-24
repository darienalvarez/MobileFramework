package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.TComponent;
import com.gazoomobile.mfw.xmlbind.layout.HorizontalLayout;

public class HorizontallayoutBuilder extends GenericBuilder
{
  protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
  {
    if (!(object instanceof HorizontalLayout))
      throw new RuntimeException("Expecting to fill a THorizontallayout and a '" + object.getClass().getName() + "' was found");
  }

  protected String getXmlObjectName()
  {
    return "Horizontallayout";
  }
}