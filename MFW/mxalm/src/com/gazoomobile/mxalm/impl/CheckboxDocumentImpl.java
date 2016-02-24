/*
 * An XML document type.
 * Localname: checkbox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.CheckboxDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one checkbox(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class CheckboxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.CheckboxDocument
{
    private static final long serialVersionUID = 1L;
    
    public CheckboxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECKBOX$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "checkbox");
    
    
    /**
     * Gets the "checkbox" element
     */
    public com.gazoomobile.mxalm.TCheckbox getCheckbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCheckbox target = null;
            target = (com.gazoomobile.mxalm.TCheckbox)get_store().find_element_user(CHECKBOX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkbox" element
     */
    public void setCheckbox(com.gazoomobile.mxalm.TCheckbox checkbox)
    {
        generatedSetterHelperImpl(checkbox, CHECKBOX$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "checkbox" element
     */
    public com.gazoomobile.mxalm.TCheckbox addNewCheckbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCheckbox target = null;
            target = (com.gazoomobile.mxalm.TCheckbox)get_store().add_element_user(CHECKBOX$0);
            return target;
        }
    }
}
