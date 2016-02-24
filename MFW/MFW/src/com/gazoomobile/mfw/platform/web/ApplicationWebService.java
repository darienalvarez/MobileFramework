package com.gazoomobile.mfw.platform.web;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.web.dto.ApplicationDescriptionDto;
import java.util.List;

public abstract interface ApplicationWebService
{
  public abstract List<Application> getAllActiveApplications();

  public abstract List<ApplicationDescriptionDto> getAllActiveApplicationDescriptions();

  public abstract Application getApplicationById(Long paramLong);

  public abstract Application createOrUpdateApplication(Application paramApplication);
}