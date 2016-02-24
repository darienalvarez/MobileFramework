package com.gazoomobile.mfw.platform.web.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

public class MyOwnHashMap
  implements Serializable
{
  private static final long serialVersionUID = 3853168507886798082L;
  private List<MyOwnHashMapEntry> entries;

  public MyOwnHashMap()
  {
  }

  public MyOwnHashMap(List<MyOwnHashMapEntry> entries)
  {
    this.entries = entries;
  }

  public Properties toProperties() {
    Properties result = new Properties();

    for (MyOwnHashMapEntry entrie : this.entries) {
      result.setProperty(entrie.getKey(), entrie.getValue());
    }
    return result;
  }

  public List<MyOwnHashMapEntry> getEntries() {
    return this.entries;
  }

  public void setEntries(List<MyOwnHashMapEntry> entries) {
    this.entries = entries;
  }
}