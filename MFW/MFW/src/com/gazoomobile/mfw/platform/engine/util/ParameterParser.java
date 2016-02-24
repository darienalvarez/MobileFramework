package com.gazoomobile.mfw.platform.engine.util;

import javax.servlet.http.HttpServletRequest;

public abstract class ParameterParser
{
  public static int getSafeInt(HttpServletRequest request, String paramName, int defaultValue, int minValue, int maxValue)
  {
    int result = defaultValue;
    try
    {
      result = Integer.parseInt(request.getParameter(paramName));
    }
    catch (NumberFormatException localNumberFormatException) {
    }
    return (result >= minValue) && (result <= maxValue) ? result : defaultValue;
  }

  public static long getSafeLong(HttpServletRequest request, String paramName, long defaultValue, long minValue, long maxValue)
  {
    long result = defaultValue;
    try
    {
      result = Long.parseLong(request.getParameter(paramName));
    }
    catch (NumberFormatException localNumberFormatException) {
    }
    return (result >= minValue) && (result <= maxValue) ? result : defaultValue;
  }

  public static long getSafeLong(HttpServletRequest request, String paramName, long defaultValue)
  {
    long result = defaultValue;
    try
    {
      result = Long.parseLong(request.getParameter(paramName));
    }
    catch (NumberFormatException localNumberFormatException) {
    }
    return result;
  }
}