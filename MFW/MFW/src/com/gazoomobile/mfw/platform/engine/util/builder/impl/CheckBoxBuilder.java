package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.Checkbox;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class CheckBoxBuilder extends GenericBuilder
{
  public static final String PROP_CHECKBOX_SELECTED = "selected";

  protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
  {
    if (!(object instanceof Checkbox))
      throw new RuntimeException("Expecting to fill a TCheckbox and a '" + object.getClass().getName() + "' was found");
    if ((o != null) && 
      (builderProperty.getPropertyName().equalsIgnoreCase("selected")))
      ((Checkbox)object).setSelected((String)o);
  }

  protected String getXmlObjectName()
  {
    return "Checkbox";
  }
}