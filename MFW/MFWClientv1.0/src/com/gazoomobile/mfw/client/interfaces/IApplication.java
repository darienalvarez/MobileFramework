package com.gazoomobile.mfw.client.interfaces;

import com.gazoomobile.mfw.platform.clientapi.Application;

public interface IApplication {
    public void addApplication(Application application);
    public void removeApplicationByName(String name);
    public boolean searchApplicationByName(String name);
    public Application  getApplicationByName(String name);

}
