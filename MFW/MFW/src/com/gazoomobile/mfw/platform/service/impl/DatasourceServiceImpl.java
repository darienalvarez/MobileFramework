package com.gazoomobile.mfw.platform.service.impl;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Properties;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.db.DataBaseConnector;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.Table;
import com.gazoomobile.mfw.platform.dao.DatasourceDao;
import com.gazoomobile.mfw.platform.domain.ConnectorDefinition;
import com.gazoomobile.mfw.platform.domain.Datasource;
import com.gazoomobile.mfw.platform.service.DatasourceService;
import com.gazoomobile.mfw.platform.service.MfwServiceException;
import com.gazoomobile.mfw.platform.web.impl.MyOwnHashMap;

public class DatasourceServiceImpl implements DatasourceService
{
	private DatasourceDao datasourceDao;

	public Datasource createDatasource(Datasource datasource)
	{
		return (Datasource)this.datasourceDao.InsertOrUpdate(datasource);
	}

	public DataBaseConnectorResult executeDatasource(Datasource ds)
	{
		DataBaseConnector conn = null;
		Properties prop = new Properties();
		List<ConnectorDefinition> definitions = ds.getConnector().getDefinitions();

		for (ConnectorDefinition def : definitions) {
			prop.setProperty(def.getProperty().getName(), def.getValue());
		}
		try
		{
			Class<?> clazz = Class.forName(ds.getConnector().getConnectorType().getClazz());
			Constructor<?> ctor = clazz.getConstructor(new Class[] { Properties.class });

			conn = (DataBaseConnector)ctor.newInstance(new Object[] { prop });
		} catch (Throwable e) {
			throw new MfwServiceException("Error creating the connector for the datasource '" + ds.getName() + "'");
		}

		String sql = prop.getProperty("sql");
		DataBaseConnectorResult result = null;
		try {
			result = conn.execute(sql);
		} catch (ConnectorException e) {
			throw new MfwServiceException("Error retrieving the data for the datasource '" + ds.getName() + "'");
		}

		return result;
	}

	public List<Table> getAlldbTables(String connectorType, MyOwnHashMap conf)
	{
		try
		{
			DataBaseConnector connector = 
				(DataBaseConnector)Class.forName(connectorType)
				.getConstructor(new Class[] { 
						Properties.class }).newInstance(new Object[] { conf.toProperties() });

			return connector.allTables(); } catch (Exception e) {
			}
			throw new MfwServiceException("Error retrieving the datasource information");
	}

	public List<Table> getAlldbTablesByOwner(String connectorType, MyOwnHashMap conf, String owner)
	{
		try
		{
			DataBaseConnector connector = 
				(DataBaseConnector)Class.forName(connectorType)
				.getConstructor(new Class[] { 
						Properties.class }).newInstance(new Object[] { conf.toProperties() });

			return connector.allTablesByOwner(owner); } catch (Exception e) {
			}
			throw new MfwServiceException("Error retrieving the datasource information");
	}

	public DatasourceDao getDatasourceDao()
	{
		return this.datasourceDao;
	}

	public void setDatasourceDao(DatasourceDao datasourceDao) {
		this.datasourceDao = datasourceDao;
	}
}