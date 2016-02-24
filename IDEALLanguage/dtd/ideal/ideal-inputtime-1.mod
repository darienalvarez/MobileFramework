<!-- ...................................................................... -->
<!-- inputdate Module ................................................... -->
<!-- file: ideal-inputTime-1.mod -->

<!-- inputTime.element -->
<!ENTITY % IDEAL.inputTime.element  "INCLUDE" >
<!ENTITY % IDEAL.inputTime.qname  "inputTime" >

<![%IDEAL.inputTime.element;[
<!ENTITY % IDEAL.inputTime.content  "(%XForms.label.qname;, (%XForms.Action.class;)*)" >
<!ELEMENT %IDEAL.inputTime.qname;  %IDEAL.inputTime.content; >
]]>

<!ATTLIST %IDEAL.inputTime.qname;
	%Common.attrib;
	%XForms.ref.attrib;
	%XForms.bind.attrib;
	%XForms.model.attrib;
	%IDEAL.validator.attrib;
	%IDEAL.formatter.attrib;
>
<!-- end of inputTime.element -->


<!-- file: ideal-inputTime-1.mod -->