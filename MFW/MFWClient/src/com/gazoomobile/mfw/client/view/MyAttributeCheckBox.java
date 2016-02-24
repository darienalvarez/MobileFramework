/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.view;

import javax.swing.JCheckBox;

/**
 *
 * @author dbuedo
 */
public class MyAttributeCheckBox extends JCheckBox{
    private com.gazoomobile.mfw.connector.db.Table table;

    public MyAttributeCheckBox(String text, com.gazoomobile.mfw.connector.db.Table table) {
        super(text);
        this.table = table;
    }

    public com.gazoomobile.mfw.connector.db.Table getTable() {
        return table;
    }

    public void setTable(com.gazoomobile.mfw.connector.db.Table table) {
        this.table = table;
    }


}
