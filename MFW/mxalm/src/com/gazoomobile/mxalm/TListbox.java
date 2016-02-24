/*
 * XML Type:  T_listbox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TListbox
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm;


/**
 * An XML T_listbox(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public interface TListbox extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TListbox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s33EF03A008E8C44605A221BAABC834E4").resolveHandle("tlistboxf5bbtype");
    
    /**
     * Gets array of all "option" elements
     */
    com.gazoomobile.mxalm.TOption[] getOptionArray();
    
    /**
     * Gets ith "option" element
     */
    com.gazoomobile.mxalm.TOption getOptionArray(int i);
    
    /**
     * Returns number of "option" element
     */
    int sizeOfOptionArray();
    
    /**
     * Sets array of all "option" element
     */
    void setOptionArray(com.gazoomobile.mxalm.TOption[] optionArray);
    
    /**
     * Sets ith "option" element
     */
    void setOptionArray(int i, com.gazoomobile.mxalm.TOption option);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "option" element
     */
    com.gazoomobile.mxalm.TOption insertNewOption(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "option" element
     */
    com.gazoomobile.mxalm.TOption addNewOption();
    
    /**
     * Removes the ith "option" element
     */
    void removeOption(int i);
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.gazoomobile.mxalm.TListbox newInstance() {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.gazoomobile.mxalm.TListbox parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.gazoomobile.mxalm.TListbox parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.gazoomobile.mxalm.TListbox parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.TListbox parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.TListbox parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.TListbox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}