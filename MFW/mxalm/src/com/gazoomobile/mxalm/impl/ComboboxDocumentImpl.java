/*
 * An XML document type.
 * Localname: combobox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.ComboboxDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one combobox(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class ComboboxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.ComboboxDocument
{
    private static final long serialVersionUID = 1L;
    
    public ComboboxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COMBOBOX$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "combobox");
    
    
    /**
     * Gets the "combobox" element
     */
    public com.gazoomobile.mxalm.TCombobox getCombobox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCombobox target = null;
            target = (com.gazoomobile.mxalm.TCombobox)get_store().find_element_user(COMBOBOX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "combobox" element
     */
    public void setCombobox(com.gazoomobile.mxalm.TCombobox combobox)
    {
        generatedSetterHelperImpl(combobox, COMBOBOX$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "combobox" element
     */
    public com.gazoomobile.mxalm.TCombobox addNewCombobox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCombobox target = null;
            target = (com.gazoomobile.mxalm.TCombobox)get_store().add_element_user(COMBOBOX$0);
            return target;
        }
    }
}
