package com.gazoomobile.mfw.platform.dao;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.User;
import java.util.List;

public abstract interface UserDao extends Dao<User, Long>
{
  public abstract User getUserByName(String paramString);

  public abstract List<Application> getUserApplications(User paramUser);
}