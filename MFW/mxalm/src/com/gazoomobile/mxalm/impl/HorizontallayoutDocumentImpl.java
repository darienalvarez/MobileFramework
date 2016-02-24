/*
 * An XML document type.
 * Localname: horizontallayout
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.HorizontallayoutDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one horizontallayout(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class HorizontallayoutDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.HorizontallayoutDocument
{
    private static final long serialVersionUID = 1L;
    
    public HorizontallayoutDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName HORIZONTALLAYOUT$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "horizontallayout");
    
    
    /**
     * Gets the "horizontallayout" element
     */
    public com.gazoomobile.mxalm.THorizontallayout getHorizontallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.THorizontallayout target = null;
            target = (com.gazoomobile.mxalm.THorizontallayout)get_store().find_element_user(HORIZONTALLAYOUT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "horizontallayout" element
     */
    public void setHorizontallayout(com.gazoomobile.mxalm.THorizontallayout horizontallayout)
    {
        generatedSetterHelperImpl(horizontallayout, HORIZONTALLAYOUT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "horizontallayout" element
     */
    public com.gazoomobile.mxalm.THorizontallayout addNewHorizontallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.THorizontallayout target = null;
            target = (com.gazoomobile.mxalm.THorizontallayout)get_store().add_element_user(HORIZONTALLAYOUT$0);
            return target;
        }
    }
}
