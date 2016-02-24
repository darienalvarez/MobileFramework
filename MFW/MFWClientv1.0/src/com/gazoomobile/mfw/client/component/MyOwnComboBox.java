/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client.component;

import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IDataSourceComponent;
import com.gazoomobile.mfw.client.interfaces.IOptionControl;
import com.gazoomobile.mfw.platform.clientapi.ControlProperty;
import com.gazoomobile.mfw.platform.clientapi.ControlWebService;
import com.gazoomobile.mfw.platform.clientapi.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.client.component.Option;
import com.gazoomobile.mfw.client.core.ControlUIDpropertiIDAnddefinitioIDRelation;
import com.gazoomobile.mfw.client.core.ControlUidAndControlIDRelation;
import com.gazoomobile.mfw.platform.clientapi.Control;
import com.gazoomobile.mfw.platform.clientapi.ControlDefinition;
import com.gazoomobile.mfw.platform.clientapi.ControlType;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.FileHandler;
import javax.swing.JOptionPane;

public class MyOwnComboBox extends JComboBox implements IControl, IOptionControl, IDataSourceComponent {
    private MainView mainScreen;
    private static  List<ControlProperty> properties;
    private List<String> values;
    private List<Option> options;
    private String name;
    private ControlType controlType;
    private ControlType optionControlType;
    private Control backControl;
    private int indexInContainer;
    private List<Control> optionControls;
    private Long controlID;
    private Long globalID;

     static {
         try {
             // Create an appending file handler
             boolean append = true;
             FileHandler handler = new FileHandler("mfw_client.log", append);
             // Add to the desired logger
             Logger logger = Logger.getLogger(MyOwnComboBox.class.getName());
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

    public MyOwnComboBox(String name, int indexInContainer, final MainView mainScreen, ControlType controlType) {
        super();
        this.indexInContainer = indexInContainer;
        this.mainScreen = mainScreen;
        this.name = name;
        this.controlType = controlType;
        options = new ArrayList<Option>();
        optionControls = new ArrayList<Control>();
        setMaximumSize(new Dimension(100,20));
        globalID = System.currentTimeMillis();
        MainView.controlsUidAndIdRelation.add(new ControlUidAndControlIDRelation(globalID, null));
//        ControlWebService control = null;
//        try {
//          control = new ControlWebServiceImpl(new URI(mainScreen.GAZOO_DIR + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
//        } catch (Exception ex) {
//                Logger.getLogger(MyOwnComboBox.class.getName()).log(Level.SEVERE, null, ex);
//        }
        List<ControlType> controlTypes = mainScreen.getAllControlTypes();
        for (int i = 0; i < controlTypes.size(); i++) {
            if (controlTypes.get(i).getType().equals("option")) {
                optionControlType = controlTypes.get(i);
            }
        }

//        properties = control.getPropertiesByControlType(controlType.getType());
        values = new Vector<String>();
        for (int i = 0; i < properties.size(); i++) {
            values.add("");
        }
        modifyPropertieValue("selected", "0");
        modifyPropertieValue("stringvalue", "stringvalue");
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
          mainScreen.addPropertiesToContainer(properties, values, this);
    }

    private void OnComponentDelete(java.awt.event.KeyEvent evt) {
        mainScreen.OnComponentDelete(evt);
    }

    public Control getControl() {
        return backControl;
    }

    public void modifyControlPropetieValue(String propertie, String value) {
       modifyPropertieValue(propertie, value);
       mainScreen.addPropertiesToContainer(properties, values, this);
       createControl();
    }

  private void createControl() {
        optionControls = new ArrayList<Control>();
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

        if (options.size() != 0) {
            for (int i = 0; i < options.size(); i++) {
                Control optionControl = new Control();
                optionControl.setParentControl(backControl);
                optionControl.setControlType(optionControlType);
                optionControl.setControlName("Option"+i);
                optionControl.setIndex(i);

                List<ControlProperty> optionProperties = options.get(i).getProperties();
                List<String> optionValues = options.get(i).getValues();
                List<ControlDefinition> optionDefinitions = new ArrayList<ControlDefinition>();
                for (int j = 0; j <optionProperties.size(); j++) {
                    ControlDefinition definition = new ControlDefinition();
                    definition.setControlProperty( optionProperties.get(j));
                    definition.setValue(optionValues.get(j));
                    optionDefinitions.add(definition);
                }
                optionControl.setControlDefinitions(optionDefinitions);
                optionControls.add(optionControl);
            }
        }
    }

    public void addDataSource(String id, String value, boolean selected) {
        Option op = new Option(mainScreen, id, value, selected);
        options.add(op);

         String values[] = new String[options.size()];
//        int cantReal = 0;
        for (int i = 0; i < options.size(); i++) {
            values[i] = options.get(i).getPropertieValue("stringvalue");
        }
        resetModel(values);
        createControl();
        mainScreen.repaint();

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

    private void resetModel(String[] values) {
        setModel(new javax.swing.DefaultComboBoxModel(values));
    }

    public List<Control> getControlOptions() {
        return optionControls;
    }

    public void clearDataSource() {
        options = new ArrayList<Option>();
    }

    public void setControlId(Long controlID) {
        this.controlID = controlID;
    }

    public Long getGlobalID() {
        return globalID;
    }
}
