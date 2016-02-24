/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.interfaces;

import com.gazoomobile.mfw.platform.client.Control;

/**
 *
 * @author Yunisel
 */
public interface IControl {
 public Control getControl();
 public void modifyControlPropetieValue(int index, String value);
}
