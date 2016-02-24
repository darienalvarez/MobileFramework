
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
@WebService(name = "DatasourceWebService", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DatasourceWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns com.gazoomobile.mfw.platform.clientapi.DataBaseConnectorResult
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "executeDatasource", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.ExecuteDatasource")
    @ResponseWrapper(localName = "executeDatasourceResponse", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.ExecuteDatasourceResponse")
    public DataBaseConnectorResult executeDatasource(
        @WebParam(name = "arg0", targetNamespace = "")
        Datasource arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<com.gazoomobile.mfw.platform.clientapi.Table>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlldbTables", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAlldbTables")
    @ResponseWrapper(localName = "getAlldbTablesResponse", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAlldbTablesResponse")
    public List<Table> getAlldbTables(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        MyOwnHashMap arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<com.gazoomobile.mfw.platform.clientapi.Table>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAlldbTablesByOwner", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAlldbTablesByOwner")
    @ResponseWrapper(localName = "getAlldbTablesByOwnerResponse", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", className = "com.gazoomobile.mfw.platform.clientapi.GetAlldbTablesByOwnerResponse")
    public List<Table> getAlldbTablesByOwner(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        MyOwnHashMap arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
