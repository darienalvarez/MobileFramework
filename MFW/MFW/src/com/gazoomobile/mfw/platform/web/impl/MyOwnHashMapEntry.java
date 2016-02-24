package com.gazoomobile.mfw.platform.web.impl;

import java.io.Serializable;

public class MyOwnHashMapEntry
  implements Serializable
{
  private static final long serialVersionUID = 5291464631668771816L;
  private String key;
  private String value;

  public MyOwnHashMapEntry()
  {
  }

  public MyOwnHashMapEntry(String key, String value)
  {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}