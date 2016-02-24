package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.platform.exception.MfwException;

public class MfwSecutiryException extends MfwException
{
  private static final long serialVersionUID = -213841103612844665L;

  public MfwSecutiryException()
  {
  }

  public MfwSecutiryException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public MfwSecutiryException(String message) {
    super(message);
  }

  public MfwSecutiryException(Throwable cause) {
    super(cause);
  }
}