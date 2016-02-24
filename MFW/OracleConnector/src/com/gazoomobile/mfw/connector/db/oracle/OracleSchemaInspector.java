package com.gazoomobile.mfw.connector.db.oracle;

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
import javax.sql.PooledConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class OracleSchemaInspector
{
  private static final String ALL_TABLES_SQL = "SELECT * FROM all_tables";
  private static final String ALL_TABLES_BY_OWNER_SQL = "SELECT * FROM all_tables WHERE OWNER=?";
  private static final String ALL_TABLE_COLUMNS_SQL = "SELECT * FROM all_tab_columns WHERE TABLE_NAME=?";
  private static final String ALL_TABLE_CONSTRAINS_SQL = "SELECT * FROM all_constraints WHERE TABLE_NAME=? and CONSTRAINT_TYPE='R'";
  private static final String CONSTRAINS_COLUMN_SQL = "SELECT * FROM all_cons_columns WHERE CONSTRAINT_NAME=?";
  
  private OracleConnectionPoolDataSource datasource;

  public OracleSchemaInspector(String server, String sid, String user, String pass, int port)
    throws SQLException
  {
    this.datasource = new OracleConnectionPoolDataSource();
    this.datasource.setServerName(server);
    this.datasource.setServiceName(sid);
    this.datasource.setUser(user);
    this.datasource.setPassword(pass);
    this.datasource.setPortNumber(port);
    this.datasource.setDriverType("thin");
  }

  protected PooledConnection getConnection() throws SQLException {
    return this.datasource.getPooledConnection();
  }

  public List<Table> allTables() throws SQLException {
    List<Table> tables = new ArrayList<Table>();

    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();
    PreparedStatement stat = conn.prepareStatement(ALL_TABLES_SQL);

    ResultSet res = stat.executeQuery();
    while (res.next()) {
      String name = res.getString("TABLE_NAME");
      String owner = res.getString("OWNER");

      Table t = new Table();
      t.setName(name);
      t.setOwner(owner);
      t.setColumns(allTableColumns(name));

      tables.add(t);
    }

    res.close();
    stat.close();

    conn.close();
    conn = null;

    pool.close();
    pool = null;
    return tables;
  }

  public List<Table> allTablesByOwner(String owner) throws SQLException {
    List<Table> tables = new ArrayList<Table>();

    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();
    PreparedStatement stat = conn.prepareStatement(ALL_TABLES_BY_OWNER_SQL);
    stat.setString(1, owner);

    ResultSet res = stat.executeQuery();
    while (res.next()) {
      String name = res.getString("TABLE_NAME");

      Table t = new Table();
      t.setName(name);
      t.setOwner(owner);
      t.setColumns(getColumnsForTable(name, conn));

      tables.add(t);
    }

    res.close();
    stat.close();

    conn.close();
    conn = null;

    pool.close();
    pool = null;

    return tables;
  }

  public List<Table> allTablesWithAssociationsByOwner(String owner) throws SQLException {
    return getTableWithAssociations(owner);
  }

  public List<Table> allTablesWithAssociations() throws SQLException {
    return getTableWithAssociations(null);
  }

  public List<Column> allTableColumns(Table table) throws SQLException {
    return allTableColumns(table.getName());
  }

  public List<Column> allTableColumns(String tableName) throws SQLException {
    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();

    List<Column> columns = getColumnsForTable(tableName, conn);

    return columns;
  }

  public List<Association> allTableAssociations(Table table) throws SQLException {
    return allTableAssociations(table.getName());
  }

  public List<Association> allTableAssociations(String tableName) throws SQLException {
    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();

    List<Association> associations = getAssociationsForTable(tableName, conn);

    conn.close();
    conn = null;

    pool.close();
    pool = null;

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

    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();

    for (String table : tableNames) {
      associations.addAll(getAssociationsForTable(table, conn));
    }

    conn.close();
    conn = null;

    pool.close();
    pool = null;

    return associations;
  }

  public DataBaseConnectorResult getData(String query) throws SQLException, ConnectorException {
    PooledConnection pool = getConnection();
    Connection conn = pool.getConnection();

    PreparedStatement stat = conn.prepareStatement(query);
    ResultSet result = stat.executeQuery();

    DataBaseConnectorResult res = new DataBaseConnectorResult(result);

    result.close();

    stat.close();

    conn.close();
    conn = null;

    pool.close();
    pool = null;

    return res;
  }

  private List<Association> getAssociationsForTable(String tableName, Connection conn) throws SQLException {
    List<Association> associations = new ArrayList<Association>();

    PreparedStatement stat = conn.prepareStatement(ALL_TABLE_CONSTRAINS_SQL);
    stat.setString(1, tableName);

    ResultSet res = stat.executeQuery();
    while (res.next()) {
      String sourceConstName = res.getString("CONSTRAINT_NAME");
      String targetConstName = res.getString("R_CONSTRAINT_NAME");

      Association assoc = new Association();

      PreparedStatement source = conn.prepareStatement(CONSTRAINS_COLUMN_SQL);
      source.setString(1, sourceConstName);

      ResultSet result = source.executeQuery();
      while (result.next()) {
        String colId = result.getString("COLUMN_NAME");
        String table = result.getString("TABLE_NAME");

        Column col = new Column(colId, "");
        assoc.setSource(col);
        assoc.setSourceTable(table);
      }

      result.close();
      source.close();

      PreparedStatement target = conn.prepareStatement("SELECT * FROM all_cons_columns WHERE CONSTRAINT_NAME=?");
      target.setString(1, targetConstName);

      result = target.executeQuery();
      while (result.next()) {
        String colId = result.getString("COLUMN_NAME");
        String table = result.getString("TABLE_NAME");

        Column col = new Column(colId, "");
        assoc.setTarget(col);
        assoc.setTargetTable(table);
      }

      result.close();
      target.close();

      associations.add(assoc);
    }
    return associations;
  }

  private List<Column> getColumnsForTable(String tableName, Connection conn) throws SQLException {
    List<Column> columns = new ArrayList<Column>();

    PreparedStatement stat = conn.prepareStatement(ALL_TABLE_COLUMNS_SQL);
    stat.setString(1, tableName);

    ResultSet res = stat.executeQuery();
    while (res.next()) {
      String name = res.getString("COLUMN_NAME");
      String type = res.getString("DATA_TYPE");

      Column col = new Column(name, type);
      columns.add(col);
    }

    res.close();
    stat.close();

    return columns;
  }

  private List<Table> getTableWithAssociations(String owner) throws SQLException {
    List<Table> tables = null;

    if ((owner != null) && (!"".equals(owner))) {
      tables = allTablesByOwner(owner);
    }
    else {
      tables = allTables();
    }

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
}