package com.gazoomobile.mfw.platform.engine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LogoutController extends AbstractController
{
  protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    request.getSession(true).removeAttribute("__mfw_user_xd");
    response.getWriter().print("OK");
    response.getWriter().flush();
    return null;
  }
}