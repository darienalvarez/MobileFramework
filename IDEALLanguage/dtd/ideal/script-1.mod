<!-- ...................................................................... -->
<!-- IDEAL document              ................................................... -->
<!-- file: script-1.mod	-->


<!-- script element................ -->
<!ENTITY % script.element  "INCLUDE" >
<![%script.element;[
<!ENTITY % script.content  " EMPTY" >
<!ELEMENT %script.qname;  %script.content; >
<!-- end of script.element -->]]>

<!ENTITY % script.attlist  "INCLUDE" >
<![%script.attlist;[
<!ATTLIST %script.qname;
	%Common.attrib;
	%embedding.attrib;
>
<!-- end of script.attlist -->]]>


<!-- end of script-1.mod -->
