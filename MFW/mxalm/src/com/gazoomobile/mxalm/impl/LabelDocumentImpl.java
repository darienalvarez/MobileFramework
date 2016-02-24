/*
 * An XML document type.
 * Localname: label
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.LabelDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one label(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class LabelDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.LabelDocument
{
    private static final long serialVersionUID = 1L;
    
    public LabelDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LABEL$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "label");
    
    
    /**
     * Gets the "label" element
     */
    public com.gazoomobile.mxalm.TLabel getLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLabel target = null;
            target = (com.gazoomobile.mxalm.TLabel)get_store().find_element_user(LABEL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "label" element
     */
    public void setLabel(com.gazoomobile.mxalm.TLabel label)
    {
        generatedSetterHelperImpl(label, LABEL$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "label" element
     */
    public com.gazoomobile.mxalm.TLabel addNewLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLabel target = null;
            target = (com.gazoomobile.mxalm.TLabel)get_store().add_element_user(LABEL$0);
            return target;
        }
    }
}
