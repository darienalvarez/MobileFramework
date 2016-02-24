/*
 * XML Type:  T_combobox
 * Namespace: http://www.gazoomobile.com/mxalm
 * Java type: com.gazoomobile.mxalm.TCombobox
 *
 * Automatically generated - do not modify.
 */
package com.gazoomobile.mxalm;


/**
 * An XML T_combobox(@http://www.gazoomobile.com/mxalm).
 *
 * This is a complex type.
 */
public interface TCombobox extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TCombobox.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s33EF03A008E8C44605A221BAABC834E4").resolveHandle("tcombobox5fc3type");
    
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
     * Gets the "style" attribute
     */
    com.gazoomobile.mxalm.TCombobox.Style.Enum getStyle();
    
    /**
     * Gets (as xml) the "style" attribute
     */
    com.gazoomobile.mxalm.TCombobox.Style xgetStyle();
    
    /**
     * True if has "style" attribute
     */
    boolean isSetStyle();
    
    /**
     * Sets the "style" attribute
     */
    void setStyle(com.gazoomobile.mxalm.TCombobox.Style.Enum style);
    
    /**
     * Sets (as xml) the "style" attribute
     */
    void xsetStyle(com.gazoomobile.mxalm.TCombobox.Style style);
    
    /**
     * Unsets the "style" attribute
     */
    void unsetStyle();
    
    /**
     * Gets the "selected" attribute
     */
    java.lang.String getSelected();
    
    /**
     * Gets (as xml) the "selected" attribute
     */
    org.apache.xmlbeans.XmlString xgetSelected();
    
    /**
     * Sets the "selected" attribute
     */
    void setSelected(java.lang.String selected);
    
    /**
     * Sets (as xml) the "selected" attribute
     */
    void xsetSelected(org.apache.xmlbeans.XmlString selected);
    
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
     * An XML style(@).
     *
     * This is an atomic type that is a restriction of com.gazoomobile.mxalm.TCombobox$Style.
     */
    public interface Style extends org.apache.xmlbeans.XmlString
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Style.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s33EF03A008E8C44605A221BAABC834E4").resolveHandle("stylea31cattrtype");
        
        org.apache.xmlbeans.StringEnumAbstractBase enumValue();
        void set(org.apache.xmlbeans.StringEnumAbstractBase e);
        
        static final Enum RADIO = Enum.forString("radio");
        static final Enum COMBO = Enum.forString("combo");
        
        static final int INT_RADIO = Enum.INT_RADIO;
        static final int INT_COMBO = Enum.INT_COMBO;
        
        /**
         * Enumeration value class for com.gazoomobile.mxalm.TCombobox$Style.
         * These enum values can be used as follows:
         * <pre>
         * enum.toString(); // returns the string value of the enum
         * enum.intValue(); // returns an int value, useful for switches
         * // e.g., case Enum.INT_RADIO
         * Enum.forString(s); // returns the enum value for a string
         * Enum.forInt(i); // returns the enum value for an int
         * </pre>
         * Enumeration objects are immutable singleton objects that
         * can be compared using == object equality. They have no
         * public constructor. See the constants defined within this
         * class for all the valid values.
         */
        static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
        {
            /**
             * Returns the enum value for a string, or null if none.
             */
            public static Enum forString(java.lang.String s)
                { return (Enum)table.forString(s); }
            /**
             * Returns the enum value corresponding to an int, or null if none.
             */
            public static Enum forInt(int i)
                { return (Enum)table.forInt(i); }
            
            private Enum(java.lang.String s, int i)
                { super(s, i); }
            
            static final int INT_RADIO = 1;
            static final int INT_COMBO = 2;
            
            public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
                new org.apache.xmlbeans.StringEnumAbstractBase.Table
            (
                new Enum[]
                {
                    new Enum("radio", INT_RADIO),
                    new Enum("combo", INT_COMBO),
                }
            );
            private static final long serialVersionUID = 1L;
            private java.lang.Object readResolve() { return forInt(intValue()); } 
        }
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.gazoomobile.mxalm.TCombobox.Style newValue(java.lang.Object obj) {
              return (com.gazoomobile.mxalm.TCombobox.Style) type.newValue( obj ); }
            
            public static com.gazoomobile.mxalm.TCombobox.Style newInstance() {
              return (com.gazoomobile.mxalm.TCombobox.Style) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.gazoomobile.mxalm.TCombobox.Style newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.gazoomobile.mxalm.TCombobox.Style) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.gazoomobile.mxalm.TCombobox newInstance() {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.gazoomobile.mxalm.TCombobox parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.gazoomobile.mxalm.TCombobox parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.TCombobox parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.gazoomobile.mxalm.TCombobox parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.gazoomobile.mxalm.TCombobox) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
