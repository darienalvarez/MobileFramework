
package com.gazoomobile.mfw.platform.clientapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for connector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="connector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connectorType" type="{http://impl.web.platform.mfw.gazoomobile.com/}connectorType" minOccurs="0"/>
 *         &lt;element name="definitions" type="{http://impl.web.platform.mfw.gazoomobile.com/}connectorDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idConnector" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connector", propOrder = {
    "connectorType",
    "definitions",
    "idConnector"
})
public class Connector {

    protected ConnectorType connectorType;
    @XmlElement(nillable = true)
    protected List<ConnectorDefinition> definitions;
    protected Long idConnector;

    /**
     * Gets the value of the connectorType property.
     * 
     * @return
     *     possible object is
     *     {@link ConnectorType }
     *     
     */
    public ConnectorType getConnectorType() {
        return connectorType;
    }

    /**
     * Sets the value of the connectorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConnectorType }
     *     
     */
    public void setConnectorType(ConnectorType value) {
        this.connectorType = value;
    }

    /**
     * Gets the value of the definitions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the definitions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefinitions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConnectorDefinition }
     * 
     * 
     */
    public List<ConnectorDefinition> getDefinitions() {
        if (definitions == null) {
            definitions = new ArrayList<ConnectorDefinition>();
        }
        return this.definitions;
    }
    
    public void setDefinitions(List<ConnectorDefinition> definitions) {
		this.definitions = definitions;
	}

	/**
     * Gets the value of the idConnector property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdConnector() {
        return idConnector;
    }

    /**
     * Sets the value of the idConnector property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdConnector(Long value) {
        this.idConnector = value;
    }

}
