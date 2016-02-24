/*
 * An XML document type.
 * Localname: form
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.FormDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one form(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class FormDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.FormDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORM$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "form");
    
    
    /**
     * Gets the "form" element
     */
    public com.gazoomobile.mxalm.TForm getForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TForm target = null;
            target = (com.gazoomobile.mxalm.TForm)get_store().find_element_user(FORM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "form" element
     */
    public void setForm(com.gazoomobile.mxalm.TForm form)
    {
        generatedSetterHelperImpl(form, FORM$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "form" element
     */
    public com.gazoomobile.mxalm.TForm addNewForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TForm target = null;
            target = (com.gazoomobile.mxalm.TForm)get_store().add_element_user(FORM$0);
            return target;
        }
    }
}
