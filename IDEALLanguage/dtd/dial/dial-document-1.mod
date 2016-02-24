<!-- .................................................................... -->
<!-- DIAL Document Module  .............................................. -->
<!-- file: dial-document-1.mod........................................... -->

<!-- Document framework

        title, head, body, html

     The Structure Module defines the major structural elements and
     their attributes.

     Note that the content model of the head element type is redeclared
     when the Base Module is included in the DTD.

     The parameter entity containing the XML namespace URI value used
     for DIAl is '%DIAl.xmlns;', defined in the Qualified Names module.
-->

<!-- title: Document Title ............................. -->

<!-- The title element is not considered part of the flow of text.
     It should be displayed, for example as the page header or
     window title. Exactly one title is required per document.
-->

<!-- Define the global namespace attributes -->
<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.attrib
    "%NS.decl.attrib;"
>
]]>
<!ENTITY % DIAL.xmlns.attrib
	 "%NS.decl.attrib; 
	 xmlns	%URI.datatype;	#FIXED '%DIAL.xmlns;' "
>

<!ENTITY % title.element  "INCLUDE" >
<![%title.element;[
<!ENTITY % title.content  "( #PCDATA )" >
<!ENTITY % title.qname  "title" >
<!ELEMENT %title.qname;  %title.content; >
<!-- end of title.element -->]]>


<!ENTITY % DIAL.title.extra.attributes  "" >

<!ENTITY % title.attlist  "INCLUDE" >
<![%title.attlist;[
<!ATTLIST %title.qname;
      %DIAL.xmlns.attrib;
      %embedding.attrib;
      %DIAL.title.extra.attributes;
      %Common.attrib;
>
<!-- end of title.attlist -->]]>

<!-- head: Document Head ............................... -->

<!ENTITY % head.element  "INCLUDE" >
<![%head.element;[
<!ENTITY % head.content
    "( %title.qname;, ( %XHTML-ACCESS.access.qname; | %DIAL.handler.qname; | %link.qname; | %xml-events.listener.qname; | %XForms.model.qname; | %meta.qname;)* )"
>
<!ENTITY % head.qname  "head" >
<!ELEMENT %head.qname;  %head.content; >
<!-- end of head.element -->]]>

<!ENTITY % head.attlist  "INCLUDE" >
<![%head.attlist;[
<!-- reserved for future use with document profiles
-->
<!-- end of head.attlist -->]]>

<!-- body: Document Body ............................... -->

<!ENTITY % body.element  "INCLUDE" >
<![%body.element;[
<!ENTITY % body.content
     "( %DIAL.header.class; ( %DIAL.h.qname; )?, ( %DIAL.section.qname; | %DIAL.separator.qname; )* %DIAL.footer.class;)"
>
<!ENTITY % body.qname  "body" >
<!ELEMENT %body.qname;  %body.content; >
<!-- end of body.element -->]]>

<!ENTITY % body.attlist  "INCLUDE" >
<![%body.attlist;[
<!ATTLIST %body.qname;
      %Common.attrib;
>
<!-- end of body.attlist -->]]>

<!-- html: XHTML Document Element ...................... -->

<!ENTITY % html.element  "INCLUDE" >
<![%html.element;[
<!ENTITY % html.content  "( %head.qname; , %body.qname; )" >
<!ENTITY % html.qname  "html" >
<!ELEMENT %html.qname;  %html.content; >
<!-- end of html.element -->]]>



<!-- see the Qualified Names module for information
     on how to extend XHTML using XML namespaces
-->
<!ATTLIST %html.qname;
      %DIAL.xmlns.attrib;
      %DIAL.id.attrib;
>


<!-- end of dial-document-1.mod -->
