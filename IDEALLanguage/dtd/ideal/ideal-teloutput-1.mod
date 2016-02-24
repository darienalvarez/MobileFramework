<!-- ...................................................................... -->
<!-- teloutput Module ................................................... -->
<!-- file: ideal-teloutput-1.mod -->

<!-- teloutput.element -->
<!ENTITY % IDEAL.teloutput.element  "INCLUDE" >
<!ENTITY % IDEAL.teloutput.qname  "teloutput" >

<![%IDEAL.teloutput.element;[
<!ENTITY % IDEAL.teloutput.content  "(%XForms.label.qname;, (%XForms.Action.class;)*)" >
<!ELEMENT %IDEAL.teloutput.qname;  %IDEAL.teloutput.content; >
]]>

<!ATTLIST %IDEAL.teloutput.qname;
	%Common.attrib;
	%XForms.ref.attrib;
	%IDEAL.decorator.attrib;
>
<!-- end of teloutput.element -->


<!-- file: ideal-teloutput-1.mod -->
