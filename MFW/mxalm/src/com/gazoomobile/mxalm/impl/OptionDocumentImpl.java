/*
 * An XML document type.
 * Localname: option
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.OptionDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one option(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class OptionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.OptionDocument
{
    private static final long serialVersionUID = 1L;
    
    public OptionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPTION$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "option");
    
    
    /**
     * Gets the "option" element
     */
    public com.gazoomobile.mxalm.TOption getOption()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TOption target = null;
            target = (com.gazoomobile.mxalm.TOption)get_store().find_element_user(OPTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "option" element
     */
    public void setOption(com.gazoomobile.mxalm.TOption option)
    {
        generatedSetterHelperImpl(option, OPTION$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "option" element
     */
    public com.gazoomobile.mxalm.TOption addNewOption()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TOption target = null;
            target = (com.gazoomobile.mxalm.TOption)get_store().add_element_user(OPTION$0);
            return target;
        }
    }
}
