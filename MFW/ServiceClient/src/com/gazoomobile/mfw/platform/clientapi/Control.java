
package com.gazoomobile.mfw.platform.clientapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for control complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="control">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="controlDefinitions" type="{http://impl.web.platform.mfw.gazoomobile.com/}controlDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="controlName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="controlType" type="{http://impl.web.platform.mfw.gazoomobile.com/}controlType" minOccurs="0"/>
 *         &lt;element name="idControl" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="index" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="parentControl" type="{http://impl.web.platform.mfw.gazoomobile.com/}control" minOccurs="0"/>
 *         &lt;element name="uid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "control", propOrder = {
    "controlDefinitions",
    "controlName",
    "controlType",
    "idControl",
    "index",
    "parentControl",
    "uid"
})
public class Control {

    @XmlElement(nillable = true)
    protected List<ControlDefinition> controlDefinitions;
    protected String controlName;
    protected ControlType controlType;
    protected Long idControl;
    protected int index;
    protected Control parentControl;
    protected Long uid;

    /**
     * Gets the value of the controlDefinitions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the controlDefinitions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getControlDefinitions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ControlDefinition }
     * 
     * 
     */
    public List<ControlDefinition> getControlDefinitions() {
        if (controlDefinitions == null) {
            controlDefinitions = new ArrayList<ControlDefinition>();
        }
        return this.controlDefinitions;
    }
    
    public void setControlDefinitions(List<ControlDefinition> controlDefinitions) {
		this.controlDefinitions = controlDefinitions;
	}

	/**
     * Gets the value of the controlName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlName() {
        return controlName;
    }

    /**
     * Sets the value of the controlName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlName(String value) {
        this.controlName = value;
    }

    /**
     * Gets the value of the controlType property.
     * 
     * @return
     *     possible object is
     *     {@link ControlType }
     *     
     */
    public ControlType getControlType() {
        return controlType;
    }

    /**
     * Sets the value of the controlType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlType }
     *     
     */
    public void setControlType(ControlType value) {
        this.controlType = value;
    }

    /**
     * Gets the value of the idControl property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdControl() {
        return idControl;
    }

    /**
     * Sets the value of the idControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdControl(Long value) {
        this.idControl = value;
    }

    /**
     * Gets the value of the index property.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the parentControl property.
     * 
     * @return
     *     possible object is
     *     {@link Control }
     *     
     */
    public Control getParentControl() {
        return parentControl;
    }

    /**
     * Sets the value of the parentControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Control }
     *     
     */
    public void setParentControl(Control value) {
        this.parentControl = value;
    }

    /**
     * Gets the value of the uid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUid(Long value) {
        this.uid = value;
    }

}
