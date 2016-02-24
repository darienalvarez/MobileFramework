package com.gazoomobile.mfw.platform.engine.util.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gazoomobile.mfw.connector.ConnectorRuntimeException;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.platform.engine.util.Params;

public abstract class BuilderUtils
{
	public static final String STRING_TYPE = "STRING";
	public static final String INT_TYPE = "INT";
	public static final String INTEGER_TYPE = "INTEGER";
	public static final String LONG_TYPE = "LONG";
	public static final String BOOL_TYPE = "BOOL";
	public static final String BOOLEAN_TYPE = "BOOLEAN";

	public static boolean hasNextDBCResult(Map<String, DataBaseConnectorResult> dbcResults, String propertyValue)
	{
		if (propertyValue.startsWith(Params.PARAMS_SEPARATOR))
		{
			if (propertyValue.indexOf(Params.PARAMS_DS_SEPARATOR) < 0)
				return false;
			String datasourceName = propertyValue.substring(1, propertyValue.indexOf(":", 1));

			DataBaseConnectorResult dbcr = (DataBaseConnectorResult)dbcResults.get(datasourceName);
			return (dbcr != null) && (dbcr.hasNext());
		}

		return false;
	}

	private static Object parsetoType(String r, String type)
	{
		if ((r == null) || (r.isEmpty()))
			return null;
		if ((type.equalsIgnoreCase(BOOL_TYPE)) || (type.equalsIgnoreCase(BOOLEAN_TYPE)))
			return Boolean.valueOf(Boolean.parseBoolean(r));
		if ((type.equalsIgnoreCase(INT_TYPE)) || (type.equalsIgnoreCase(INTEGER_TYPE)))
			return Integer.valueOf(Integer.parseInt(r));
		if (type.equalsIgnoreCase(LONG_TYPE))
			return Long.valueOf(Long.parseLong(r));
		if (type.equalsIgnoreCase(STRING_TYPE))
			return r;
		System.out.println("[ERROR]  Type '" + type + "' is not supported.");
		return null;
	}

	public static Object getSinglePropertyFromDBCResult(Map<String, DataBaseConnectorResult> dbcResults, BuilderProperty builderProperty)
	{
		return getSinglePropertyFromDBCResult(dbcResults, builderProperty.getPropertyValue(), builderProperty.getPropertyType());
	}

	public static Object getSinglePropertyFromDBCResult(Map<String, DataBaseConnectorResult> dbcResults, String propertyValue, String propertyType) {
		String r = propertyValue;
		if (propertyValue.startsWith(Params.PARAMS_SEPARATOR))
		{
			if (propertyValue.indexOf(Params.PARAMS_DS_SEPARATOR) < 0) throw new RuntimeException("Invalid format for property '" + propertyValue + "'");
			String datasourceName = propertyValue.substring(1, propertyValue.indexOf(Params.PARAMS_DS_SEPARATOR, 1));
			String fieldName = propertyValue.substring(propertyValue.indexOf(Params.PARAMS_DS_TABLE_SEPARATOR, 1) + 1, propertyValue.length());
			try
			{
				DataBaseConnectorResult dbcr = (DataBaseConnectorResult)dbcResults.get(datasourceName);
				if (dbcr != null)
				{
					dbcr.reset();
					if (dbcr.next())
						r = dbcr.getString(fieldName);
					else
						r = null;
				}
				else {
					r = null;
				}
			} catch (ConnectorRuntimeException e) {
				System.out.println("Exception in Conector");
				e.printStackTrace();
				r = null;
			}
		}

		if ((r != null) && (!r.isEmpty()))
		{
			Object res = parsetoType(r, propertyType);
			if (res == null)
			{
				System.out.println("[ERROR]  Type '" + propertyType + "' is not supported.");
			}
			else {
				return res;
			}
		}
		return "";
	}

	public static List<Object> getMultiplePropertiesFromDBCResult(Map<String, DataBaseConnectorResult> dbcResults, BuilderProperty builderProperty)
	{
		return getMultiplePropertiesFromDBCResult(dbcResults, builderProperty.getPropertyValue(), builderProperty.getPropertyType());
	}

	private static List<Object> getMultiplePropertiesFromDBCResult(Map<String, DataBaseConnectorResult> dbcResults, String propertyValue, String propertyType)
	{
		List<Object> result = new ArrayList<Object>();
		String r = propertyValue;
		if (propertyValue.startsWith(Params.PARAMS_SEPARATOR))
		{
			if (propertyValue.indexOf(Params.PARAMS_DS_SEPARATOR) < 0) throw new RuntimeException("Invalid format for property '" + propertyValue + "'");
			String datasourceName = propertyValue.substring(1, propertyValue.indexOf(Params.PARAMS_DS_SEPARATOR, 1));
			String fieldName = propertyValue.substring(propertyValue.indexOf(Params.PARAMS_DS_TABLE_SEPARATOR, 1) + 1, propertyValue.length());
			try
			{
				DataBaseConnectorResult dbcr = (DataBaseConnectorResult)dbcResults.get(datasourceName);
				if (dbcr != null)
					dbcr.reset();
				while (dbcr.next()) {
					try
					{
						Object o = parsetoType(dbcr.getString(fieldName), propertyType);
						result.add(o == null ? "" : o);
					} catch (Exception e) {
						System.out.println("Exception while getting values from db");
						e.printStackTrace();
					}

				}

			}
			catch (ConnectorRuntimeException e)
			{
				System.out.println("Exception in Conector");
				e.printStackTrace();
			}
		}
		else
		{
			Object o = parsetoType(r, propertyType);
			result.add(o == null ? "" : o);
		}

		return result;
	}
}