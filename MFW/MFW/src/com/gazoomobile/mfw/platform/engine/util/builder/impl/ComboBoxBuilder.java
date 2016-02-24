package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.Combobox;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class ComboBoxBuilder extends GenericBuilder
{
  public static final String PROP_COMBOBOX_SELECTED = "selected";

  protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
  {
    if (!(object instanceof Combobox))
      throw new RuntimeException("Expecting to fill a TCombobox and a '" + object.getClass().getName() + "' was found");
    if ((o != null) && 
      (builderProperty.getPropertyName().equalsIgnoreCase("selected")))
      ((Combobox)object).setSelected((String)o);
  }

  protected String getXmlObjectName()
  {
    return "Combobox";
  }
}