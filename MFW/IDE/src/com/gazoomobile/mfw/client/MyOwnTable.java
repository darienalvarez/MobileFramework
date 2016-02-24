/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client;

import com.gazoomobile.mfw.platform.client.ControlProperty;
import com.gazoomobile.mfw.platform.client.ControlWebService;
import com.gazoomobile.mfw.platform.client.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
/**
 *
 * @author Yunisel
 */
public class MyOwnTable extends JTable{
    private JPrincipal mainScreen;
    private List<ControlProperty> properties;

    public MyOwnTable( JPrincipal mainScreen, String controType) {
        super();
        this.mainScreen = mainScreen;
         setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
       setColumnSelectionAllowed(true);
        getTableHeader().setReorderingAllowed(false);
        //setViewportView(this);
        getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        getColumnModel().getColumn(0).setResizable(false);
        getColumnModel().getColumn(1).setResizable(false);

       // ControlType ct = new ControlType();
        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI("http://localhost:8080/MFW/services/ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
                Logger.getLogger(MyOwnTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        properties = control.getPropertiesByControlType(controType);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OnComponentDelete(evt);
            }
        });
    }

    private void onMouseClicked(java.awt.event.MouseEvent evt) {
          mainScreen.addPropertiesToContainer(properties);
    }

    private void OnComponentDelete(java.awt.event.KeyEvent evt) {
        mainScreen.OnComponentDelete(evt);
    }

}
