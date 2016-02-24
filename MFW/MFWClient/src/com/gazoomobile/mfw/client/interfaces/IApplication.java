/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.interfaces;

import com.gazoomobile.mfw.platform.client.Application;



/**
 *
 * @author dbuedo
 */
public interface IApplication {
    public void addApplication(Application application);
    public void removeApplicationByName(String name);
    public boolean searchApplicationByName(String name);
    public Application  getApplicationByName(String name);

}
