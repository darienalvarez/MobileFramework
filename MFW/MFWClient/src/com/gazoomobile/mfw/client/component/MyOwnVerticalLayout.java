/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazoomobile.mfw.client.component;

import com.gazoomobile.clien.exception.ConnectException;
import com.gazoomobile.mfw.client.interfaces.IControl;
import com.gazoomobile.mfw.client.interfaces.IIndexer;
import com.gazoomobile.mfw.platform.client.ControlProperty;
import com.gazoomobile.mfw.platform.client.ControlWebService;
import com.gazoomobile.mfw.platform.client.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.URI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.gazoomobile.mfw.client.view.MainView;
import com.gazoomobile.mfw.platform.client.Control;
import com.gazoomobile.mfw.platform.client.ControlDefinition;
import com.gazoomobile.mfw.platform.client.ControlType;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Yunisel
 */
public class MyOwnVerticalLayout extends JPanel implements IControl, IIndexer {

    private MainView mainScreen;
    private List<ControlProperty> properties;
    private List<String> values;
    private String name;
    private ControlType controlType;
    private Control backControl;
    private Dimension separationBetewenComponents;
    private int indexCounter=0;
    private int indexInContainer;

    public MyOwnVerticalLayout(String name, int indexInContainer, final MainView mainScreen, ControlType controlType, Dimension separationBetewenComponents) throws ConnectException {
        super();
        this.mainScreen = mainScreen;
        this.indexInContainer = indexInContainer;
        this.name = name;
        this.controlType = controlType;
        this.separationBetewenComponents = separationBetewenComponents;
        values = new Vector<String>();

        ControlWebService control = null;
        try {
            control = new ControlWebServiceImpl(new URI(mainScreen.GAZOO_DIR +"ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
            throw new ConnectException(ex.getMessage());
//            Logger.getLogger(MyOwnVerticalLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        properties = control.getPropertiesByControlType(controlType.getType());

        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createRigidArea(separationBetewenComponents));
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onMouseClicked(evt);
                mainScreen.RaisedAllComponentsBorders();
                requestFocus();
            }

             public void mouseEntered(java.awt.event.MouseEvent evt) {
                    mainScreen.onJPanelMouseEntered(evt);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    mainScreen.onJPanelMouseExited(evt);
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
        mainScreen.AddComponentToActivePanel();
        mainScreen.addPropertiesToContainer(properties, values, this);
    }

    private void OnComponentDelete(java.awt.event.KeyEvent evt) {
        mainScreen.OnComponentDelete(evt);
    }

    public int getIndexCounter(){
        return indexCounter++;
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
