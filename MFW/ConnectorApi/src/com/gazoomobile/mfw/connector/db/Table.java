package com.gazoomobile.mfw.connector.db;

import java.util.ArrayList;
import java.util.List;

public class Table
{
  private String name;
  private String owner;
  private List<Column> columns;

  public Table()
  {
    this.columns = new ArrayList<Column>();
  }

  public Table(String name, String owner, List<Column> columns) {
    this.name = name;
    this.owner = owner;
    this.columns = columns;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwner() {
    return this.owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public List<Column> getColumns() {
    return this.columns;
  }

  public void setColumns(List<Column> columns) {
    this.columns = columns;
  }

  public Column getColumnByName(String colName) {
    for (Column column : columns ) {
      if (column.getColumnName().equals(colName)) {
        return column;
      }
    }
    return null;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Table)) {
      throw new IllegalArgumentException("Can not compare Table with no-Table object");
    }

    Table other = (Table)obj;
    return other.name.equals(this.name);
  }
}