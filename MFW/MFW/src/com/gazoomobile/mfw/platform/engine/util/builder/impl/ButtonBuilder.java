package com.gazoomobile.mfw.platform.engine.util.builder.impl;


import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.xmlbind.component.Button;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class ButtonBuilder extends GenericBuilder
{
	public static final String PROP_BUTTON_BACKGROUND = "background";

	protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
	{
		if (!(object instanceof Button))
			throw new RuntimeException("Expecting to fill a TButton and a '" + object.getClass().getName() + "' was found");
		if ((o != null) && 
				(builderProperty.getPropertyName().equalsIgnoreCase("background")))
		{
			System.out.println("Ni puta idea de como poner esto");
		}
	}

	protected String getXmlObjectName()
	{
		return "Button";
	}
}