package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import com.gazoomobile.mfw.platform.web.MfwSecutiryException;
import java.util.List;

public abstract interface UserService
{
  public abstract User createOrUpdateUser(User paramUser);

  public abstract void removeUser(User paramUser);

  public abstract User getByName(String paramString);

  public abstract User login(String paramString1, String paramString2)
    throws MfwSecutiryException;

  public abstract List<Application> getAllUserApplications(User paramUser);
}