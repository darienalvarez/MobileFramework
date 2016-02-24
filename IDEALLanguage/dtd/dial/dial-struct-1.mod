<!-- ...................................................................... -->
<!-- Dial Structure Module  ....................................... -->
<!-- file: dial-struct-1.mod

 -->

<!-- Block Structural
        div, section, h, p, separator
     This module declares the elements and their attributes used to
     support block-level structural markup.
-->

<!ENTITY % DIAL.div.extra "" >
<!ENTITY % div.element  "INCLUDE" >
<![%div.element;[
<!ENTITY % div.content
     "( (%DIAL.h.qname;)? , (	%DIAL.object.qname; | 
     				%DIAL.span.qname; | 
     				%DIAL.p.qname; | 
     				%DIAL.table.qname; | 
     				%DIAL.ul.qname; | 
     				%DIAL.ol.qname; | 
     				%DIAL.dl.qname; | 
     				%DIAL.nl.qname; |
     				%DIAL.NavigationList.class; |
     				%DIAL.List.class; |
     				%XForms.Controls.class; 
     				%DIAL.div.extra;
     				)* )"
>
<!ELEMENT %DIAL.div.qname;  %div.content; >
<!-- end of div.element -->]]>

<!ENTITY % DIAL.div.extra.attributes  "" >
<!ENTITY % div.attlist  "INCLUDE" >
<![%div.attlist;[
<!ATTLIST %DIAL.div.qname;
	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
      	%DIAL.div.extra.attributes;
>
<!-- end of div.attlist -->]]>

<!ENTITY % section.element  "INCLUDE" >
<![%section.element;[
<!ENTITY % section.content  " ( %DIAL.h.qname;?, ( %DIAL.section.qname; | %DIAL.div.qname; |  %DIAL.p.qname; | %DIAL.separator.qname;  %DIAL.section.extra; )* ) " >
<!ELEMENT %DIAL.section.qname;  %section.content; >
<!-- end of section.element -->]]>

<!ENTITY % section.attlist  "INCLUDE" >
<![%section.attlist;[
<!ATTLIST %DIAL.section.qname;
      %Common.attrib;
      %embedding.attrib;
      %hypertext.attrib;
>
<!-- end of section.attlist -->]]>



<!ENTITY % h.element  "INCLUDE" >
<![%h.element;[
<!ENTITY % h.content
     "(#PCDATA | %Text.class; | %XForms.UIInline.class;)*" >
<!ELEMENT %DIAL.h.qname;  %h.content; >
<!-- end of h.element -->]]>

<!ENTITY % h.attlist  "INCLUDE" >
<![%h.attlist;[
<!ATTLIST %DIAL.h.qname;
      %Common.attrib;
      %embedding.attrib;
      %hypertext.attrib;
>
<!-- end of h.attlist -->]]>


<!ENTITY % p.element  "INCLUDE" >
<![%p.element;[
<!ENTITY % p.content
     "(#PCDATA | %Text.class; | %DIAL.table.qname; | %DIAL.ul.qname; | %DIAL.ol.qname; | %XForms.UIInline.class; | %DIAL.dl.qname; )*" >
<!ELEMENT %DIAL.p.qname;  %p.content; >
<!-- end of p.element -->]]>

<!ENTITY % DIAL.p.extra.attributes  "" >
<!ENTITY % p.attlist  "INCLUDE" >
<![%p.attlist;[
<!ATTLIST %DIAL.p.qname;
      %Common.attrib;
      %embedding.attrib;
      %hypertext.attrib;
      %DIAL.p.extra.attributes;
>
<!-- end of p.attlist -->]]>

<!-- separator: generic break .................... -->

<!ENTITY % separator.element  "INCLUDE" >
<![%separator.element;[
<!ENTITY % separator.content  "EMPTY" >
<!ENTITY % DIAL.separator.qname  "separator" >
<!ELEMENT %DIAL.separator.qname;  %separator.content; >

<!-- end of separator.element -->]]>

<!ENTITY % separator.attlist  "INCLUDE" >
<![%separator.attlist;[
<!ATTLIST %DIAL.separator.qname;
	%Common.attrib;
	%DISelect.Common.attributes;
      	%embedding.attrib;
>
<!-- end of separator.attlist -->]]>

<!-- end of dial-struct-1.mod -->
