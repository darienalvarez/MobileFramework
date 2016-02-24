package com.gazoomobile.mfw.platform.clientapi;

public class AssociationColumn extends Column
{
  private String associationTable;
  private Column associationColumn;

  public AssociationColumn()
  {
  }

  public AssociationColumn(String columnName, String columnType, String associationTable, Column associationColumn)
  {
    super(columnName, columnType);

    this.associationTable = associationTable;
    this.associationColumn = associationColumn;
  }

  public String getAssociationTable() {
    return this.associationTable;
  }

  public void setAssociationTable(String associationTable) {
    this.associationTable = associationTable;
  }

  public Column getAssociationColumn() {
    return this.associationColumn;
  }

  public void setAssociationColumn(Column associationColumn) {
    this.associationColumn = associationColumn;
  }
}