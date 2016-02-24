package com.gazoomobile.mfw.connector.db.postgres;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.db.Association;
import com.gazoomobile.mfw.connector.db.AssociationColumn;
import com.gazoomobile.mfw.connector.db.Column;
import com.gazoomobile.mfw.connector.db.DataBaseConnectorResult;
import com.gazoomobile.mfw.connector.db.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.postgresql.ds.PGPoolingDataSource;

public class PostgresShemaInspector
{
	private static String ALL_TABLES_SQL = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' and table_type = 'BASE TABLE'";

	private static String ALL_TABLE_COLUMNS_SQL = "select column_name, data_type, is_nullable from information_schema.columns where table_name = ?";

	private static String ALL_RELATIONS_SQL = "SELECT DISTINCT pc1.relname as ltable, pga2.attname as lcolumn, pc2.relname as rtable, pga1.attname as rcolumn FROM pg_class pc1, pg_class pc2, pg_constraint, pg_attribute pga1, pg_attribute pga2 WHERE pc1.relname = ? and pg_constraint.conrelid = pc1.oid AND pc2.relkind = 'r' AND pc2.oid = pg_constraint.confrelid AND pga1.attnum = pg_constraint.confkey[1] AND pga1.attrelid = pc2.oid AND pga2.attnum = pg_constraint.conkey[1] AND pga2.attrelid = pc1.oid";
	private PGPoolingDataSource dataSource;

	public PostgresShemaInspector(String server, String db, String user, String pass, int port)
	{
		this.dataSource = new PGPoolingDataSource();
		this.dataSource.setServerName(server);
		this.dataSource.setPortNumber(port);
		this.dataSource.setDatabaseName(db);
		this.dataSource.setUser(user);
		this.dataSource.setPassword(pass);

		this.dataSource.setDataSourceName("PG_MFW_DataSource" + System.currentTimeMillis());
		this.dataSource.setMaxConnections(10);
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

		ResultSet res = stat.executeQuery();
		while (res.next()) {
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

	public List<Association> allTableAssociations(String tableName) throws SQLException
	{
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

		String[] tableNames = (String[])names.toArray(new String[0]);
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

	protected Connection getConnection() throws SQLException
	{
		return this.dataSource.getConnection();
	}

	private List<Column> getColumnsForTable(String tableName, Connection conn) throws SQLException {
		List<Column> columns = new ArrayList<Column>();

		PreparedStatement stat = conn.prepareStatement(ALL_TABLE_COLUMNS_SQL);
		stat.setString(1, tableName);

		ResultSet res = stat.executeQuery();
		while (res.next()) {
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
		stat.setString(1, tableName);

		ResultSet result = stat.executeQuery();

		Association assoc = null;

		while (result.next()) {
			String ltable = result.getString("ltable");
			String lcolumn = result.getString("lcolumn");
			String rtable = result.getString("rtable");
			String rcolumn = result.getString("rcolumn");

			assoc = new Association(ltable, new Column(lcolumn, ""), rtable, new Column(rcolumn, ""));
			associations.add(assoc);
		}

		result.close();
		stat.close();

		return associations;
	}

	public List<Table> allTablesWithAssociationsByOwner(String owner) throws SQLException
	{
		List<Table> tables = null;

		if ((owner != null) && (!"".equals(owner))) {
			throw new SQLException("Not supported exception");
		}

		tables = allTables();

		List<Association> associations = allTablesAssociations((Table[])tables.toArray(new Table[0]));

		for (Association ass : associations) {
			String tableName = ass.getSourceTable();
			Table t = new Table(tableName, "", null);

			int index = tables.indexOf(t);
			if (index != -1) {
				t = (Table)tables.get(index);
				Column source = (Column)t.getColumns().get(t.getColumns().indexOf(ass.getSource()));

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