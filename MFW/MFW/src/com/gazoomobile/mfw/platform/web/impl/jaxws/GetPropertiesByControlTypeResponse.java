
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPropertiesByControlTypeResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPropertiesByControlTypeResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class GetPropertiesByControlTypeResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.gazoomobile.mfw.platform.domain.ControlProperty> _return;

    /**
     * 
     * @return
     *     returns List<ControlProperty>
     */
    public List<com.gazoomobile.mfw.platform.domain.ControlProperty> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.gazoomobile.mfw.platform.domain.ControlProperty> _return) {
        this._return = _return;
    }

}
