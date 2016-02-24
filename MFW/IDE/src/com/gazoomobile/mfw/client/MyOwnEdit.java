/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gazoomobile.mfw.client;

import com.gazoomobile.mfw.platform.client.ControlProperty;
import com.gazoomobile.mfw.platform.client.ControlType;
import com.gazoomobile.mfw.platform.client.ControlWebService;
import com.gazoomobile.mfw.platform.client.ControlWebServiceImpl;
import java.awt.event.MouseAdapter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Yunisel
 */
public class MyOwnEdit extends JTextField{
    private JPrincipal owner;
    private List<ControlProperty> properties;

    public MyOwnEdit(String text, JPrincipal owner) {
        super();
        setText(text);
        this.owner = owner;
        //properties = new Vector<String>();

        ControlType ct = new ControlType();
        ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI("http://localhost:8080/mfw/services/ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (URISyntaxException ex) {
            Logger.getLogger(MyOwnEdit.class.getName()).log(Level.SEVERE, null, ex);
        }catch (MalformedURLException ex) {
                Logger.getLogger(MyOwnEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        properties = control.getPropertiesByControlType("Boton");
//        for(int i=0; i<5; i++)
//            properties.add("Button propertie " + i);
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
          owner.getJList1().setModel(new DefaultListModel());
          owner.getJList2().setModel(new DefaultListModel());
          for(int i=0; i<properties.size(); i++)
          {
            ((DefaultListModel) owner.getJList1().getModel()).addElement(properties.get(i).getName());
            ((DefaultListModel) owner.getJList2().getModel()).addElement(properties.get(i).getPropertyType().getType());
          }

    }

//    public List<String> getPropiedades()
//    {
//        return properties;
//    }


}
