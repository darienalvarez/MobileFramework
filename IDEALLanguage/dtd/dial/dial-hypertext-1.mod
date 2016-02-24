<!-- ..................................................................... -->
<!-- DIAL Hypertext Module  .............................................. -->
<!-- file: dial-hypertext-1.mod .......................................... -->

<!-- Hypertext

        href and hreftype attribute
     
-->

<!ENTITY % DIAL.a.element  "INCLUDE" >
<![%DIAL.a.element;[
<!ENTITY % DIAL.a.content  "( #PCDATA | %Text.class;)*" >
<!ELEMENT %DIAL.a.qname;  %DIAL.a.content; >
<!-- end of a.element -->]]>

<!ENTITY % DIAL.a.extra.attributes  "" >
<!ENTITY % DIAL.a.attlist  "INCLUDE" >
<![%DIAL.a.attlist;[
<!ATTLIST %DIAL.a.qname;
	%DIAL.rel.attrib;
	%DIAL.rev.attrib;
	%hypertext.attrib;
	%embedding.attrib;
	%Common.attrib;	
	%DIAL.a.extra.attributes;
>
<!-- end of a.attlist -->]]>

<!-- end of dial-hypertext-1.mod -->
