package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ControlDefinitionDao;
import com.gazoomobile.mfw.platform.domain.ControlDefinition;
import com.gazoomobile.mfw.platform.service.ControlDefinitionService;

public class ControlDefinitonServiceImpl
  implements ControlDefinitionService
{
  private ControlDefinitionDao controlDefinitionDao;

  public ControlDefinition createControlDefinition(ControlDefinition definition)
  {
    return (ControlDefinition)this.controlDefinitionDao.InsertOrUpdate(definition);
  }

  public ControlDefinitionDao getControlDefinitionDao() {
    return this.controlDefinitionDao;
  }

  public void setControlDefinitionDao(ControlDefinitionDao controlDefinitionDao) {
    this.controlDefinitionDao = controlDefinitionDao;
  }
}