package com.gazoomobile.mfw.connector.db.mysql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.ConnectorRuntimeException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.GenericDataBaseConnector;
import com.gazoomobile.mfw.connector.db.Table;

public class MySqlConnector extends GenericDataBaseConnector {

	public static final String SERVER_PROP_KEY = "server";
	public static final String DB_PROP_KEY = "db";
	public static final String USER_PROP_KEY = "user";
	public static final String PASS_PROP_KEY = "pass";
	public static final String PORT_PROP_KEY = "port";
	
	private MySqlShemaInspector inspector;
	
	
	
	public MySqlConnector(Properties conf) {
		super(conf);
		
		String server = conf.getProperty(SERVER_PROP_KEY);
		String db = conf.getProperty(DB_PROP_KEY);
		String user = conf.getProperty(USER_PROP_KEY);
		String pass = conf.getProperty(PASS_PROP_KEY);
		int port = Integer.valueOf(conf.getProperty(PORT_PROP_KEY));
		
		this.inspector = new MySqlShemaInspector(server, db, user, pass, port);
	}

	@Override
	public List<Association> allTableAssociations(Table table)
			throws ConnectorException {
		
		List<Association> result = null;
		
		try {
			result = inspector.allTableAssociations(table);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Association> allTableAssociations(String tableName)
			throws ConnectorException {
		
		List<Association> result = null;
		try {
			result = inspector.allTableAssociations(tableName);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Column> allTableColumns(Table table) throws ConnectorException {
		List<Column> result = null;
		try {
			result = inspector.allTableColumns(table);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Column> allTableColumns(String tableName)
			throws ConnectorException {
		
		List<Column> result = null;
		try {
			result = inspector.allTableColumns(tableName);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Table> allTables() throws ConnectorException {
		List<Table> result = null;
		try {
			result = inspector.allTables();
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Association> allTablesAssociations(Table[] tables)
			throws ConnectorException {
		
		List<Association> result = null;
		try {
			result = inspector.allTablesAssociations(tables);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Association> allTablesAssociations(String[] tableNames)
			throws ConnectorException {
		
		List<Association> result = null;
		try {
			result = inspector.allTablesAssociations(tableNames);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
		
		return result;
	}

	@Override
	public List<Table> allTablesByOwner(String owner) throws ConnectorException {
		
		throw new ConnectorRuntimeException("Not implemented");
	}

	@Override
	public DataBaseConnectorResult execute(String query) throws ConnectorException {
		try {
			return inspector.getData(query);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
	}
	
	public List<Table> allTablesWithAssociations() throws ConnectorException {
		return allTablesWithAssociationsByOwner(null);
	}


	public List<Table> allTablesWithAssociationsByOwner(String owner)
			throws ConnectorException {
		try {
			return inspector.allTablesWithAssociationsByOwner(owner);
		} catch (SQLException e) {
			throw new ConnectorException(e);
		}
	}


	@Override
	public List<String> getConfigurationProperties() {
		List<String> props = new ArrayList<String>();
		props.add(SERVER_PROP_KEY);
		props.add(DB_PROP_KEY);
		props.add(USER_PROP_KEY);
		props.add(PASS_PROP_KEY);
		props.add(PORT_PROP_KEY);
		
		return props;
	}

}
