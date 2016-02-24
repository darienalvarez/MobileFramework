/*
 * An XML document type.
 * Localname: button
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.ButtonDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one button(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class ButtonDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.ButtonDocument
{
    private static final long serialVersionUID = 1L;
    
    public ButtonDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName BUTTON$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "button");
    
    
    /**
     * Gets the "button" element
     */
    public com.gazoomobile.mxalm.TButton getButton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TButton target = null;
            target = (com.gazoomobile.mxalm.TButton)get_store().find_element_user(BUTTON$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "button" element
     */
    public void setButton(com.gazoomobile.mxalm.TButton button)
    {
        generatedSetterHelperImpl(button, BUTTON$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "button" element
     */
    public com.gazoomobile.mxalm.TButton addNewButton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TButton target = null;
            target = (com.gazoomobile.mxalm.TButton)get_store().add_element_user(BUTTON$0);
            return target;
        }
    }
}
