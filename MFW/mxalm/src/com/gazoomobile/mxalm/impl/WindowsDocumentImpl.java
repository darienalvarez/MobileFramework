/*
 * An XML document type.
 * Localname: windows
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.WindowsDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one windows(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class WindowsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.WindowsDocument
{
    private static final long serialVersionUID = 1L;
    
    public WindowsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName WINDOWS$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "windows");
    
    
    /**
     * Gets the "windows" element
     */
    public com.gazoomobile.mxalm.TWindows getWindows()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TWindows target = null;
            target = (com.gazoomobile.mxalm.TWindows)get_store().find_element_user(WINDOWS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "windows" element
     */
    public void setWindows(com.gazoomobile.mxalm.TWindows windows)
    {
        generatedSetterHelperImpl(windows, WINDOWS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "windows" element
     */
    public com.gazoomobile.mxalm.TWindows addNewWindows()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TWindows target = null;
            target = (com.gazoomobile.mxalm.TWindows)get_store().add_element_user(WINDOWS$0);
            return target;
        }
    }
}
