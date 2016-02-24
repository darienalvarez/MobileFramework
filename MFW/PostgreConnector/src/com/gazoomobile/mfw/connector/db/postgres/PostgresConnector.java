package com.gazoomobile.mfw.connector.db.postgres;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.ConnectorRuntimeException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.GenericDataBaseConnector;
import com.gazoomobile.mfw.connector.db.Table;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PostgresConnector extends GenericDataBaseConnector
{
	public static final String SERVER_PROP_KEY = "server";
	public static final String DB_PROP_KEY = "db";
	public static final String USER_PROP_KEY = "user";
	public static final String PASS_PROP_KEY = "pass";
	public static final String PORT_PROP_KEY = "port";

	private PostgresShemaInspector inspector;

	public PostgresConnector(Properties conf)
	{
		super(conf);

		String server = conf.getProperty(SERVER_PROP_KEY);
		String db = conf.getProperty(DB_PROP_KEY);
		String user = conf.getProperty(USER_PROP_KEY);
		String pass = conf.getProperty(PASS_PROP_KEY);
		int port = Integer.valueOf(conf.getProperty(PORT_PROP_KEY)).intValue();

		this.inspector = new PostgresShemaInspector(server, db, user, pass, port);
	}

	public List<Association> allTableAssociations(Table table)
		throws ConnectorException
	{
		List<Association> result = null;
		try
		{
			result = this.inspector.allTableAssociations(table);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Association> allTableAssociations(String tableName)
		throws ConnectorException
	{
		List<Association> result = null;
		try {
			result = this.inspector.allTableAssociations(tableName);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Column> allTableColumns(Table table) throws ConnectorException
	{
		List<Column> result = null;
		try {
			result = this.inspector.allTableColumns(table);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Column> allTableColumns(String tableName)
	throws ConnectorException
	{
		List<Column> result = null;
		try {
			result = this.inspector.allTableColumns(tableName);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Table> allTables() throws ConnectorException
	{
		List<Table> result = null;
		try {
			result = this.inspector.allTables();
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Association> allTablesAssociations(Table[] tables)
	throws ConnectorException
	{
		List<Association> result = null;
		try {
			result = this.inspector.allTablesAssociations(tables);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Association> allTablesAssociations(String[] tableNames)
	throws ConnectorException
	{
		List<Association> result = null;
		try {
			result = this.inspector.allTablesAssociations(tableNames);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}

		return result;
	}

	public List<Table> allTablesByOwner(String owner)
	throws ConnectorException
	{
		throw new ConnectorRuntimeException("Not implemented");
	}

	public DataBaseConnectorResult execute(String query) throws ConnectorException
	{
		try {
			return this.inspector.getData(query); 
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
	}

	public List<String> getConfigurationProperties()
	{
		List<String> props = new ArrayList<String>();
		props.add(SERVER_PROP_KEY);
		props.add(DB_PROP_KEY);
		props.add(USER_PROP_KEY);
		props.add(PASS_PROP_KEY);
		props.add(PORT_PROP_KEY);

		return props;
	}

	public List<Table> allTablesWithAssociations() throws ConnectorException
	{
		return allTablesWithAssociationsByOwner(null);
	}

	public List<Table> allTablesWithAssociationsByOwner(String owner) throws ConnectorException
	{
		try
		{
			return this.inspector.allTablesWithAssociationsByOwner(owner); 
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
	}
}