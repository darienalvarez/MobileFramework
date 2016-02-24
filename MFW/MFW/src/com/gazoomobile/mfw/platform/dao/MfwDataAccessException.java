package com.gazoomobile.mfw.platform.dao;

import org.springframework.dao.DataAccessException;

public class MfwDataAccessException extends DataAccessException
{
  private static final long serialVersionUID = 2549324066523116715L;

  public MfwDataAccessException(String msg)
  {
    super(msg);
  }

  public MfwDataAccessException(String msg, Throwable cause) {
    super(msg, cause);
  }
}