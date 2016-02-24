/*
 * An XML document type.
 * Localname: edit
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.EditDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one edit(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class EditDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.EditDocument
{
    private static final long serialVersionUID = 1L;
    
    public EditDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EDIT$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "edit");
    
    
    /**
     * Gets the "edit" element
     */
    public com.gazoomobile.mxalm.TEdit getEdit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TEdit target = null;
            target = (com.gazoomobile.mxalm.TEdit)get_store().find_element_user(EDIT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "edit" element
     */
    public void setEdit(com.gazoomobile.mxalm.TEdit edit)
    {
        generatedSetterHelperImpl(edit, EDIT$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "edit" element
     */
    public com.gazoomobile.mxalm.TEdit addNewEdit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TEdit target = null;
            target = (com.gazoomobile.mxalm.TEdit)get_store().add_element_user(EDIT$0);
            return target;
        }
    }
}
