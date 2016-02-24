/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazoomobile.mfw.client.component;

import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.platform.client.ControlProperty;
import com.gazoomobile.mfw.platform.client.ControlWebService;
import com.gazoomobile.mfw.platform.client.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.platform.client.Control;
import com.gazoomobile.mfw.platform.client.ControlDefinition;
import com.gazoomobile.mfw.platform.client.ControlType;
import java.awt.Dimension;
import javax.swing.JScrollPane;

/**
 *
 * @author Yunisel
 */
public class MyOwnTable extends JScrollPane implements IControl {

    private MainView mainScreen;
    private List<ControlProperty> properties;
    private JTable jTable;
    private List<String> values;
    private String name;
    private ControlType controlType;
    private Control backControl;
    private String[] titles;
    private final int columnCount;
    private int rowCount;
    private int indexInContainer;

    public MyOwnTable(String name, int indexInContainer, String[] titles,  final MainView mainScreen, ControlType controlType) {
        super();
        this.mainScreen = mainScreen;
        this.indexInContainer = indexInContainer;
        this.name = name;
        this.controlType = controlType;
        this.titles = titles;
        this.columnCount = titles.length;
        this.rowCount = 1;
//        setSize(300,50);
//        setPreferredSize(new Dimension(300,50));
        setMaximumSize(new Dimension(300, 70));
        createModel(titles);
        ControlWebService control = null;
        try {
            control = new ControlWebServiceImpl(new URI(mainScreen.GAZOO_DIR + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
            Logger.getLogger(MyOwnTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        properties = control.getPropertiesByControlType(controlType.getType());
        addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
                mainScreen.RaisedAllComponentsBorders();
                requestFocus();
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyPressed(java.awt.event.KeyEvent evt) {
                OnComponentDelete(evt);
            }
        });
        createControl();
    }

    private void createModel(String[] titles) {
        final boolean[] canEdit = new boolean[columnCount];
        final Class[] types = new Class[columnCount];
        for (int i = 0; i < columnCount; i++) {
            types[i] = java.lang.String.class;
            canEdit[i] = false;
        }
        Object[][] obj = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                obj[i][j] = null;
            }
        }

        jTable = new JTable();
        jTable.setModel(new javax.swing.table.DefaultTableModel(obj, titles) {
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jTable.setColumnSelectionAllowed(true);
        jTable.getTableHeader().setReorderingAllowed(false);
        setViewportView(jTable);
        jTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable.getColumnModel().getColumn(0).setResizable(false);
        jTable.getColumnModel().getColumn(1).setResizable(false);
    }

    private void onMouseClicked(java.awt.event.MouseEvent evt) {
          mainScreen.addPropertiesToContainer(properties, values, this);
    }

    private void OnComponentDelete(java.awt.event.KeyEvent evt) {
        mainScreen.OnComponentDelete(evt);
    }
    public Control getControl() {
        return backControl;
    }

    public void modifyControlPropetieValue(int index, String value) {
       values.set(index, value);

       createControl();
    }

    private void createControl() {
        backControl = new Control();
        backControl.setControlName(name);
        backControl.setControlType(controlType);
        backControl.setIndex(indexInContainer);
        
        for (int i = 0; i < properties.size(); i++) {
            ControlDefinition definition = new ControlDefinition();
            definition.setControlProperty(properties.get(i));
            definition.setValue(values.get(i));
        }
    }

    
}

