/*
 * An XML document type.
 * Localname: table
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TableDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * A document containing one table(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public class TableDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TableDocument
{
    private static final long serialVersionUID = 1L;
    
    public TableDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TABLE$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "table");
    
    
    /**
     * Gets the "table" element
     */
    public com.gazoomobile.mxalm.TTable getTable()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTable target = null;
            target = (com.gazoomobile.mxalm.TTable)get_store().find_element_user(TABLE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "table" element
     */
    public void setTable(com.gazoomobile.mxalm.TTable table)
    {
        generatedSetterHelperImpl(table, TABLE$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "table" element
     */
    public com.gazoomobile.mxalm.TTable addNewTable()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTable target = null;
            target = (com.gazoomobile.mxalm.TTable)get_store().add_element_user(TABLE$0);
            return target;
        }
    }
}
