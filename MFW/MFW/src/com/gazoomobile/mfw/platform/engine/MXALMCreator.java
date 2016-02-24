package com.gazoomobile.mfw.platform.engine;

import com.gazoomobile.mfw.platform.domain.Application;
import com.gazoomobile.mfw.platform.domain.Screen;
import java.util.List;

public abstract interface MXALMCreator
{
  public abstract String getXmlForScreen(Screen paramScreen);

  public abstract String getApplicationsList(List<Application> paramList);
}