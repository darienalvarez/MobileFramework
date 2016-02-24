/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazoomobile.mfw.client.view;

import com.gazoomobile.mfw.platform.clientapi.ControlProperty;
import com.gazoomobile.mfw.platform.clientapi.ControlType;
import com.gazoomobile.mfw.platform.clientapi.ControlWebService;
import com.gazoomobile.mfw.platform.clientapi.ControlWebServiceImpl;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yunisel
 */
public class Option {

    private List<ControlProperty> properties;
    private List<String> values;
    private ControlType optionControlType;

    public Option( MainView mainScreen, String id, String value, boolean selected) {
        properties = new ArrayList<ControlProperty>();
        values = new ArrayList<String>();
         ControlWebService control = null;
        try {
          control = new ControlWebServiceImpl(new URI(MainView.SERVER_URL + "ControlService?wsdl").toURL()).getControlWebServiceImplPort();
        } catch (Exception ex) {
                Logger.getLogger(Option.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<ControlType> controlTypes = control.getAllControlTypes();
        for (int i = 0; i < controlTypes.size(); i++) {
            if (controlTypes.get(i).getType().equals("option")) {
                optionControlType = controlTypes.get(i);
            }
        }
        properties = control.getPropertiesByControlType(optionControlType.getType());
        for (int i = 0; i < properties.size(); i++) {
            values.add("");
        }
        modifyPropertieValue("stringvalue", value);
        modifyPropertieValue("value", id);
        modifyPropertieValue("selected", String.valueOf(selected));
    }

    public List<ControlProperty> getProperties() {
        return properties;
    }

    public List<String> getValues(){
        return values;
    }

    private void modifyPropertieValue(String propertie, String value) {
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getName().equals(propertie)) {
                values.set(i, value);
            }
        }
    }
    
    public String getIdOption(){
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getName().equals("id")) {
                return values.get(i);
            }
        }
        return "";
    }

    public String getPropertieValue(String propertie){
         for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getName().equals(propertie)) {
                return values.get(i);
            }
        }
        return "";
    }
}
