
package com.gazoomobile.mfw.platform.clientapi;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "ControlWebService", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ControlWebService {


    /**
     * 
     * @return
     *     returns java.util.List<com.gazoomobile.mfw.platform.clientapi.ControlType>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllControlTypes", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAllControlTypes")
    @ResponseWrapper(localName = "getAllControlTypesResponse", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAllControlTypesResponse")
    public List<ControlType> getAllControlTypes();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<com.gazoomobile.mfw.platform.clientapi.ControlProperty>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPropertiesByControlType", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetPropertiesByControlType")
    @ResponseWrapper(localName = "getPropertiesByControlTypeResponse", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetPropertiesByControlTypeResponse")
    public List<ControlProperty> getPropertiesByControlType(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
