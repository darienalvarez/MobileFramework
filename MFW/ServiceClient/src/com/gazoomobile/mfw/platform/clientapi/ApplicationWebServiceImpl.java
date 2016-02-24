
package com.gazoomobile.mfw.platform.clientapi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ApplicationWebServiceImpl", targetNamespace = "http://impl.web.platform.mfw.gazoomobile.com/", wsdlLocation = "http://localhost:8080/MFW/services/ApplicationService?wsdl")
public class ApplicationWebServiceImpl
    extends Service
{

    private final static URL APPLICATIONWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(com.gazoomobile.mfw.platform.clientapi.ApplicationWebServiceImpl.class.getName());
    private static final QName serviceName;

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = com.gazoomobile.mfw.platform.clientapi.ApplicationWebServiceImpl.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/MFW/services/ApplicationService?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/MFW/services/ApplicationService?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        APPLICATIONWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        serviceName = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "ApplicationWebServiceImplService");
    }

    public ApplicationWebServiceImpl(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }
    
    public ApplicationWebServiceImpl(URL wsdlLocation) {
        super(wsdlLocation, serviceName);
    }

    public ApplicationWebServiceImpl() {
        super(APPLICATIONWEBSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://impl.web.platform.mfw.gazoomobile.com/", "ApplicationWebServiceImplService"));
    }

    /**
     * 
     * @return
     *     returns ApplicationWebService
     */
    @WebEndpoint(name = "ApplicationWebServiceImplPort")
    public ApplicationWebService getApplicationWebServiceImplPort() {
        return super.getPort(new QName("http://impl.web.platform.mfw.gazoomobile.com/", "ApplicationWebServiceImplPort"), ApplicationWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ApplicationWebService
     */
    @WebEndpoint(name = "ApplicationWebServiceImplPort")
    public ApplicationWebService getApplicationWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.web.platform.mfw.gazoomobile.com/", "ApplicationWebServiceImplPort"), ApplicationWebService.class, features);
    }

}