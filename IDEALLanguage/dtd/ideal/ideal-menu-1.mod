<!-- ..................................................................... -->
<!-- IDEAL Menu Module  ........................................ -->
<!-- file: ideal-menu-1.mod ............................................. -->

<!-- Embedded Menu  -->

<!-- datefield: Menu ................... -->

<!ENTITY % IDEAL.menu.element  "INCLUDE" >
<![%IDEAL.menu.element;[

<!ELEMENT %IDEAL.menu.qname;  %DIAL.nl.content; >
<!-- end of ideal.menu.element -->]]>

<!ENTITY % IDEAL.menu.attlist  "INCLUDE" >
<![%IDEAL.menu.attlist;[
<!ATTLIST %IDEAL.menu.qname;
 	  %Common.attrib;
      %DIAL.src.qname;          %URI.datatype;           #IMPLIED
      %DIAL.extra.repeat.attrib;
      %DIAL.extra.bind.attrib;
      %IDEAL.xmlns.extra.attrib;             
>
<!-- end of ideal.menu.attlist -->]]>

<!-- end of ideal-menu-1.mod -->
