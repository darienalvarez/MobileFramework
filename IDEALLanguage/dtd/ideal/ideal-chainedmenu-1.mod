<!-- ..................................................................... -->
<!-- IDEAL ChainedMenu Module  ........................................ -->
<!-- file: ideal-chainedmenu-1.mod ............................................. -->

<!-- Embedded ChainedMenu  -->

<!-- datefield: ChainedMenu ................... -->

<!ENTITY % IDEAL.chainedmenu.element  "INCLUDE" >
<![%IDEAL.chainedmenu.element;[
<!ENTITY % IDEAL.chainedmenu.content 
	"( (%DIAL.label.qname;)?, ( %DIAL.nl.qname; | %IDEAL.menu.qname;)+ )"
 >

<!ELEMENT %IDEAL.chainedmenu.qname;  %IDEAL.chainedmenu.content; >
<!-- end of ideal.chainedmenu.element -->]]>

<!ENTITY % IDEAL.chainedmenu.attlist  "INCLUDE" >
<![%IDEAL.chainedmenu.attlist;[
<!ATTLIST %IDEAL.chainedmenu.qname;
      		%Common.attrib;
      		%IDEAL.xmlns.extra.attrib;
>
<!-- end of ideal.chainedmenu.attlist -->]]>

<!-- end of ideal-chainedmenu-1.mod -->
