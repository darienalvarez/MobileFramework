
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAlldbTables", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlldbTables", namespace = "http://impl.web.platform.mfw.gazoomobile.com/", propOrder = {
    "arg0",
    "arg1"
})
public class GetAlldbTables {

    @XmlElement(name = "arg0", namespace = "")
    private String arg0;
    @XmlElement(name = "arg1", namespace = "")
    private com.gazoomobile.mfw.platform.web.impl.MyOwnHashMap arg1;

    /**
     * 
     * @return
     *     returns String
     */
    public String getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(String arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns MyOwnHashMap
     */
    public com.gazoomobile.mfw.platform.web.impl.MyOwnHashMap getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(com.gazoomobile.mfw.platform.web.impl.MyOwnHashMap arg1) {
        this.arg1 = arg1;
    }

}
