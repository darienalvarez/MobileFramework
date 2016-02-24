package com.gazoomobile.mfw.platform.engine.util.builder.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.platform.domain.Control;
import com.gazoomobile.mfw.platform.domain.ControlDefinition;
import com.gazoomobile.mfw.platform.engine.util.builder.BuilderProperty;
import com.gazoomobile.mfw.platform.engine.util.builder.BuilderUtils;
import com.gazoomobile.mfw.platform.engine.util.builder.MXALMBuilder;
import com.gazoomobile.mfw.xmlbind.component.TComponent;

public abstract class GenericBuilder
implements MXALMBuilder
{
	public static final String PROP_STRING_VALUE = "stringvalue";
	public static final String PROP_ID = "id";

	public TComponent AddItemToContainer(Object container, Control control, Map<String, DataBaseConnectorResult> dbcResults, List<Control> possibleChilds)
	{
		List<BuilderProperty> properties = getBuilderProperties(control);

		TComponent object = null;
		String xmlObjectName = getXmlObjectName();
		Object t;
		try
		{
			Method m = container.getClass().getMethod("new" + xmlObjectName, new Class[0]);
			t = m.invoke(container, new Object[]{ });
			if (!(t instanceof TComponent))
			{
				System.out.println("The object returned by 'new" + xmlObjectName + "' for class: " + container.getClass().getName() + " is NOT an XMLOBJECT");
				return null;
			}

			object = (TComponent)t;
		} catch (Exception e) {
			System.out.println("Problems executing 'addNew" + xmlObjectName + "' in class: " + container.getClass().getName());
			e.printStackTrace();
			return null;
		}

		for (BuilderProperty builderProperty : properties) {
			Object value = BuilderUtils.getSinglePropertyFromDBCResult(dbcResults, builderProperty);
			if (value == null)
				continue;
			if ("stringvalue".equalsIgnoreCase(builderProperty.getPropertyName()))
			{
				try
				{
					Method m = object.getClass().getMethod("setTextValue", new Class[] { String.class });
					m.invoke(object, new Object[] { (String)value }); 
				} catch (Exception e) {
					System.out.println("Invalid use of 'textValue' property name");
				}
			}
			else if ("id".equalsIgnoreCase(builderProperty.getPropertyName()))
				try
				{
					Method m = object.getClass().getMethod("setId", new Class[] { String.class });
					m.invoke(object, new Object[] { (String)value }); 
				} catch (Exception e) {
						System.out.println("Invalid use of 'id' property name");
				}
			else {
				fillItem(object, value, builderProperty);
			}

		}

		return object;
	}
	protected abstract void fillItem(TComponent paramXmlObject, Object paramObject, BuilderProperty paramBuilderProperty);

	protected abstract String getXmlObjectName();

	protected List<BuilderProperty> getBuilderProperties(Control control) {
		List<ControlDefinition> definitions = control.getControlDefinitions();
		List<BuilderProperty> builderProperties = new ArrayList<BuilderProperty>(definitions.size());

		if ((definitions != null) && (!definitions.isEmpty())) {
			for (ControlDefinition controlDefinition : definitions) {
				String propertyName = controlDefinition.getControlProperty().getName();
				String propertyValue = controlDefinition.getValue();
				String propertyType = controlDefinition.getControlProperty().getPropertyType().getType();
				builderProperties.add(new BuilderProperty(propertyName, propertyType, propertyValue));
			}
		}
		return builderProperties;
	}
}