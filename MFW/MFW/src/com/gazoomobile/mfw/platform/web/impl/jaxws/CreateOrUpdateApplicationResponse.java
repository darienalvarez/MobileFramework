
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "createOrUpdateApplicationResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrUpdateApplicationResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class CreateOrUpdateApplicationResponse {

    @XmlElement(name = "return", namespace = "")
    private com.gazoomobile.mfw.platform.domain.Application _return;

    /**
     * 
     * @return
     *     returns Application
     */
    public com.gazoomobile.mfw.platform.domain.Application getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.gazoomobile.mfw.platform.domain.Application _return) {
        this._return = _return;
    }

}
