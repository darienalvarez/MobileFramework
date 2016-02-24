/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.core;

/**
 *
 * @author Yunisel
 */
public class ControlUidAndControlIDRelation {
    private Long controlUid;
    private Long controlID;

     public ControlUidAndControlIDRelation(Long controlUid, Long controlID) {
        this.controlUid = controlUid;
        this.controlID = controlID;
    }

      public Long getControlID() {
        return controlID;
    }

    public void setControlID(Long controlID) {
        this.controlID = controlID;
    }

    public Long getControlUid() {
        return controlUid;
    }

    public void setControlUid(Long controlUid) {
        this.controlUid = controlUid;
    }
}
