package com.gazoomobile.mfw.platform.engine.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class AccessUtil
{
  public static String AUTH_STR = "BASIC realm=\"Basic Auth Test\"";

  public static void setAccessDenied(HttpServletResponse response) throws IOException
  {
    response.setHeader("WWW-Authenticate", AUTH_STR);
    response.sendError(401);
  }
}