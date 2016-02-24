package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import java.util.List;

public abstract interface UserWebService
{
  public abstract void createOrUpdateUser(User paramUser);

  public abstract void removeUser(User paramUser);

  public abstract User login(String paramString1, String paramString2)
    throws MfwSecutiryException;

  public abstract List<Application> getAllUserApplications(User paramUser);
}