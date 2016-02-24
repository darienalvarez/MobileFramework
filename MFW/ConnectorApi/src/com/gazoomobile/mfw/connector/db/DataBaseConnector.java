package com.gazoomobile.mfw.connector.db;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.MfwConnector;
import java.util.List;

public abstract interface DataBaseConnector extends MfwConnector
{
  public abstract List<Table> allTables()
    throws ConnectorException;

  public abstract List<Table> allTablesByOwner(String paramString)
    throws ConnectorException;

  public abstract List<Table> allTablesWithAssociationsByOwner(String paramString)
    throws ConnectorException;

  public abstract List<Table> allTablesWithAssociations()
    throws ConnectorException;

  public abstract List<Column> allTableColumns(Table paramTable)
    throws ConnectorException;

  public abstract List<Column> allTableColumns(String paramString)
    throws ConnectorException;

  public abstract List<Association> allTableAssociations(Table paramTable)
    throws ConnectorException;

  public abstract List<Association> allTableAssociations(String paramString)
    throws ConnectorException;

  public abstract List<Association> allTablesAssociations(Table[] paramArrayOfTable)
    throws ConnectorException;

  public abstract List<Association> allTablesAssociations(String[] paramArrayOfString)
    throws ConnectorException;

  public abstract DataBaseConnectorResult execute(String paramString)
    throws ConnectorException;
}