package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class FormBuilder extends GenericBuilder
{
  public static final String PROP_FORM_ACTION = "action";

  protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
  {
  }

  protected String getXmlObjectName()
  {
    return "Form";
  }
}