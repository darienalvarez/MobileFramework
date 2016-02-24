package com.gazoomobile.mfw.platform.service.impl;

import com.gazoomobile.mfw.platform.dao.ScreenDao;
import com.gazoomobile.mfw.platform.domain.Screen;
import com.gazoomobile.mfw.platform.service.ScreenService;

public class ScreenServiceImpl
  implements ScreenService
{
  private ScreenDao screenDao;

  public Screen createScreen(Screen screen)
  {
    return (Screen)this.screenDao.InsertOrUpdate(screen);
  }

  public ScreenDao getScreenDao() {
    return this.screenDao;
  }

  public void setScreenDao(ScreenDao screenDao) {
    this.screenDao = screenDao;
  }
}