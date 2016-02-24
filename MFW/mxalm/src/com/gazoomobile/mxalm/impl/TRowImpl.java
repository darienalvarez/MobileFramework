/*
 * XML Type:  T_row
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TRow
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * An XML T_row(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public class TRowImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TRow
{
    private static final long serialVersionUID = 1L;
    
    public TRowImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName COLUMN$0 = 
        new javax.xml.namespace.QName("", "column");
    private static final javax.xml.namespace.QName BACKGROUND$2 = 
        new javax.xml.namespace.QName("", "background");
    
    
    /**
     * Gets array of all "column" elements
     */
    public com.gazoomobile.mxalm.TColumn[] getColumnArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(COLUMN$0, targetList);
            com.gazoomobile.mxalm.TColumn[] result = new com.gazoomobile.mxalm.TColumn[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "column" element
     */
    public com.gazoomobile.mxalm.TColumn getColumnArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TColumn target = null;
            target = (com.gazoomobile.mxalm.TColumn)get_store().find_element_user(COLUMN$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "column" element
     */
    public int sizeOfColumnArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(COLUMN$0);
        }
    }
    
    /**
     * Sets array of all "column" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setColumnArray(com.gazoomobile.mxalm.TColumn[] columnArray)
    {
        check_orphaned();
        arraySetterHelper(columnArray, COLUMN$0);
    }
    
    /**
     * Sets ith "column" element
     */
    public void setColumnArray(int i, com.gazoomobile.mxalm.TColumn column)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TColumn target = null;
            target = (com.gazoomobile.mxalm.TColumn)get_store().find_element_user(COLUMN$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(column);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "column" element
     */
    public com.gazoomobile.mxalm.TColumn insertNewColumn(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TColumn target = null;
            target = (com.gazoomobile.mxalm.TColumn)get_store().insert_element_user(COLUMN$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "column" element
     */
    public com.gazoomobile.mxalm.TColumn addNewColumn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TColumn target = null;
            target = (com.gazoomobile.mxalm.TColumn)get_store().add_element_user(COLUMN$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "column" element
     */
    public void removeColumn(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(COLUMN$0, i);
        }
    }
    
    /**
     * Gets the "background" attribute
     */
    public java.lang.String getBackground()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BACKGROUND$2);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "background" attribute
     */
    public org.apache.xmlbeans.XmlString xgetBackground()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BACKGROUND$2);
            return target;
        }
    }
    
    /**
     * True if has "background" attribute
     */
    public boolean isSetBackground()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().find_attribute_user(BACKGROUND$2) != null;
        }
    }
    
    /**
     * Sets the "background" attribute
     */
    public void setBackground(java.lang.String background)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BACKGROUND$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BACKGROUND$2);
            }
            target.setStringValue(background);
        }
    }
    
    /**
     * Sets (as xml) the "background" attribute
     */
    public void xsetBackground(org.apache.xmlbeans.XmlString background)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BACKGROUND$2);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(BACKGROUND$2);
            }
            target.set(background);
        }
    }
    
    /**
     * Unsets the "background" attribute
     */
    public void unsetBackground()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_attribute(BACKGROUND$2);
        }
    }
}
