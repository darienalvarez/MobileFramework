/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.view;

import com.gazoomobile.mfw.platform.clientapi.Table;
import javax.swing.JCheckBox;

/**
 *
 * @author dbuedo
 */
public class MyAttributeCheckBox extends JCheckBox{
    private Table table;

    public MyAttributeCheckBox(String text, Table table) {
        super(text);
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }


}
