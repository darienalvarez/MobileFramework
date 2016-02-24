package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.exception.MfwRuntimeException;

public class MfwServiceException extends MfwRuntimeException
{
  private static final long serialVersionUID = -6853100933894139790L;

  public MfwServiceException()
  {
  }

  public MfwServiceException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public MfwServiceException(String message) {
    super(message);
  }

  public MfwServiceException(Throwable cause) {
    super(cause);
  }
}