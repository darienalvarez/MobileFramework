<!-- ...................................................................... -->
<!-- selgroup Module ................................................... -->
<!-- file: ideal-selgroup-1.mod -->

<!-- selgroup.element -->
<!ENTITY % IDEAL.selgroup.element  "INCLUDE" >

<![%IDEAL.selgroup.element;[
<!ENTITY % IDEAL.selgroup.content  "(%XForms.label.qname;, (%XForms.select1.qname;)*)" >
<!ELEMENT %IDEAL.selgroup.qname;  %IDEAL.selgroup.content; >
]]>

<!ATTLIST %IDEAL.selgroup.qname;
	%XForms.common.attributes;
	%XForms.model.attrib;
	%XForms.repeat.attrib;
>
<!-- end of input.element -->

<!-- file: ideal-selgroup-1.mod -->