/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazoomobile.mfw.client.component;

import com.gazoomobile.mfw.client.core.ControlUidAndControlIDRelation;
import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IDataSourceComponent;
import com.gazoomobile.mfw.platform.clientapi.ControlProperty;
import com.gazoomobile.mfw.platform.clientapi.ControlWebService;
import com.gazoomobile.mfw.platform.clientapi.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.platform.clientapi.Control;
import com.gazoomobile.mfw.platform.clientapi.ControlDefinition;
import com.gazoomobile.mfw.platform.clientapi.ControlType;
import java.awt.Dimension;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.FileHandler;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class MyOwnTable extends JScrollPane implements IControl, IDataSourceComponent {

    private MainView mainScreen;
    private static List<ControlProperty> properties;
    private JTable jTable;
    private List<String> values;
    private String name;
    private ControlType controlType;
    private Control backControl;
    private String[] titles;
    private int columnCount;
    private int rowCount;
    private int indexInContainer;
    private List<String> dataSourceForColumnt;
    private Long controlID;
    private Long globalID;

     static {
        try {
             // Create an appending file handler
             boolean append = true;
             FileHandler handler = new FileHandler("mfw_client.log", append);
             // Add to the desired logger
             Logger logger = Logger.getLogger(MyOwnTable.class.getName());
             logger.addHandler(handler);
         } catch (IOException e) {
         }

        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI(MainView.SERVER_URL + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable to Connect to the server", "Connection error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MyOwnCheckBox.class.getName()).log(Level.SEVERE, ex.toString());
        }
        properties = control.getPropertiesByControlType(MainView.controlType.getType());
    }

    public MyOwnTable(String name, int indexInContainer,/* String[] titles, */int columnCount, final MainView mainScreen, ControlType controlType) {
        super();
        this.mainScreen = mainScreen;
        this.indexInContainer = indexInContainer;
        this.name = name;
        this.controlType = controlType;
        this.columnCount = columnCount;
        this.rowCount = 3;
        globalID = System.currentTimeMillis();
        dataSourceForColumnt = new Vector<String>();
        MainView.controlsUidAndIdRelation.add(new ControlUidAndControlIDRelation(globalID, null));
        for (int i = 0; i < columnCount; i++) {
            dataSourceForColumnt.add("");
        }

        setMaximumSize(new Dimension(300, 70));
        createModel();
//        ControlWebService control = null;
//        try {
//            control = new ControlWebServiceImpl(new URI(mainScreen.GAZOO_DIR + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
//        } catch (Exception ex) {
//            Logger.getLogger(MyOwnTable.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        properties = control.getPropertiesByControlType(controlType.getType());
        values = new Vector<String>();
        for (int i = 0; i < properties.size(); i++) {
            values.add("");
        }
        modifyPropertieValue("id", "idvalue");
        modifyPropertieValue("stringvalue", "stringvalue");
        ControlProperty cpColumnCouunt =new ControlProperty();
        cpColumnCouunt.setName("columncount");
        properties.add(cpColumnCouunt);
        values.add("");
        modifyControlPropetieValue("columncount", String.valueOf(columnCount));
//        modifyPropertieValue("id", "idValue");
        
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

    private void createModel() {
       titles = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            titles[i]="";
        }
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

    public void modifyControlPropetieValue(String propertie, String value) {
        if(propertie.equals("columncount")){
            columnCount = Integer.parseInt(value);
            dataSourceForColumnt = new Vector<String>();
            for (int i = 0; i < columnCount; i++) {
                dataSourceForColumnt.add("");
            }
            createModel();
       }
        modifyPropertieValue(propertie, value);
        mainScreen.addPropertiesToContainer(properties, values, this);
        createControl();
    }

    public void setColumnDataSourceByColumnIndex(int columnIndex, String datasource){
        dataSourceForColumnt.set(columnIndex, datasource);
    }

    private void createControl() {
        backControl = new Control();
        backControl.setControlName(name);
        backControl.setControlType(controlType);
        backControl.setIndex(indexInContainer);
        backControl.setUid(globalID);
        for (int i = 0; i < properties.size()-1; i++) {
            ControlDefinition definition = new ControlDefinition();
            definition.setControlProperty(properties.get(i));
            definition.setValue(values.get(i));
        }
    }

    public void addDataSource(String id, String value, boolean selected) {
        
    }

    private void modifyPropertieValue(String propertie, String value){
         for (int i = 0; i < properties.size(); i++) {
          if(properties.get(i).getName().equals(propertie))
              values.set(i, value);
        }
    }

    public List<ControlProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ControlProperty> properties) {
        this.properties = properties;
    }

    public void clearDataSource() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setControlId(Long controlID) {
        this.controlID = controlID;
    }

    public Long getGlobalID() {
        return globalID;
    }
}

