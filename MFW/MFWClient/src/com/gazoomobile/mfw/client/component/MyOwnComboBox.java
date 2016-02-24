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
import javax.swing.JComboBox;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.platform.client.Control;
import com.gazoomobile.mfw.platform.client.ControlDefinition;
import com.gazoomobile.mfw.platform.client.ControlType;
import java.awt.Dimension;
import java.util.Vector;
/**
 *
 * @author Yunisel
 */
public class MyOwnComboBox extends JComboBox implements IControl{
    private MainView mainScreen;
    private List<ControlProperty> properties;
    private List<String> values;
    private String name;
    private ControlType controlType;
    private Control backControl;
    private int indexInContainer;

    public MyOwnComboBox(String name, int indexInContainer, final MainView mainScreen, ControlType controlType) {
        super();
        this.indexInContainer = indexInContainer;
        this.mainScreen = mainScreen;
        this.name = name;
        this.controlType = controlType;
        values = new Vector<String>();
        values.add("Value");
        values.add("Link");
        setMaximumSize(new Dimension(100,20));
       // ControlType ct = new ControlType();
        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI(mainScreen.GAZOO_DIR + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
                Logger.getLogger(MyOwnComboBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        properties = control.getPropertiesByControlType(controlType.getType());
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
