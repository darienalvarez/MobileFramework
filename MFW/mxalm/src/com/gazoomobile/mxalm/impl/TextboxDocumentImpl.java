/*
 * An XML document type.
 * Localname: textbox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TextboxDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one textbox(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class TextboxDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TextboxDocument
{
    private static final long serialVersionUID = 1L;
    
    public TextboxDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TEXTBOX$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "textbox");
    
    
    /**
     * Gets the "textbox" element
     */
    public com.gazoomobile.mxalm.TTextbox getTextbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTextbox target = null;
            target = (com.gazoomobile.mxalm.TTextbox)get_store().find_element_user(TEXTBOX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "textbox" element
     */
    public void setTextbox(com.gazoomobile.mxalm.TTextbox textbox)
    {
        generatedSetterHelperImpl(textbox, TEXTBOX$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "textbox" element
     */
    public com.gazoomobile.mxalm.TTextbox addNewTextbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTextbox target = null;
            target = (com.gazoomobile.mxalm.TTextbox)get_store().add_element_user(TEXTBOX$0);
            return target;
        }
    }
}
