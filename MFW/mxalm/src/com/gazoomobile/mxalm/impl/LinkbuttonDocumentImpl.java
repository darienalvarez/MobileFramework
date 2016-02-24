/*
 * An XML document type.
 * Localname: linkbutton
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.LinkbuttonDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one linkbutton(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class LinkbuttonDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.LinkbuttonDocument
{
    private static final long serialVersionUID = 1L;
    
    public LinkbuttonDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LINKBUTTON$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "linkbutton");
    
    
    /**
     * Gets the "linkbutton" element
     */
    public com.gazoomobile.mxalm.TLinkbutton getLinkbutton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLinkbutton target = null;
            target = (com.gazoomobile.mxalm.TLinkbutton)get_store().find_element_user(LINKBUTTON$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "linkbutton" element
     */
    public void setLinkbutton(com.gazoomobile.mxalm.TLinkbutton linkbutton)
    {
        generatedSetterHelperImpl(linkbutton, LINKBUTTON$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "linkbutton" element
     */
    public com.gazoomobile.mxalm.TLinkbutton addNewLinkbutton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLinkbutton target = null;
            target = (com.gazoomobile.mxalm.TLinkbutton)get_store().add_element_user(LINKBUTTON$0);
            return target;
        }
    }
}
