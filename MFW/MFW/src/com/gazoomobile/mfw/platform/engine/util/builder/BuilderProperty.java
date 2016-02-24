package com.gazoomobile.mfw.platform.engine.util.builder;

public class BuilderProperty
{
  private String propertyName;
  private String propertyType;
  private String propertyValue;

  public BuilderProperty(String propertyName, String propertyType, String propertyValue)
  {
    this.propertyName = propertyName;
    this.propertyType = propertyType;
    this.propertyValue = propertyValue;
  }
  public String getPropertyName() {
    return this.propertyName;
  }
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }
  public String getPropertyType() {
    return this.propertyType;
  }
  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }
  public String getPropertyValue() {
    return this.propertyValue;
  }
  public void setPropertyValue(String propertyValue) {
    this.propertyValue = propertyValue;
  }
}