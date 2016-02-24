
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "executeDatasource", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeDatasource", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class ExecuteDatasource {

    @XmlElement(name = "arg0", namespace = "")
    private com.gazoomobile.mfw.platform.domain.Datasource arg0;

    /**
     * 
     * @return
     *     returns Datasource
     */
    public com.gazoomobile.mfw.platform.domain.Datasource getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.gazoomobile.mfw.platform.domain.Datasource arg0) {
        this.arg0 = arg0;
    }

}
