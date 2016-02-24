package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ControlPropertyDao;
import com.gazoomobile.mfw.platform.domain.ControlProperty;
import com.gazoomobile.mfw.platform.service.ControlPropertyService;

public class ControlPropertyServiceImpl
  implements ControlPropertyService
{
  private ControlPropertyDao controlPropertyDao;

  public ControlProperty createControlProperty(ControlProperty controlProperty)
  {
    return (ControlProperty)this.controlPropertyDao.InsertOrUpdate(controlProperty);
  }

  public ControlPropertyDao getControlPropertyDao() {
    return this.controlPropertyDao;
  }

  public void setControlPropertyDao(ControlPropertyDao controlPropertyDao) {
    this.controlPropertyDao = controlPropertyDao;
  }
}