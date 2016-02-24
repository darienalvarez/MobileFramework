package com.gazoomobile.mfw.connector;

public class ConnectorException extends Exception
{
  private static final long serialVersionUID = -3374101785857331965L;

  public ConnectorException()
  {
  }

  public ConnectorException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ConnectorException(String message) {
    super(message);
  }

  public ConnectorException(Throwable cause) {
    super(cause);
  }
}