
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "createOrUpdateUser", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrUpdateUser", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class CreateOrUpdateUser {

    @XmlElement(name = "arg0", namespace = "")
    private com.gazoomobile.mfw.platform.domain.User arg0;

    /**
     * 
     * @return
     *     returns User
     */
    public com.gazoomobile.mfw.platform.domain.User getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.gazoomobile.mfw.platform.domain.User arg0) {
        this.arg0 = arg0;
    }

}
