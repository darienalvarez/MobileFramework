package com.gazoomobile.mfw.platform.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface Dao<T extends Serializable, K extends Serializable>
{
  public abstract List<T> getAll();

  public abstract T getById(K paramK);

  public abstract T InsertOrUpdate(T paramT);

  public abstract void Delete(T paramT);
}