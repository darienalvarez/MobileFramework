
package com.gazoomobile.mfw.platform.clientapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for myOwnHashMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="myOwnHashMap">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entries" type="{http://impl.web.platform.mfw.gazoomobile.com/}myOwnHashMapEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myOwnHashMap", propOrder = {
    "entries"
})
public class MyOwnHashMap {

    @XmlElement(nillable = true)
    protected List<MyOwnHashMapEntry> entries;

    /**
     * Gets the value of the entries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MyOwnHashMapEntry }
     * 
     * 
     */
    public List<MyOwnHashMapEntry> getEntries() {
        if (entries == null) {
            entries = new ArrayList<MyOwnHashMapEntry>();
        }
        return this.entries;
    }

	public void setEntries(List<MyOwnHashMapEntry> entries) {
		this.entries = entries;
	}
}
