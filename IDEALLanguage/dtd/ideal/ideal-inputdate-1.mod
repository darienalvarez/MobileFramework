<!-- ...................................................................... -->
<!-- inputdate Module ................................................... -->
<!-- file: ideal-inputDate-1.mod -->

<!-- inputdate.element -->
<!ENTITY % IDEAL.inputDate.element  "INCLUDE" >
<!ENTITY % IDEAL.inputDate.qname  "inputDate" >

<![%IDEAL.inputDate.element;[
<!ENTITY % IDEAL.inputDate.content  "(%XForms.label.qname;, (%XForms.Action.class;)*)" >
<!ELEMENT %IDEAL.inputDate.qname;  %IDEAL.inputDate.content; >
]]>

<!ATTLIST %IDEAL.inputDate.qname;
	%Common.attrib;
	%XForms.ref.attrib;
	%XForms.bind.attrib;
	%XForms.model.attrib;
	%IDEAL.validator.attrib;
	%IDEAL.formatter.attrib;
>
<!-- end of input.element -->


<!-- file: ideal-inputDate-1.mod -->
