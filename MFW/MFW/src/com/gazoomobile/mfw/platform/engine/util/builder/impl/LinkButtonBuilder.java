package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.Linkbutton;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class LinkButtonBuilder extends GenericBuilder
{
  public static final String PROP_LINKBUTTON_REF = "ref";

  protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
  {
    if (!(object instanceof Linkbutton))
      throw new RuntimeException("Expecting to fill a TextBox and a '" + object.getClass().getName() + "' was found");
    if ((o != null) && 
      (builderProperty.getPropertyName().equalsIgnoreCase("ref")))
      ((Linkbutton)object).setRef((String)o);
  }

  protected String getXmlObjectName()
  {
    return "Linkbutton";
  }
}