<!-- ..................................................................... -->
<!-- DIAL Handler Module  .................................................. -->
<!-- file: dial-handler-1.mod  .............................................. -->



<!-- handler ............................... -->

<!ENTITY % DIAL.handler.element  "INCLUDE" >
<![%DIAL.handler.element;[
<!ENTITY % DIAL.handler.content  "( #PCDATA )" >
<!ELEMENT %DIAL.handler.qname;  %DIAL.handler.content; >
<!-- end of handler.element -->]]>

<!ENTITY % DIAL.handler.attlist  "INCLUDE" >
<![%DIAL.handler.attlist;[
<!ATTLIST %DIAL.handler.qname;
	%embedding.attrib;
      	%Common.attrib;      
>
<!-- end of handler.attlist -->]]>


<!-- end of dial-handler-1.mod -->
