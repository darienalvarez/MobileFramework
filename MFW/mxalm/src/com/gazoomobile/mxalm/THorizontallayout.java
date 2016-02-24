/*
 * XML Type:  T_horizontallayout
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.THorizontallayout
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm;


/**
 * An XML T_horizontallayout(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public interface THorizontallayout extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(THorizontallayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s33EF03A008E8C44605A221BAABC834E4").resolveHandle("thorizontallayout8f12type");
    
    /**
     * Gets the "combobox" element
     */
    com.gazoomobile.mxalm.TCombobox getCombobox();
    
    /**
     * Sets the "combobox" element
     */
    void setCombobox(com.gazoomobile.mxalm.TCombobox combobox);
    
    /**
     * Appends and returns a new empty "combobox" element
     */
    com.gazoomobile.mxalm.TCombobox addNewCombobox();
    
    /**
     * Gets the "listbox" element
     */
    com.gazoomobile.mxalm.TListbox getListbox();
    
    /**
     * Sets the "listbox" element
     */
    void setListbox(com.gazoomobile.mxalm.TListbox listbox);
    
    /**
     * Appends and returns a new empty "listbox" element
     */
    com.gazoomobile.mxalm.TListbox addNewListbox();
    
    /**
     * Gets the "checkbox" element
     */
    com.gazoomobile.mxalm.TCheckbox getCheckbox();
    
    /**
     * Sets the "checkbox" element
     */
    void setCheckbox(com.gazoomobile.mxalm.TCheckbox checkbox);
    
    /**
     * Appends and returns a new empty "checkbox" element
     */
    com.gazoomobile.mxalm.TCheckbox addNewCheckbox();
    
    /**
     * Gets the "button" element
     */
    com.gazoomobile.mxalm.TButton getButton();
    
    /**
     * Sets the "button" element
     */
    void setButton(com.gazoomobile.mxalm.TButton button);
    
    /**
     * Appends and returns a new empty "button" element
     */
    com.gazoomobile.mxalm.TButton addNewButton();
    
    /**
     * Gets the "edit" element
     */
    com.gazoomobile.mxalm.TEdit getEdit();
    
    /**
     * Sets the "edit" element
     */
    void setEdit(com.gazoomobile.mxalm.TEdit edit);
    
    /**
     * Appends and returns a new empty "edit" element
     */
    com.gazoomobile.mxalm.TEdit addNewEdit();
    
    /**
     * Gets the "label" element
     */
    com.gazoomobile.mxalm.TLabel getLabel();
    
    /**
     * Sets the "label" element
     */
    void setLabel(com.gazoomobile.mxalm.TLabel label);
    
    /**
     * Appends and returns a new empty "label" element
     */
    com.gazoomobile.mxalm.TLabel addNewLabel();
    
    /**
     * Gets the "textbox" element
     */
    com.gazoomobile.mxalm.TTextbox getTextbox();
    
    /**
     * Sets the "textbox" element
     */
    void setTextbox(com.gazoomobile.mxalm.TTextbox textbox);
    
    /**
     * Appends and returns a new empty "textbox" element
     */
    com.gazoomobile.mxalm.TTextbox addNewTextbox();
    
    /**
     * Gets the "linkbutton" element
     */
    com.gazoomobile.mxalm.TLinkbutton getLinkbutton();
    
    /**
     * Sets the "linkbutton" element
     */
    void setLinkbutton(com.gazoomobile.mxalm.TLinkbutton linkbutton);
    
    /**
     * Appends and returns a new empty "linkbutton" element
     */
    com.gazoomobile.mxalm.TLinkbutton addNewLinkbutton();
    
    /**
     * Gets the "table" element
     */
    com.gazoomobile.mxalm.TTable getTable();
    
    /**
     * Sets the "table" element
     */
    void setTable(com.gazoomobile.mxalm.TTable table);
    
    /**
     * Appends and returns a new empty "table" element
     */
    com.gazoomobile.mxalm.TTable addNewTable();
    
    /**
     * Gets the "verticallayout" element
     */
    com.gazoomobile.mxalm.TVerticallayout getVerticallayout();
    
    /**
     * Sets the "verticallayout" element
     */
    void setVerticallayout(com.gazoomobile.mxalm.TVerticallayout verticallayout);
    
    /**
     * Appends and returns a new empty "verticallayout" element
     */
    com.gazoomobile.mxalm.TVerticallayout addNewVerticallayout();
    
    /**
     * Gets the "id" attribute
     */
    java.lang.String getId();
    
    /**
     * Gets (as xml) the "id" attribute
     */
    org.apache.xmlbeans.XmlString xgetId();
    
    /**
     * Sets the "id" attribute
     */
    void setId(java.lang.String id);
    
    /**
     * Sets (as xml) the "id" attribute
     */
    void xsetId(org.apache.xmlbeans.XmlString id);
    
    /**
     * Gets the "header" attribute
     */
    java.lang.String getHeader();
    
    /**
     * Gets (as xml) the "header" attribute
     */
    org.apache.xmlbeans.XmlString xgetHeader();
    
    /**
     * Sets the "header" attribute
     */
    void setHeader(java.lang.String header);
    
    /**
     * Sets (as xml) the "header" attribute
     */
    void xsetHeader(org.apache.xmlbeans.XmlString header);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.gazoomobile.mxalm.THorizontallayout newInstance() {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.gazoomobile.mxalm.THorizontallayout parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.THorizontallayout parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.THorizontallayout parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.THorizontallayout) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
