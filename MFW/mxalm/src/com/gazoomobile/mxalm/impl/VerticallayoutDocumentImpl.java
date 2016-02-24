/*
 * An XML document type.
 * Localname: verticallayout
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.VerticallayoutDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one verticallayout(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class VerticallayoutDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.VerticallayoutDocument
{
    private static final long serialVersionUID = 1L;
    
    public VerticallayoutDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName VERTICALLAYOUT$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "verticallayout");
    
    
    /**
     * Gets the "verticallayout" element
     */
    public com.gazoomobile.mxalm.TVerticallayout getVerticallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TVerticallayout target = null;
            target = (com.gazoomobile.mxalm.TVerticallayout)get_store().find_element_user(VERTICALLAYOUT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "verticallayout" element
     */
    public void setVerticallayout(com.gazoomobile.mxalm.TVerticallayout verticallayout)
    {
        generatedSetterHelperImpl(verticallayout, VERTICALLAYOUT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "verticallayout" element
     */
    public com.gazoomobile.mxalm.TVerticallayout addNewVerticallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TVerticallayout target = null;
            target = (com.gazoomobile.mxalm.TVerticallayout)get_store().add_element_user(VERTICALLAYOUT$0);
            return target;
        }
    }
}
