package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ApplicationDao;
import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.service.ApplicationService;
import java.util.List;

public class ApplicationServiceImpl
  implements ApplicationService
{
  private ApplicationDao applicationDao;

  public Application createApplication(Application application)
  {
    return (Application)this.applicationDao.InsertOrUpdate(application);
  }

  public List<Application> getAllActiveApplications()
  {
    return this.applicationDao.getAll();
  }

  public ApplicationDao getApplicationDao() {
    return this.applicationDao;
  }

  public void setApplicationDao(ApplicationDao applicationDao) {
    this.applicationDao = applicationDao;
  }

  public Application getById(Long id)
  {
    return (Application)this.applicationDao.getById(id);
  }
}