/*
 * XML Type:  T_windows
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TWindows
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm.impl;
/**
 * An XML T_windows(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public class TWindowsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.gazoomobile.mxalm.TWindows
{
    private static final long serialVersionUID = 1L;
    
    public TWindowsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORM$0 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "form");
    private static final javax.xml.namespace.QName COMBOBOX$2 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "combobox");
    private static final javax.xml.namespace.QName LISTBOX$4 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "listbox");
    private static final javax.xml.namespace.QName CHECKBOX$6 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "checkbox");
    private static final javax.xml.namespace.QName BUTTON$8 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "button");
    private static final javax.xml.namespace.QName EDIT$10 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "edit");
    private static final javax.xml.namespace.QName LABEL$12 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "label");
    private static final javax.xml.namespace.QName TEXTBOX$14 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "textbox");
    private static final javax.xml.namespace.QName LINKBUTTON$16 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "linkbutton");
    private static final javax.xml.namespace.QName VERTICALLAYOUT$18 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "verticallayout");
    private static final javax.xml.namespace.QName HORIZONTALLAYOUT$20 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "horizontallayout");
    private static final javax.xml.namespace.QName TABLE$22 = 
        new javax.xml.namespace.QName("http://www.gazoomobile.com/mxalm", "table");
    private static final javax.xml.namespace.QName ID$24 = 
        new javax.xml.namespace.QName("", "id");
    private static final javax.xml.namespace.QName BACKGROUNDCOLOR$26 = 
        new javax.xml.namespace.QName("", "background-color");
    
    
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
    
    /**
     * Gets the "combobox" element
     */
    public com.gazoomobile.mxalm.TCombobox getCombobox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCombobox target = null;
            target = (com.gazoomobile.mxalm.TCombobox)get_store().find_element_user(COMBOBOX$2, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "combobox" element
     */
    public void setCombobox(com.gazoomobile.mxalm.TCombobox combobox)
    {
        generatedSetterHelperImpl(combobox, COMBOBOX$2, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "combobox" element
     */
    public com.gazoomobile.mxalm.TCombobox addNewCombobox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCombobox target = null;
            target = (com.gazoomobile.mxalm.TCombobox)get_store().add_element_user(COMBOBOX$2);
            return target;
        }
    }
    
    /**
     * Gets the "listbox" element
     */
    public com.gazoomobile.mxalm.TListbox getListbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TListbox target = null;
            target = (com.gazoomobile.mxalm.TListbox)get_store().find_element_user(LISTBOX$4, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "listbox" element
     */
    public void setListbox(com.gazoomobile.mxalm.TListbox listbox)
    {
        generatedSetterHelperImpl(listbox, LISTBOX$4, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "listbox" element
     */
    public com.gazoomobile.mxalm.TListbox addNewListbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TListbox target = null;
            target = (com.gazoomobile.mxalm.TListbox)get_store().add_element_user(LISTBOX$4);
            return target;
        }
    }
    
    /**
     * Gets the "checkbox" element
     */
    public com.gazoomobile.mxalm.TCheckbox getCheckbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCheckbox target = null;
            target = (com.gazoomobile.mxalm.TCheckbox)get_store().find_element_user(CHECKBOX$6, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkbox" element
     */
    public void setCheckbox(com.gazoomobile.mxalm.TCheckbox checkbox)
    {
        generatedSetterHelperImpl(checkbox, CHECKBOX$6, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "checkbox" element
     */
    public com.gazoomobile.mxalm.TCheckbox addNewCheckbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TCheckbox target = null;
            target = (com.gazoomobile.mxalm.TCheckbox)get_store().add_element_user(CHECKBOX$6);
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
            target = (com.gazoomobile.mxalm.TButton)get_store().find_element_user(BUTTON$8, 0);
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
        generatedSetterHelperImpl(button, BUTTON$8, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TButton)get_store().add_element_user(BUTTON$8);
            return target;
        }
    }
    
    /**
     * Gets the "edit" element
     */
    public com.gazoomobile.mxalm.TEdit getEdit()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TEdit target = null;
            target = (com.gazoomobile.mxalm.TEdit)get_store().find_element_user(EDIT$10, 0);
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
        generatedSetterHelperImpl(edit, EDIT$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TEdit)get_store().add_element_user(EDIT$10);
            return target;
        }
    }
    
    /**
     * Gets the "label" element
     */
    public com.gazoomobile.mxalm.TLabel getLabel()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLabel target = null;
            target = (com.gazoomobile.mxalm.TLabel)get_store().find_element_user(LABEL$12, 0);
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
        generatedSetterHelperImpl(label, LABEL$12, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TLabel)get_store().add_element_user(LABEL$12);
            return target;
        }
    }
    
    /**
     * Gets the "textbox" element
     */
    public com.gazoomobile.mxalm.TTextbox getTextbox()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTextbox target = null;
            target = (com.gazoomobile.mxalm.TTextbox)get_store().find_element_user(TEXTBOX$14, 0);
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
        generatedSetterHelperImpl(textbox, TEXTBOX$14, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TTextbox)get_store().add_element_user(TEXTBOX$14);
            return target;
        }
    }
    
    /**
     * Gets the "linkbutton" element
     */
    public com.gazoomobile.mxalm.TLinkbutton getLinkbutton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLinkbutton target = null;
            target = (com.gazoomobile.mxalm.TLinkbutton)get_store().find_element_user(LINKBUTTON$16, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "linkbutton" element
     */
    public void setLinkbutton(com.gazoomobile.mxalm.TLinkbutton linkbutton)
    {
        generatedSetterHelperImpl(linkbutton, LINKBUTTON$16, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "linkbutton" element
     */
    public com.gazoomobile.mxalm.TLinkbutton addNewLinkbutton()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TLinkbutton target = null;
            target = (com.gazoomobile.mxalm.TLinkbutton)get_store().add_element_user(LINKBUTTON$16);
            return target;
        }
    }
    
    /**
     * Gets the "verticallayout" element
     */
    public com.gazoomobile.mxalm.TVerticallayout getVerticallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TVerticallayout target = null;
            target = (com.gazoomobile.mxalm.TVerticallayout)get_store().find_element_user(VERTICALLAYOUT$18, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "verticallayout" element
     */
    public void setVerticallayout(com.gazoomobile.mxalm.TVerticallayout verticallayout)
    {
        generatedSetterHelperImpl(verticallayout, VERTICALLAYOUT$18, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "verticallayout" element
     */
    public com.gazoomobile.mxalm.TVerticallayout addNewVerticallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TVerticallayout target = null;
            target = (com.gazoomobile.mxalm.TVerticallayout)get_store().add_element_user(VERTICALLAYOUT$18);
            return target;
        }
    }
    
    /**
     * Gets the "horizontallayout" element
     */
    public com.gazoomobile.mxalm.THorizontallayout getHorizontallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.THorizontallayout target = null;
            target = (com.gazoomobile.mxalm.THorizontallayout)get_store().find_element_user(HORIZONTALLAYOUT$20, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "horizontallayout" element
     */
    public void setHorizontallayout(com.gazoomobile.mxalm.THorizontallayout horizontallayout)
    {
        generatedSetterHelperImpl(horizontallayout, HORIZONTALLAYOUT$20, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "horizontallayout" element
     */
    public com.gazoomobile.mxalm.THorizontallayout addNewHorizontallayout()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.THorizontallayout target = null;
            target = (com.gazoomobile.mxalm.THorizontallayout)get_store().add_element_user(HORIZONTALLAYOUT$20);
            return target;
        }
    }
    
    /**
     * Gets the "table" element
     */
    public com.gazoomobile.mxalm.TTable getTable()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.gazoomobile.mxalm.TTable target = null;
            target = (com.gazoomobile.mxalm.TTable)get_store().find_element_user(TABLE$22, 0);
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
        generatedSetterHelperImpl(table, TABLE$22, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
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
            target = (com.gazoomobile.mxalm.TTable)get_store().add_element_user(TABLE$22);
            return target;
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$24);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$24);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$24);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$24);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ID$24);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ID$24);
            }
            target.set(id);
        }
    }
    
    /**
     * Gets the "background-color" attribute
     */
    public java.lang.String getBackgroundColor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BACKGROUNDCOLOR$26);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "background-color" attribute
     */
    public org.apache.xmlbeans.XmlString xgetBackgroundColor()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BACKGROUNDCOLOR$26);
            return target;
        }
    }
    
    /**
     * Sets the "background-color" attribute
     */
    public void setBackgroundColor(java.lang.String backgroundColor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(BACKGROUNDCOLOR$26);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(BACKGROUNDCOLOR$26);
            }
            target.setStringValue(backgroundColor);
        }
    }
    
    /**
     * Sets (as xml) the "background-color" attribute
     */
    public void xsetBackgroundColor(org.apache.xmlbeans.XmlString backgroundColor)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(BACKGROUNDCOLOR$26);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(BACKGROUNDCOLOR$26);
            }
            target.set(backgroundColor);
        }
    }
}
