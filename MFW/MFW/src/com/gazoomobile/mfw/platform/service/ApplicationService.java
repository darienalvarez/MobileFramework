package com.gazoomobile.mfw.platform.service;

import com.gazoomobile.mfw.platform.domain.Application;
import java.util.List;

public abstract interface ApplicationService
{
  public abstract Application createApplication(Application paramApplication);

  public abstract Application getById(Long paramLong);

  public abstract List<Application> getAllActiveApplications();
}