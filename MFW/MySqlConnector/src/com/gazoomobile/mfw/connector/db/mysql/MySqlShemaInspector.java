package com.gazoomobile.mfw.connector.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.AssociationColumn;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.Table;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class MySqlShemaInspector {

	//Obtiene los nombres de las tablas de la BD activa
	private static String ALL_TABLES_SQL = "SELECT table_name FROM information_schema.tables " +
			"WHERE table_schema = ? " +
			"ORDER BY table_name";

	//Obtiene en nombre, tipo de dato y si soporta null, de las columnas de la tabla "tablename" 
	private static String ALL_TABLE_COLUMNS_SQL = "SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE " +
			"FROM INFORMATION_SCHEMA.COLUMNS " +
			"WHERE table_name = ? AND table_schema = ?";
	
	//Obtiene las relaciones de la tabla "tablename"
	private static String ALL_RELATIONS_SQL = "SELECT TABLE_NAME as ltable, COLUMN_NAME as lcolumn, REFERENCED_TABLE_NAME as rtable, REFERENCED_COLUMN_NAME as rcolumn " +
			"FROM information_schema.KEY_COLUMN_USAGE " +
			"WHERE TABLE_SCHEMA = ? " +
			"AND TABLE_NAME = ? AND REFERENCED_TABLE_NAME is not null";
	
	private String db;
	private MysqlConnectionPoolDataSource mySqlPool;
	
	public MySqlShemaInspector(String server, String db, String user,
			String pass, int port) {
		
		this.db = db;
		
		mySqlPool = new MysqlConnectionPoolDataSource();
		mySqlPool.setDatabaseName(db);
		mySqlPool.setServerName(server);
		mySqlPool.setPort(port);
		mySqlPool.setUser(user);
		mySqlPool.setPassword(pass);
		
		mySqlPool.setConnectTimeout(30000);
	}
	
	protected Connection getConnection() throws SQLException {
		return mySqlPool.getConnection();
	}
	
	
	public List<Column> allTableColumns(String tableName) throws SQLException {
		Connection conn = getConnection();
		
		List<Column> columns = getColumnsForTable(tableName, conn);
	
		conn.close();
		conn = null;
		
		return columns;
	}
	
	public List<Column> allTableColumns(Table table) throws SQLException {
		return allTableColumns(table.getName());
	}
	
	public List<Table> allTables() throws SQLException {
		List<Table> tables = new ArrayList<Table>();

		Connection conn = getConnection();
		PreparedStatement stat = conn.prepareStatement(ALL_TABLES_SQL);
		stat.setString(1, db);

		ResultSet res = stat.executeQuery();
		while(res.next()) {
			String name = res.getString("table_name");

			Table t = new Table();
			t.setName(name);
			t.setOwner("");
			t.setColumns(allTableColumns(name));

			tables.add(t);
		}
		
		res.close();
		stat.close();

		conn.close();
		conn = null;

		return tables;
	}
	
	public List<Association> allTableAssociations(Table table) throws SQLException {
		return allTableAssociations(table.getName());
	}

	
	public List<Association> allTableAssociations(String tableName) throws SQLException {
		Connection conn = getConnection();

		List<Association> associations = getAssociationsForTable(tableName, conn);
		
		conn.close();
		conn = null;
		
		return associations;
	}
	
	public List<Association> allTablesAssociations(Table[] tables) throws SQLException {
		List<String> names = new ArrayList<String>();

		for (Table table : tables) {
			names.add(table.getName());
		}

		String[] tableNames = names.toArray(new String[]{ });
		return allTablesAssociations(tableNames);
	}
	
	public List<Association> allTablesAssociations(String[] tableNames) throws SQLException {
		List<Association> associations = new ArrayList<Association>();
		
		Connection conn = getConnection();
		
		for (String table : tableNames) {
			associations.addAll(getAssociationsForTable(table, conn));
		}
		
		conn.close();
		conn = null;
		
		return associations;
	}

	private List<Column> getColumnsForTable(String tableName, Connection conn) throws SQLException {
		List<Column> columns = new ArrayList<Column>();

		PreparedStatement stat = conn.prepareStatement(ALL_TABLE_COLUMNS_SQL);
		stat.setString(1, tableName);
		stat.setString(2, db);

		ResultSet res = stat.executeQuery();
		while(res.next()) {
			String name = res.getString("column_name");
			String type = res.getString("data_type");

			Column col = new Column(name, type);
			columns.add(col);
		}
		
		res.close();
		stat.close();
		
		return columns;
	}
	
	private List<Association> getAssociationsForTable(String tableName, Connection conn) throws SQLException {
		List<Association> associations = new ArrayList<Association>();

		PreparedStatement stat = conn.prepareStatement(ALL_RELATIONS_SQL);
		stat.setString(1, db);
		stat.setString(2, tableName);

		ResultSet result = stat.executeQuery();
		
		String ltable, lcolumn, rtable, rcolumn;
		Association assoc = null;
		
		while(result.next()) {
			ltable = result.getString("ltable");
			lcolumn = result.getString("lcolumn");
			rtable = result.getString("rtable");
			rcolumn = result.getString("rcolumn");
			
			assoc = new Association(ltable, new Column(lcolumn, ""), rtable, new Column(rcolumn, ""));
			associations.add(assoc);
		}

		result.close();
		stat.close();

		return associations;
	}
	
	public List<Table> allTablesWithAssociationsByOwner(String owner)
	throws SQLException {
		List<Table> tables = null;

		if(owner != null && !"".equals(owner)) {
			throw new SQLException("Not supported exception");
		}
		else {
			tables = allTables();
		}

		List<Association> associations = allTablesAssociations(tables.toArray(new Table[] {}));

		for (Association ass : associations) {
			String tableName = ass.getSourceTable();
			Table t = new Table(tableName, "", null);

			int index = tables.indexOf(t);
			if(index != -1) {
				t = tables.get(index);
				Column source = t.getColumns().get(t.getColumns().indexOf(ass.getSource()));

				AssociationColumn newCol = new AssociationColumn();
				newCol.setColumnName(source.getColumnName());
				newCol.setColumnType(source.getColumnType());
				newCol.setAssociationTable(ass.getTargetTable());
				newCol.setAssociationColumn(ass.getTarget());

				t.getColumns().remove(source);
				t.getColumns().add(newCol);
			}
		}

		return tables;
	}
	
	public DataBaseConnectorResult getData(String query) throws SQLException, ConnectorException {
		Connection conn = getConnection();

		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet result = stat.executeQuery();
		
		DataBaseConnectorResult res = new DataBaseConnectorResult(result);
		
		result.close();
		
		stat.close();
		
		conn.close();
		conn = null;
		
		return res;
	}
}
