<!-- ...................................................................... -->
<!-- Selection Attributes Qname Module ............................................... -->
<!-- file: selection-attribs-qname-1.mod

     xmlns:sel="http://www.w3.org/2005/sel"
     ...................................................................... -->

<!-- Declare the default value for prefixing of this module's elements -->
<!-- Note that the NS.prefixed will get overridden by the XHTML Framework or
     by a document instance. -->

<!ENTITY % SELATTRIBUTES.prefixed "%NS.prefixed;" >

<!-- Declare the actual namespace of this module -->
<!ENTITY % selection.xmlns "http://www.w3.org/2005/sel" >

<!-- Declare the default prefix for this module -->
<!ENTITY % SELATTRIBUTES.prefix "sel" >

<!-- Declare the prefix and any prefixed namespaces that are required by 
     this module -->
<![%SELATTRIBUTES.prefixed;[
<!ENTITY % selection.pfx "%SELATTRIBUTES.prefix;:" >
<!ENTITY % selection.xmlns.extra.attrib
    "xmlns:%SELATTRIBUTES.prefix;   %URI.datatype;  #FIXED  '%selection.xmlns;'" >
]]>
<!ENTITY % selection.pfx "" >
<!ENTITY % selection.xmlns.extra.attrib "" >

<!-- Define the xmlns extension attributes -->
<!ENTITY % XHTML.xmlns.extra.attrib
         "%selection.xmlns.extra.attrib;" >