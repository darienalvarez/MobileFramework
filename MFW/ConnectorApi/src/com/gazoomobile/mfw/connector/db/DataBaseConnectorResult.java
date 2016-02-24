package com.gazoomobile.mfw.connector.db;

import com.gazoomobile.mfw.connector.ConnectorException;
import com.gazoomobile.mfw.connector.ConnectorRuntimeException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConnectorResult
{
  private List<String> columnNames;
  private List<List<Object>> values;
  private int rowCount;
  private int currentRow;

  public DataBaseConnectorResult()
  {
  }

  public DataBaseConnectorResult(ResultSet result)
    throws ConnectorException
  {
    this.columnNames = new ArrayList<String>();
    this.values = new ArrayList<List<Object>>();
    this.currentRow = 0;
    try
    {
      ResultSetMetaData meta = result.getMetaData();

      int count = meta.getColumnCount();
      for (int i = 1; i <= count; i++) {
        this.columnNames.add(meta.getColumnName(i));
      }

      while (result.next()) {
        List<Object> currentList = new ArrayList<Object>();

        for (String column : this.columnNames) {
          String val = result.getString(column);

          currentList.add(val);
        }

        this.currentRow += 1;
        this.values.add(currentList);
      }

      this.rowCount = this.currentRow;
      this.currentRow = -1;
    } catch (SQLException e) {
      throw new ConnectorException(e);
    }
  }

  private int getIndexByName(String columnName)
  {
    int size = this.columnNames.size();
    for (int i = 0; i < size; i++) {
      if (((String)this.columnNames.get(i)).equalsIgnoreCase(columnName)) {
        return i;
      }
    }

    return -1;
  }

  private String getInternal(int columnIndex) {
    Object val = values.get(this.currentRow).get(columnIndex);

    return val.toString();
  }

  public boolean next() {
    return this.currentRow++ < this.rowCount - 1;
  }

  public boolean hasNext() {
    return this.currentRow < this.rowCount - 1;
  }

  public void reset() {
    this.currentRow = -1;
  }

  public String getString(String columnName) {
    int col = getIndexByName(columnName);
    if (col < 0) {
      throw new ConnectorRuntimeException("Column '" + columnName + "' does not exist");
    }

    return getInternal(col);
  }

  public String getString(int columnIndex) {
    if (columnIndex < 0) {
      throw new ConnectorRuntimeException("Invalid column index");
    }

    return getInternal(columnIndex);
  }
}