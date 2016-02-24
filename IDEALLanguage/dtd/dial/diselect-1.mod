<!-- ...................................................................... -->
<!-- DISelect Elements Module ................................................... -->
<!-- file: diselect-1.mod

	 xmlns:sel="http://www.w3.org/2004/06/diselect "
     ...................................................................... 
-->

<!-- Define the global namespace attributes -->
<![%DISelect.prefixed;[
<!ENTITY % DISelect.xmlns.attrib
    "%NS.decl.attrib;"
>
]]>
<!ENTITY % DISelect.xmlns.attrib
	 "%NS.decl.attrib;
	 xmlns	%URI.datatype;	#FIXED '%DISelect.xmlns;'"
>



<!ENTITY % DISelect.extra.attributes "" >

<!-- if elements -->
<!ENTITY % DISelect.if.element  "INCLUDE" >
<![%DISelect.if.element;[
<!ENTITY % DISelect.if.content  "ANY" >
<!ELEMENT %DISelect.if.qname;  %DISelect.if.content; >
]]>

<!ATTLIST %DISelect.if.qname;
	%DISelect.expr.attrib;
	%DISelect.selidname.attrib;
 	%DISelect.functions.attrib;
	%documentElementAttributes; 
	%DISelect.extra.attributes;
	%Common.attrib;	
>
<!-- end of if.element -->

<!-- select element -->
<!ENTITY % DISelect.select.element  "INCLUDE" >
<![%DISelect.select.element;[
<!ENTITY % DISelect.select.content  "((%DISelect.when.qname;)*, (%DISelect.otherwise.qname;)?)" >
<!ELEMENT %DISelect.select.qname;  %DISelect.select.content; >
]]>

<!ATTLIST %DISelect.select.qname;
	%DISelect.expr.attrib;
	%DISelect.precept.attrib;
	%DISelect.selidname.attrib;
 	%DISelect.functions.attrib;
 	%DISelect.extra.attributes;
	%Common.attrib; 	
>
<!-- end of select.element -->

<!-- when -->
<!ENTITY % DISelect.when.element  "INCLUDE" >
<![%DISelect.when.element;[
<!ENTITY % DISelect.when.content  "ANY" >
<!ELEMENT %DISelect.when.qname;  %DISelect.when.content; >
]]>

<!ATTLIST %DISelect.when.qname;
	%DISelect.expr.attrib;
	%DISelect.precept.attrib;
	%DISelect.selidname.attrib;
 	%DISelect.functions.attrib;
 	%DISelect.extra.attributes;
	%Common.attrib; 	
>
<!-- end of when.element -->

<!-- otherwise -->
<!ENTITY % DISelect.otherwise.element  "INCLUDE" >
<![%DISelect.otherwise.element;[
<!ENTITY % DISelect.otherwise.content  "ANY" >
<!ELEMENT %DISelect.otherwise.qname;  %DISelect.otherwise.content; >
]]>

<!ATTLIST %DISelect.otherwise.qname;
	%DISelect.selidname.attrib;
 	%DISelect.functions.attrib;
	%DISelect.extra.attributes;	
	%Common.attrib;	
>
<!-- end of otherwise.element -->


<!-- variable element.-->
<!ENTITY % DISelect.variable.element  "INCLUDE" >
<![%DISelect.variable.element;[
<!ENTITY % DISelect.variable.content  "EMPTY" >
<!ELEMENT %DISelect.variable.qname;  %DISelect.variable.content; >
]]>

<!ATTLIST %DISelect.variable.qname;
	%DISelect.name.attrib;
	%DISelect.ref.attrib;
	%DISelect.value.attrib;
	%DISelect.extra.attributes;	
	%Common.attrib;	
>
<!-- end of variable.element -->

<!-- value element.-->
<!ENTITY % DISelect.value.element  "INCLUDE" >
<![%DISelect.value.element;[
<!ENTITY % DISelect.value.content  "EMPTY" >
<!ELEMENT %DISelect.value.qname;  %DISelect.value.content; >
]]>

<!ATTLIST %DISelect.value.qname;
	%DISelect.expr.attrib;
	%DISelect.extra.attributes;	
	%Common.attrib;	
>
<!-- end of value.element -->

<!-- end of diselect-1.mod -->