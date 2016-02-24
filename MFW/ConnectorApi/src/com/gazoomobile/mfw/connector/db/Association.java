package com.gazoomobile.mfw.connector.db;

public class Association
{
  private String sourceTable;
  private Column source;
  private String targetTable;
  private Column target;

  public Association()
  {
  }

  public Association(String sourceTable, Column source, String targetTable, Column target)
  {
    this.sourceTable = sourceTable;
    this.source = source;
    this.targetTable = targetTable;
    this.target = target;
  }

  public String getSourceTable() {
    return this.sourceTable;
  }

  public void setSourceTable(String sourceTable) {
    this.sourceTable = sourceTable;
  }

  public Column getSource() {
    return this.source;
  }

  public void setSource(Column source) {
    this.source = source;
  }

  public String getTargetTable() {
    return this.targetTable;
  }

  public void setTargetTable(String targetTable) {
    this.targetTable = targetTable;
  }

  public Column getTarget() {
    return this.target;
  }

  public void setTarget(Column target) {
    this.target = target;
  }
}