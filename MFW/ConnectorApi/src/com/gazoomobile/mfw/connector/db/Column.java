package com.gazoomobile.mfw.connector.db;

public class Column
{
  protected String columnName;
  protected String columnType;

  public Column()
  {
  }

  public Column(String columnName, String columnType)
  {
    this.columnName = columnName;
    this.columnType = columnType;
  }

  public String getColumnName() {
    return this.columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  public String getColumnType() {
    return this.columnType;
  }

  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Column)) {
      throw new IllegalArgumentException("Can not compare column with a no-column object");
    }

    Column other = (Column)obj;
    return other.columnName.equals(this.columnName);
  }
}