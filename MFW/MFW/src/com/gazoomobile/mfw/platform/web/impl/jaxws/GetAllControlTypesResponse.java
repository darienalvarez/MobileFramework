
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getAllControlTypesResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllControlTypesResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class GetAllControlTypesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.gazoomobile.mfw.platform.domain.ControlType> _return;

    /**
     * 
     * @return
     *     returns List<ControlType>
     */
    public List<com.gazoomobile.mfw.platform.domain.ControlType> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.gazoomobile.mfw.platform.domain.ControlType> _return) {
        this._return = _return;
    }

}
