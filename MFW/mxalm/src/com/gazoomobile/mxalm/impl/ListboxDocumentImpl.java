/*
 * An XML document type.
 * Localname: listbox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.ListboxDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one listbox(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class ListboxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.ListboxDocument
{
    private static final long serialVersionUID = 1L;
    
    public ListboxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LISTBOX$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "listbox");
    
    
    /**
     * Gets the "listbox" element
     */
    public com.gazoomobile.mxalm.TListbox getListbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TListbox target = null;
            target = (com.gazoomobile.mxalm.TListbox)get_store().find_element_user(LISTBOX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "listbox" element
     */
    public void setListbox(com.gazoomobile.mxalm.TListbox listbox)
    {
        generatedSetterHelperImpl(listbox, LISTBOX$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "listbox" element
     */
    public com.gazoomobile.mxalm.TListbox addNewListbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TListbox target = null;
            target = (com.gazoomobile.mxalm.TListbox)get_store().add_element_user(LISTBOX$0);
            return target;
        }
    }
}
