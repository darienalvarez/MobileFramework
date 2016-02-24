package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.platform.engine.util.builder.BuilderUtils;
import com.gazoomobile.mfw.xmlbind.component.Option;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class OptionBuilder extends GenericBuilder
{
	public static final String PROP_OPTION_VALUE = "value";

	public TComponent AddItemToContainer(Object container, Control control, Map<String, DataBaseConnectorResult> dbcResults, List<Control> possibleChilds)
	{
		List<BuilderProperty> properties = getBuilderProperties(control);
		List<Option> options = new ArrayList<Option>();
		for (BuilderProperty builderProperty : properties)
		{
			List<Object> propertyValues = BuilderUtils.getMultiplePropertiesFromDBCResult(dbcResults, builderProperty);
			int i = 0;
			for (Iterator<Object> localIterator2 = propertyValues.iterator(); localIterator2.hasNext(); ) { Object propValue = localIterator2.next();
			Option op;
			if (i >= options.size())
			{
				op = addNewOption(container);
				options.add(op);
			}
			else {
				op = (Option)options.get(i);
			}
			fillItem(op, propValue, builderProperty);
			i++;
			}
		}
		return options.isEmpty() ? null : (TComponent)options.get(0);
	}

	private Option addNewOption(Object container)
	{
		String xmlObjectName = getXmlObjectName();
		try {
			Method m = container.getClass().getMethod("new" + xmlObjectName, new Class[0]);
			Object t = m.invoke(container, new Object[]{ });
			if (!(t instanceof Option))
			{
				System.out.println("The object returned by 'new" + xmlObjectName + "' for class: " + container.getClass().getName() + " is NOT an XMLOBJECT");
				return null;
			}

			return (Option)t;
		} catch (Exception e) {
			System.out.println("Problems executing 'addNew" + xmlObjectName + "' in class: " + container.getClass().getName());
			e.printStackTrace();
		}return null;
	}

	protected void fillItem(TComponent object, Object o, BuilderProperty builderProperty)
	{
		if (!(object instanceof Option))
			throw new RuntimeException("Expecting to fill a TOption and a '" + object.getClass().getName() + "' was found");
		if (o != null)
		{
			if (builderProperty.getPropertyName().equalsIgnoreCase("value"))
				((Option)object).setValue((String)o);
			else if (builderProperty.getPropertyName().equalsIgnoreCase("stringvalue"))
				((Option)object).setTextValue((String)o);
		}
	}

	protected String getXmlObjectName() {
		return "Option";
	}
}