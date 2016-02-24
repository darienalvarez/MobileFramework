/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.core;

/**
 *
 * @author Yunisel
 */
public class ControlUIDpropertiIDAnddefinitioIDRelation {
    private Long controlUid;
    private Long propertieID;
    private Long definitionID;

    public ControlUIDpropertiIDAnddefinitioIDRelation(Long controlUid, Long propertieID, Long definitionID) {
        this.controlUid = controlUid;
        this.propertieID = propertieID;
        this.definitionID = definitionID;
    }

      public Long getControlUid() {
        return controlUid;
    }

    public void setControlUid(Long controlUid) {
        this.controlUid = controlUid;
    }

    public Long getDefinitionID() {
        return definitionID;
    }

    public void setDefinitionID(Long definitionID) {
        this.definitionID = definitionID;
    }

    public Long getPropertieID() {
        return propertieID;
    }

    public void setPropertieID(Long propertieID) {
        this.propertieID = propertieID;
    }
}
