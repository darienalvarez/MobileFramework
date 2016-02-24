
package com.gazoomobile.mfw.platform.web.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "executeDatasourceResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executeDatasourceResponse", namespace = "http://impl.web.platform.mfw.gazoomobile.com/")
public class ExecuteDatasourceResponse {

    @XmlElement(name = "return", namespace = "")
    private com.gazoomobile.mfw.connector.db.DataBaseConnectorResult _return;

    /**
     * 
     * @return
     *     returns DataBaseConnectorResult
     */
    public com.gazoomobile.mfw.connector.db.DataBaseConnectorResult getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.gazoomobile.mfw.connector.db.DataBaseConnectorResult _return) {
        this._return = _return;
    }

}
