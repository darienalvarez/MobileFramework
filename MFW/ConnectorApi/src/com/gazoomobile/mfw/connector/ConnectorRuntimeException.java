package com.gazoomobile.mfw.connector;

public class ConnectorRuntimeException extends RuntimeException
{
  private static final long serialVersionUID = -1541547532744468217L;

  public ConnectorRuntimeException()
  {
  }

  public ConnectorRuntimeException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ConnectorRuntimeException(String message) {
    super(message);
  }

  public ConnectorRuntimeException(Throwable cause) {
    super(cause);
  }
}