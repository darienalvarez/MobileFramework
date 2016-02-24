/*
 * XML Type:  T_listbox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TListbox
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * An XML T_listbox(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public class TListboxImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TListbox
{
    private static final long serialVersionUID = 1L;
    
    public TListboxImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OPTION$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "option");
    private static final javax.xml.namespace.QName ID$2 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets array of all "option" elements
     */
    public com.gazoomobile.mxalm.TOption[] getOptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(OPTION$0, targetList);
            com.gazoomobile.mxalm.TOption[] result = new com.gazoomobile.mxalm.TOption[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "option" element
     */
    public com.gazoomobile.mxalm.TOption getOptionArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TOption target = null;
            target = (com.gazoomobile.mxalm.TOption)get_store().find_element_user(OPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "option" element
     */
    public int sizeOfOptionArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(OPTION$0);
        }
    }
    
    /**
     * Sets array of all "option" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setOptionArray(com.gazoomobile.mxalm.TOption[] optionArray)
    {
        check_orphaned();
        arraySetterHelper(optionArray, OPTION$0);
    }
    
    /**
     * Sets ith "option" element
     */
    public void setOptionArray(int i, com.gazoomobile.mxalm.TOption option)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TOption target = null;
            target = (com.gazoomobile.mxalm.TOption)get_store().find_element_user(OPTION$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(option);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "option" element
     */
    public com.gazoomobile.mxalm.TOption insertNewOption(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TOption target = null;
            target = (com.gazoomobile.mxalm.TOption)get_store().insert_element_user(OPTION$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "option" element
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
    
    /**
     * Removes the ith "option" element
     */
    public void removeOption(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(OPTION$0, i);
        }
    }
    
    /**
     * Gets the "id" attribute
     */
    public java.lang.String getId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "id" attribute
     */
    public org.apache.xmlbeans.XmlString xgetId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
            return target;
        }
    }
    
    /**
     * Sets the "id" attribute
     */
    public void setId(java.lang.String id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$2);
            }
            target.setStringValue(id);
        }
    }
    
    /**
     * Sets (as xml) the "id" attribute
     */
    public void xsetId(org.apache.xmlbeans.XmlString id)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$2);
            }
            target.set(id);
        }
    }
}
