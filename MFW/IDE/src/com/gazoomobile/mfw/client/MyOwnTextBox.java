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
import javax.swing.JTextArea;
/**
 *
 * @author Yunisel
 */
public class MyOwnTextBox extends JTextArea{
    private JPrincipal mainScreen;
    private List<ControlProperty> properties;

    public MyOwnTextBox(JPrincipal mainScreen, String controType) {
        super();
        this.mainScreen = mainScreen;
        

       // ControlType ct = new ControlType();
        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI("http://localhost:8080/MFW/services/ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
                Logger.getLogger(MyOwnTextBox.class.getName()).log(Level.SEVERE, null, ex);
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
