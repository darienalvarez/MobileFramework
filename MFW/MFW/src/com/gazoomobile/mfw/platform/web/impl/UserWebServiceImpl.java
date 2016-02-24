package com.gazoomobile.mfw.platform.web.impl;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.service.UserService;
import com.gazoomobile.mfw.platform.web.MfwSecutiryException;
import com.gazoomobile.mfw.platform.web.UserWebService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class UserWebServiceImpl
  implements UserWebService
{
  private UserService userService;

  @WebMethod
  public void createOrUpdateUser(User user)
  {
    this.userService.createOrUpdateUser(user);
  }

  @WebMethod
  public User login(String username, String password)
    throws MfwSecutiryException
  {
    return this.userService.login(username, password);
  }

  @WebMethod
  public void removeUser(User user) {
    this.userService.removeUser(user);
  }

  @WebMethod
  public List<Application> getAllUserApplications(User user) {
    return this.userService.getAllUserApplications(user);
  }
  @WebMethod(exclude=true)
  public UserService getUserService() {
    return this.userService;
  }
  @WebMethod(exclude=true)
  public void setUserService(UserService userService) {
    this.userService = userService;
  }
}