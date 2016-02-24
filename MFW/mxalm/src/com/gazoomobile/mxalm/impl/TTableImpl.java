/*
 * XML Type:  T_table
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TTable
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * An XML T_table(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public class TTableImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TTable
{
    private static final long serialVersionUID = 1L;
    
    public TTableImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ROW$0 = 
        new javax.xml.namespace.QName("", "row");
    private static final javax.xml.namespace.QName ID$2 = 
        new javax.xml.namespace.QName("", "id");
    
    
    /**
     * Gets array of all "row" elements
     */
    public com.gazoomobile.mxalm.TRow[] getRowArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ROW$0, targetList);
            com.gazoomobile.mxalm.TRow[] result = new com.gazoomobile.mxalm.TRow[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "row" element
     */
    public com.gazoomobile.mxalm.TRow getRowArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TRow target = null;
            target = (com.gazoomobile.mxalm.TRow)get_store().find_element_user(ROW$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "row" element
     */
    public int sizeOfRowArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ROW$0);
        }
    }
    
    /**
     * Sets array of all "row" element  WARNING: This method is not atomicaly synchronized.
     */
    public void setRowArray(com.gazoomobile.mxalm.TRow[] rowArray)
    {
        check_orphaned();
        arraySetterHelper(rowArray, ROW$0);
    }
    
    /**
     * Sets ith "row" element
     */
    public void setRowArray(int i, com.gazoomobile.mxalm.TRow row)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TRow target = null;
            target = (com.gazoomobile.mxalm.TRow)get_store().find_element_user(ROW$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(row);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "row" element
     */
    public com.gazoomobile.mxalm.TRow insertNewRow(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TRow target = null;
            target = (com.gazoomobile.mxalm.TRow)get_store().insert_element_user(ROW$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "row" element
     */
    public com.gazoomobile.mxalm.TRow addNewRow()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TRow target = null;
            target = (com.gazoomobile.mxalm.TRow)get_store().add_element_user(ROW$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "row" element
     */
    public void removeRow(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ROW$0, i);
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
