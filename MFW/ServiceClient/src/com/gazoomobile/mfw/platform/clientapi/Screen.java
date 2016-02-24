
package com.gazoomobile.mfw.platform.clientapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for screen complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="screen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controls" type="{http://impl.web.platform.mfw.gazoomobile.com/}control" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="datasources" type="{http://impl.web.platform.mfw.gazoomobile.com/}datasource" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defaultScreen" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idScreen" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "screen", propOrder = {
    "controls",
    "datasources",
    "defaultScreen",
    "description",
    "idScreen",
    "name"
})
public class Screen {

    @XmlElement(nillable = true)
    protected List<Control> controls;
    @XmlElement(nillable = true)
    protected List<Datasource> datasources;
    protected boolean defaultScreen;
    protected String description;
    protected Long idScreen;
    protected String name;

    /**
     * Gets the value of the controls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Control }
     * 
     * 
     */
    public List<Control> getControls() {
        if (controls == null) {
            controls = new ArrayList<Control>();
        }
        return this.controls;
    }
    
    public void setControls(List<Control> controls) {
		this.controls = controls;
	}

	/**
     * Gets the value of the datasources property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datasources property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatasources().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Datasource }
     * 
     * 
     */
    public List<Datasource> getDatasources() {
        if (datasources == null) {
            datasources = new ArrayList<Datasource>();
        }
        return this.datasources;
    }
    
    public void setDatasources(List<Datasource> datasources) {
		this.datasources = datasources;
	}

	/**
     * Gets the value of the defaultScreen property.
     * 
     */
    public boolean isDefaultScreen() {
        return defaultScreen;
    }

    /**
     * Sets the value of the defaultScreen property.
     * 
     */
    public void setDefaultScreen(boolean value) {
        this.defaultScreen = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the idScreen property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdScreen() {
        return idScreen;
    }

    /**
     * Sets the value of the idScreen property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdScreen(Long value) {
        this.idScreen = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
