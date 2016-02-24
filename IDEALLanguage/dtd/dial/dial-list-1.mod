<!-- ..................................................................... -->
<!-- DIAL Lists Module  .................................................. -->
<!-- file: dial-list-1.mod  .............................................. -->

<!-- Lists

        dl, dt, dd, nl, ol, ul, li

     This module declares the list-oriented element types
     and their attributes.
-->


<!-- li: List Item ..................................... -->

<!ENTITY % DIAL.li.element  "INCLUDE" >
<![%DIAL.li.element;[
<!ENTITY % DIAL.li.content
     "(#PCDATA | %Text.class; | %XForms.UIInline.class;)* "
>
<!ELEMENT %DIAL.li.qname;  %DIAL.li.content; >
<!-- end of li.element -->]]>

<!ENTITY % DIAL.li.extra.attributes  "" >
<!ENTITY % DIAL.li.attlist  "INCLUDE" >
<![%DIAL.li.attlist;[
<!ATTLIST %DIAL.li.qname;
      %Common.attrib;
      %embedding.attrib;
      %hypertext.attrib;
      %DIAL.extra.misc.attrib;
      %DIAL.extra.repeat.attrib;
      %DIAL.extra.bind.attrib;      
      %DIAL.li.extra.attributes;
>
<!-- end of li.attlist -->]]>

<!-- ol: Ordered List (numbered styles) ................ -->

<!ENTITY % DIAL.ol.element  "INCLUDE" >
<![%DIAL.ol.element;[
<!ENTITY % DIAL.ol.content  "(%DIAL.label.qname;? ,(%DIAL.li.qname;)*)" >
<!ELEMENT %DIAL.ol.qname;  %DIAL.ol.content; >
<!-- end of ol.element -->]]>

<!ENTITY % DIAL.ol.extra.attributes  "" >
<!ENTITY % DIAL.ol.attlist  "INCLUDE" >
<![%DIAL.ol.attlist;[
<!ATTLIST %DIAL.ol.qname;
      	%Common.attrib;
  	%embedding.attrib;
	%hypertext.attrib;
	%DIAL.extra.repeat.attrib;    
	%DIAL.ol.extra.attributes;
>
<!-- end of ol.attlist -->]]>


<!-- ul: Unordered List (bullet styles) ................ -->

<!ENTITY % DIAL.ul.element  "INCLUDE" >
<![%DIAL.ul.element;[
<!ENTITY % DIAL.ul.content  "(%DIAL.label.qname;? ,(%DIAL.li.qname;)*)" >
<!ELEMENT %DIAL.ul.qname;  %DIAL.ul.content; >
<!-- end of ul.element -->]]>

<!ENTITY % DIAL.ul.extra.attributes  "" >
<!ENTITY % DIAL.ul.attlist  "INCLUDE" >
<![%DIAL.ul.attlist;[
<!ATTLIST %DIAL.ul.qname;
   	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
   	%DIAL.extra.repeat.attrib;      
   	%DIAL.ul.extra.attributes;
>
<!-- end of ul.attlist -->]]>

<!-- dl: Definition List ............................... -->

<!ENTITY % DIAL.dl.element  "INCLUDE" >
<![%DIAL.dl.element;[
<!ENTITY % DIAL.dl.content  "(%DIAL.label.qname;? ,  ( %DIAL.di.qname;)*)" >
<!ELEMENT %DIAL.dl.qname;  %DIAL.dl.content; >
<!-- end of dl.element -->]]>

<!ENTITY % DIAL.dl.attlist  "INCLUDE" >
<![%DIAL.dl.attlist;[
<!ATTLIST %DIAL.dl.qname;
	%Common.attrib;       
	%embedding.attrib;
	%hypertext.attrib;
>
<!-- end of dl.attlist -->]]>

<!-- dt: Definition Item ............................... -->

<!ENTITY % DIAL.di.element  "INCLUDE" >
<![%DIAL.di.element;[
<!ENTITY % DIAL.di.content
     "( %DIAL.dt.qname; , %DIAL.dd.qname; )"
>
<!ELEMENT %DIAL.di.qname;  %DIAL.di.content; >
<!-- end of di.element -->]]>

<!ENTITY % DIAL.di.attlist  "INCLUDE" >
<![%DIAL.di.attlist;[
<!ATTLIST %DIAL.di.qname;
	%Common.attrib;
	%hypertext.attrib;
>
<!-- end of di.attlist -->]]>

<!-- dt: Definition Term ............................... -->

<!ENTITY % DIAL.dt.element  "INCLUDE" >
<![%DIAL.dt.element;[
<!ENTITY % DIAL.dt.content
     "(#PCDATA | %Text.class;| %XForms.UIInline.class;)* "
>
<!ELEMENT %DIAL.dt.qname;  %DIAL.dt.content; >
<!-- end of dt.element -->]]>

<!ENTITY % DIAL.dt.attlist  "INCLUDE" >
<![%DIAL.dt.attlist;[
<!ATTLIST %DIAL.dt.qname;
	%Common.attrib;
	%hypertext.attrib;
      
>
<!-- end of dt.attlist -->]]>

<!-- dd: Definition Description ........................ -->

<!ENTITY % DIAL.dd.element  "INCLUDE" >
<![%DIAL.dd.element;[
<!ENTITY % DIAL.dd.content
          "( #PCDATA | %Text.class; | %XForms.UIInline.class;)*"
>
<!ELEMENT %DIAL.dd.qname;  %DIAL.dd.content; >
<!-- end of dd.element -->]]>

<!ENTITY % DIAL.dd.attlist  "INCLUDE" >
<![%DIAL.dd.attlist;[
<!ATTLIST %DIAL.dd.qname;
	%Common.attrib;
	%hypertext.attrib;
>
<!-- end of dd.attlist -->]]>



<!-- nl: Navigation List styles) ................ -->

<!ENTITY % DIAL.nl.element  "INCLUDE" >
<![%DIAL.nl.element;[
<!ENTITY % DIAL.nl.content  "( %DIAL.label.qname;? , (%DIAL.li.qname;)* )" >
<!ELEMENT %DIAL.nl.qname;  %DIAL.nl.content; >
<!-- end of nl.element -->]]>

<!ENTITY % DIAL.nl.extra.attributes  "" >
<!ENTITY % DIAL.nl.attlist  "INCLUDE" >
<![%DIAL.nl.attlist;[
<!ATTLIST %DIAL.nl.qname;
      	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
      	%DIAL.extra.repeat.attrib;    
    	%DIAL.extra.bind.attrib;             
    	%DIAL.nl.extra.attributes;
>
<!-- end of nl.attlist -->]]>

<!-- label) ................ -->
<!ENTITY % DIAL.label.element  "INCLUDE" >
<![%DIAL.label.element;[
<!ENTITY % DIAL.label.content  "(#PCDATA)" >
<!ELEMENT %DIAL.label.qname;  %DIAL.label.content; >
<!-- end of label.element -->]]>

<!ENTITY % DIAL.label.attlist  "INCLUDE" >
<![%DIAL.label.attlist;[
<!ATTLIST %DIAL.label.qname;
      	%Common.attrib;
>
<!-- end of nl.attlist -->]]>

<!-- end of dial-list-1.mod -->
