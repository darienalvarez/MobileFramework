/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.database;

import com.gazoomobile.mfw.connector.db.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbuedo
 */
public class Database {
    private String name;
    private List<Table> tables;

    public Database(String name, List<Table> tables) {
        this.name = name;
        this.tables = tables;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Table getTableByName(String tableSelected) {
        for (int i = 0; i < tables.size(); i++) {
            if(tables.get(i).getName().equals(tableSelected)){
                return tables.get(i);
            }
        }
        return null;
    }

    
}
