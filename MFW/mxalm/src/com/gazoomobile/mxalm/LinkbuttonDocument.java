/*
 * An XML document type.
 * Localname: linkbutton
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.LinkbuttonDocument
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm;


/**
 * A document containing one linkbutton(@http://www.gazoomobile.com/mxalm) element.
 *
 * This is a complex type.
 */
public interface LinkbuttonDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LinkbuttonDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s33EF03A008E8C44605A221BAABC834E4").resolveHandle("linkbutton318fdoctype");
    
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
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.gazoomobile.mxalm.LinkbuttonDocument newInstance() {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.LinkbuttonDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.LinkbuttonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
