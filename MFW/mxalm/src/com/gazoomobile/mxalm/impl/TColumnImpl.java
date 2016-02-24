/*
 * XML Type:  T_column
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TColumn
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * An XML T_column(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public class TColumnImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TColumn
{
    private static final long serialVersionUID = 1L;
    
    public TColumnImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName EDIT$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "edit");
    private static final javax.xml.namespace.QName BUTTON$2 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "button");
    private static final javax.xml.namespace.QName TEXT$4 = 
        new javax.xml.namespace.QName("", "text");
    private static final javax.xml.namespace.QName COLSPAN$6 = 
        new javax.xml.namespace.QName("", "colspan");
    
    
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
    
    /**
     * Gets the "button" element
     */
    public com.gazoomobile.mxalm.TButton getButton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TButton target = null;
            target = (com.gazoomobile.mxalm.TButton)get_store().find_element_user(BUTTON$2, 0);
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
        generatedSetterHelperImpl(button, BUTTON$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TButton)get_store().add_element_user(BUTTON$2);
            return target;
        }
    }
    
    /**
     * Gets the "text" element
     */
    public java.lang.String getText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TEXT$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "text" element
     */
    public org.apache.xmlbeans.XmlString xgetText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TEXT$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "text" element
     */
    public void setText(java.lang.String text)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(TEXT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(TEXT$4);
            }
            target.setStringValue(text);
        }
    }
    
    /**
     * Sets (as xml) the "text" element
     */
    public void xsetText(org.apache.xmlbeans.XmlString text)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(TEXT$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(TEXT$4);
            }
            target.set(text);
        }
    }
    
    /**
     * Gets the "colspan" attribute
     */
    public java.math.BigInteger getColspan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLSPAN$6);
            if (target == null)
            {
                return null;
            }
            return target.getBigIntegerValue();
        }
    }
    
    /**
     * Gets (as xml) the "colspan" attribute
     */
    public org.apache.xmlbeans.XmlInteger xgetColspan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_attribute_user(COLSPAN$6);
            return target;
        }
    }
    
    /**
     * True if has "colspan" attribute
     */
    public boolean isSetColspan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(COLSPAN$6) != null;
        }
    }
    
    /**
     * Sets the "colspan" attribute
     */
    public void setColspan(java.math.BigInteger colspan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLSPAN$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(COLSPAN$6);
            }
            target.setBigIntegerValue(colspan);
        }
    }
    
    /**
     * Sets (as xml) the "colspan" attribute
     */
    public void xsetColspan(org.apache.xmlbeans.XmlInteger colspan)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInteger target = null;
            target = (org.apache.xmlbeans.XmlInteger)get_store().find_attribute_user(COLSPAN$6);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInteger)get_store().add_attribute_user(COLSPAN$6);
            }
            target.set(colspan);
        }
    }
    
    /**
     * Unsets the "colspan" attribute
     */
    public void unsetColspan()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(COLSPAN$6);
        }
    }
}
