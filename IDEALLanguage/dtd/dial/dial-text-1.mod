<!-- ....................................................................... -->
<!-- DIAL Text Module    ......................................... -->
<!-- file: dial-text-1.mod   ........................................... -->

<!-- Text

        abbr, cite, code, dfn, em, kbd, q, samp, span, strong, sub, sup, var

     This module declares the elements and their attributes used in Text module
-->

<!ENTITY % abbr.element  "INCLUDE" >
<![%abbr.element;[
<!ENTITY % abbr.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.abbr.qname;  %abbr.content; >
<!-- end of abbr.element -->]]>

<!ENTITY % abbr.attlist  "INCLUDE" >
<![%abbr.attlist;[
<!ATTLIST %DIAL.abbr.qname;
      %Common.attrib;
      %DIAL.title.attrib;
      %DIAL.full.attrib; 
>
<!-- end of abbr.attlist -->]]>


<!ENTITY % cite.element  "INCLUDE" >
<![%cite.element;[
<!ENTITY % cite.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.cite.qname;  %cite.content; >
<!-- end of cite.element -->]]>

<!ENTITY % cite.attlist  "INCLUDE" >
<![%cite.attlist;[
<!ATTLIST %DIAL.cite.qname;
      %Common.attrib;
      cite         %URI.datatype;           #IMPLIED      
>
<!-- end of cite.attlist -->]]>

<!ENTITY % code.element  "INCLUDE" >
<![%code.element;[
<!ENTITY % code.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.code.qname;  %code.content; >
<!-- end of code.element -->]]>

<!ENTITY % code.attlist  "INCLUDE" >
<![%code.attlist;[
<!ATTLIST %DIAL.code.qname;
      %Common.attrib;
>
<!-- end of code.attlist -->]]>

<!ENTITY % dfn.element  "INCLUDE" >
<![%dfn.element;[
<!ENTITY % dfn.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.dfn.qname;  %dfn.content; >
<!-- end of dfn.element -->]]>

<!ENTITY % dfn.attlist  "INCLUDE" >
<![%dfn.attlist;[
<!ATTLIST %DIAL.dfn.qname;
      %Common.attrib;
>
<!-- end of dfn.attlist -->]]>

<!ENTITY % em.element  "INCLUDE" >
<![%em.element;[
<!ENTITY % em.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.em.qname;  %em.content; >
<!-- end of em.element -->]]>

<!ENTITY % em.attlist  "INCLUDE" >
<![%em.attlist;[
<!ATTLIST %DIAL.em.qname;
      %Common.attrib;
>
<!-- end of em.attlist -->]]>

<!ENTITY % kbd.element  "INCLUDE" >
<![%kbd.element;[
<!ENTITY % kbd.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.kbd.qname;  %kbd.content; >
<!-- end of kbd.element -->]]>

<!ENTITY % kbd.attlist  "INCLUDE" >
<![%kbd.attlist;[
<!ATTLIST %DIAL.kbd.qname;
      %Common.attrib;
>
<!-- end of kbd.attlist -->]]>

<!ENTITY % l.element  "INCLUDE" >
<![%l.element;[
<!ENTITY % l.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.l.qname;  %l.content; >
<!-- end of l.element -->]]>

<!ENTITY % l.attlist  "INCLUDE" >
<![%l.attlist;[
<!ATTLIST %DIAL.l.qname;
      %Common.attrib;
>
<!-- end of l.attlist -->]]>

<!ENTITY % q.element  "INCLUDE" >
<![%q.element;[
<!ENTITY % q.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.q.qname;  %q.content; >
<!-- end of q.element -->]]>

<!ENTITY % q.attlist  "INCLUDE" >
<![%q.attlist;[
<!ATTLIST %DIAL.q.qname;
      %Common.attrib;
      cite         %URI.datatype;           #IMPLIED
>
<!-- end of quote.attlist -->]]>

<!ENTITY % samp.element  "INCLUDE" >
<![%samp.element;[
<!ENTITY % samp.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.samp.qname;  %samp.content; >
<!-- end of samp.element -->]]>

<!ENTITY % samp.attlist  "INCLUDE" >
<![%samp.attlist;[
<!ATTLIST %DIAL.samp.qname;
      %Common.attrib;
>
<!-- end of samp.attlist -->]]>

<!ENTITY % DIAL.span.element  "INCLUDE" >
<![%DIAL.span.element;[
<!ENTITY % DIAL.span.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.span.qname;  %DIAL.span.content; >
<!-- end of span.element -->]]>

<!ENTITY % DIAL.span.extra.attributes  "" >
<!ENTITY % DIAL.span.attlist  "INCLUDE" >
<![%DIAL.span.attlist;[
<!ATTLIST %DIAL.span.qname;
	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
	%DIAL.span.extra.attributes;
>
<!-- end of span.attlist -->]]>

<!ENTITY % strong.element  "INCLUDE" >
<![%strong.element;[
<!ENTITY % strong.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.strong.qname;  %strong.content; >
<!-- end of strong.element -->]]>

<!ENTITY % strong.attlist  "INCLUDE" >
<![%strong.attlist;[
<!ATTLIST %DIAL.strong.qname;
      %Common.attrib;
>
<!-- end of strong.attlist -->]]>

<!ENTITY % sub.element  "INCLUDE" >
<![%sub.element;[
<!ENTITY % sub.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.sub.qname;  %sub.content; >
<!-- end of sub.element -->]]>

<!ENTITY % sub.attlist  "INCLUDE" >
<![%sub.attlist;[
<!ATTLIST %DIAL.sub.qname;
      %Common.attrib;
>
<!-- end of sub.attlist -->]]>

<!ENTITY % sup.element  "INCLUDE" >
<![%sup.element;[
<!ENTITY % sup.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.sup.qname;  %sup.content; >
<!-- end of sup.element -->]]>

<!ENTITY % sup.attlist  "INCLUDE" >
<![%sup.attlist;[
<!ATTLIST %DIAL.sup.qname;
      %Common.attrib;
>
<!-- end of sup.attlist -->]]>

<!ENTITY % var.element  "INCLUDE" >
<![%var.element;[
<!ENTITY % var.content
     "( #PCDATA )"
>
<!ELEMENT %DIAL.var.qname;  %var.content; >
<!-- end of var.element -->]]>

<!ENTITY % var.attlist  "INCLUDE" >
<![%var.attlist;[
<!ATTLIST %DIAL.var.qname;
      %Common.attrib;
>
<!-- end of var.attlist -->]]>

<!-- end of dial-text-1.mod -->
