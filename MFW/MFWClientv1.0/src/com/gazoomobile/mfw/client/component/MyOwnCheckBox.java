/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.component;

import com.gazoomobile.mfw.client.core.ControlUIDpropertiIDAnddefinitioIDRelation;
import com.gazoomobile.mfw.client.core.ControlUidAndControlIDRelation;
import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IDataSource;
import com.gazoomobile.mfw.client.interfaces.IDataSourceComponent;
import com.gazoomobile.mfw.platform.clientapi.ControlProperty;
import com.gazoomobile.mfw.platform.clientapi.ControlWebService;
import com.gazoomobile.mfw.platform.clientapi.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.platform.clientapi.Control;
import com.gazoomobile.mfw.platform.clientapi.ControlDefinition;
import com.gazoomobile.mfw.platform.clientapi.ControlType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.FileHandler;
import javax.swing.JOptionPane;
/**
 *
 * @author Yunisel
 */
public class MyOwnCheckBox extends JCheckBox implements IControl, IDataSourceComponent{
    private MainView mainScreen;
    private static List<ControlProperty> properties;
    private List<String> values;
    private String name;
    private ControlType controlType;
    private Control backControl;
    private int indexInContainer;
    private Long controlID;
    private Long globalID;

    static {
         try {
                // Create an appending file handler
                boolean append = true;
                FileHandler handler = new FileHandler("mfw_client.log",  append);
                // Add to the desired logger
                Logger logger = Logger.getLogger(MyOwnCheckBox.class.getName());
                logger.addHandler(handler);
            } catch (IOException e) { }

        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI(MainView.SERVER_URL + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable to Connect to the server", "Connection error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MyOwnCheckBox.class.getName()).log(Level.SEVERE, ex.toString());
        }
        properties = control.getPropertiesByControlType(MainView.controlType.getType());
    }

    public MyOwnCheckBox(String name, int indexInContainer, final MainView mainScreen, ControlType controlType) {
        super();
        setText("checkbox");
        this.indexInContainer = indexInContainer;
        this.mainScreen = mainScreen;
        this.name = name;
        this.controlType = controlType;
        globalID = System.currentTimeMillis();
        MainView.controlsUidAndIdRelation.add(new ControlUidAndControlIDRelation(globalID, null));
        values = new Vector<String>();
        for (int i = 0; i < properties.size(); i++) {
            values.add("");
        }
        modifyPropertieValue("selected", "false");
        modifyPropertieValue("stringvalue", "checkbox");
        modifyPropertieValue("id", "idValue");
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
                mainScreen.RaisedAllComponentsBorders();
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OnComponentDelete(evt);
            }
        });
        createControl();
    }

    private void onMouseClicked(java.awt.event.MouseEvent evt) {
//          setSelected(!isSelected());
          for (int i = 0; i < properties.size(); i++) {
          if(properties.get(i).getName().equals("selected"))
              values.set(i, String.valueOf(isSelected()));
        }
          mainScreen.addPropertiesToContainer(properties, values, this);
    }

    private void OnComponentDelete(java.awt.event.KeyEvent evt) {
        mainScreen.OnComponentDelete(evt);
    }
public Control getControl() {
        return backControl;
    }

    public void modifyControlPropetieValue(String propertie, String value) {
      if(propertie.equals("stringvalue")){
        setText(value);
       } else if(propertie.equals("selected")){
        boolean b = Boolean.valueOf(value);
        setSelected(b);
       }
        mainScreen.addPropertiesToContainer(properties, values, this);
        createControl();
    }

    private void createControl() {
        backControl = new Control();
        backControl.setControlName(name);
        backControl.setControlType(controlType);
        backControl.setIndex(indexInContainer);
        backControl.setUid(globalID);
       
        List<ControlDefinition> controlDefinitions = new ArrayList<ControlDefinition>();
        for (int i = 0; i < properties.size(); i++) {
            ControlDefinition definition = new ControlDefinition();
            definition.setControlProperty(properties.get(i));
            definition.setValue(values.get(i));
            controlDefinitions.add(definition);
            MainView.controlsUidPropertieIdAndDefinitionRelation.add(new ControlUIDpropertiIDAnddefinitioIDRelation(globalID, properties.get(i).getIdProperty(), null)) ;
        }
        backControl.setControlDefinitions(controlDefinitions);
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

    public void addDataSource(String id, String value, boolean selected) {
        modifyControlPropetieValue("stringvalue", value);
        mainScreen.repaint();
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

