/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.core;

import com.gazoomobile.mfw.client.component.MyOwnVerticalLayout;

/**
 *
 * @author Yunisel
 */
public class MainPanelForScreenClass {
    private String ScreenName;
    private MyOwnVerticalLayout superLayout;

    public MainPanelForScreenClass(String ScreenName, MyOwnVerticalLayout superLayout) {
        this.ScreenName = ScreenName;
        this.superLayout = superLayout;
    }

    public String getScreenName() {
        return ScreenName;
    }

    public void setScreenName(String ScreenName) {
        this.ScreenName = ScreenName;
    }

    public MyOwnVerticalLayout getSuperLayout() {
        return superLayout;
    }

    public void setSuperLayout(MyOwnVerticalLayout superLayout) {
        this.superLayout = superLayout;
    }

}
