
package com.gazoomobile.mfw.platform.clientapi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gazoomobile.mfw.platform.clientapi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllConnectorPropertiesByName_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConnectorPropertiesByName");
    private final static QName _GetAllConnectorPropertiesByNameResponse_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConnectorPropertiesByNameResponse");
    private final static QName _GetAllConectorTypesResponse_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConectorTypesResponse");
    private final static QName _GetAllConnectorProperties_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConnectorProperties");
    private final static QName _GetAllConectorTypes_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConectorTypes");
    private final static QName _GetAllConnectorPropertiesResponse_QNAME = new QName("http://impl.web.platform.mfw.gazoomobile.com/", "getAllConnectorPropertiesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gazoomobile.mfw.platform.clientapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllConnectorPropertiesByNameResponse }
     * 
     */
    public GetAllConnectorPropertiesByNameResponse createGetAllConnectorPropertiesByNameResponse() {
        return new GetAllConnectorPropertiesByNameResponse();
    }

    /**
     * Create an instance of {@link ConnectorType }
     * 
     */
    public ConnectorType createConnectorType() {
        return new ConnectorType();
    }

    /**
     * Create an instance of {@link ConnectorProperty }
     * 
     */
    public ConnectorProperty createConnectorProperty() {
        return new ConnectorProperty();
    }

    /**
     * Create an instance of {@link GetAllConectorTypesResponse }
     * 
     */
    public GetAllConectorTypesResponse createGetAllConectorTypesResponse() {
        return new GetAllConectorTypesResponse();
    }

    /**
     * Create an instance of {@link GetAllConectorTypes }
     * 
     */
    public GetAllConectorTypes createGetAllConectorTypes() {
        return new GetAllConectorTypes();
    }

    /**
     * Create an instance of {@link GetAllConnectorPropertiesByName }
     * 
     */
    public GetAllConnectorPropertiesByName createGetAllConnectorPropertiesByName() {
        return new GetAllConnectorPropertiesByName();
    }

    /**
     * Create an instance of {@link GetAllConnectorProperties }
     * 
     */
    public GetAllConnectorProperties createGetAllConnectorProperties() {
        return new GetAllConnectorProperties();
    }

    /**
     * Create an instance of {@link GetAllConnectorPropertiesResponse }
     * 
     */
    public GetAllConnectorPropertiesResponse createGetAllConnectorPropertiesResponse() {
        return new GetAllConnectorPropertiesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConnectorPropertiesByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConnectorPropertiesByName")
    public JAXBElement<GetAllConnectorPropertiesByName> createGetAllConnectorPropertiesByName(GetAllConnectorPropertiesByName value) {
        return new JAXBElement<GetAllConnectorPropertiesByName>(_GetAllConnectorPropertiesByName_QNAME, GetAllConnectorPropertiesByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConnectorPropertiesByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConnectorPropertiesByNameResponse")
    public JAXBElement<GetAllConnectorPropertiesByNameResponse> createGetAllConnectorPropertiesByNameResponse(GetAllConnectorPropertiesByNameResponse value) {
        return new JAXBElement<GetAllConnectorPropertiesByNameResponse>(_GetAllConnectorPropertiesByNameResponse_QNAME, GetAllConnectorPropertiesByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConectorTypesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConectorTypesResponse")
    public JAXBElement<GetAllConectorTypesResponse> createGetAllConectorTypesResponse(GetAllConectorTypesResponse value) {
        return new JAXBElement<GetAllConectorTypesResponse>(_GetAllConectorTypesResponse_QNAME, GetAllConectorTypesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConnectorProperties }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConnectorProperties")
    public JAXBElement<GetAllConnectorProperties> createGetAllConnectorProperties(GetAllConnectorProperties value) {
        return new JAXBElement<GetAllConnectorProperties>(_GetAllConnectorProperties_QNAME, GetAllConnectorProperties.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConectorTypes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConectorTypes")
    public JAXBElement<GetAllConectorTypes> createGetAllConectorTypes(GetAllConectorTypes value) {
        return new JAXBElement<GetAllConectorTypes>(_GetAllConectorTypes_QNAME, GetAllConectorTypes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllConnectorPropertiesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.web.platform.mfw.gazoomobile.com/", name = "getAllConnectorPropertiesResponse")
    public JAXBElement<GetAllConnectorPropertiesResponse> createGetAllConnectorPropertiesResponse(GetAllConnectorPropertiesResponse value) {
        return new JAXBElement<GetAllConnectorPropertiesResponse>(_GetAllConnectorPropertiesResponse_QNAME, GetAllConnectorPropertiesResponse.class, null, value);
    }

}
