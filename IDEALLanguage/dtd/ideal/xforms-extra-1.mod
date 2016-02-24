<!-- ...................................................................... -->
<!-- Xforms 								-->
<!-- file: xforms-extra-1.mod
-->

<!-- invoke elements -->
<!ENTITY % XForms.invoke.element  "INCLUDE" >
<![%XForms.invoke.element;[
<!ENTITY % XForms.invoke.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.invoke.qname;  %XForms.invoke.content; >
]]>

<!ATTLIST %XForms.invoke.qname;
	%xml-events.attrs.qname;
	%DIAL.sel:expr.attrib;
	%Common.attrib;	
>
<!-- end of invoke.element -->

<!-- format elements -->
<!ENTITY % XForms.format.element  "INCLUDE" >
<![%XForms.format.element;[
<!ENTITY % XForms.format.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.format.qname;  %XForms.format.content; >
]]>

<!ATTLIST %XForms.format.qname;
	%xml-events.attrs.qname;
	%IDEAL.formatter.attrib;
	%Common.attrib;	
>
<!-- end of format.element -->

<!-- phoneBookAdd elements -->
<!ENTITY % XForms.phoneBookAdd.element  "INCLUDE" >
<![%XForms.phoneBookAdd.element;[
<!ENTITY % XForms.phoneBookAdd.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.phoneBookAdd.qname;  %XForms.format.content; >
]]>

<!ATTLIST %XForms.phoneBookAdd.qname;
	%xml-events.attrs.qname;
	%XForms.contact.attrib;
	%Common.attrib;	
>
<!-- end of phoneBookAdd.element -->

<!-- smsSend elements -->
<!ENTITY % XForms.smsSend.element  "INCLUDE" >
<![%XForms.smsSend.element;[
<!ENTITY % XForms.smsSend.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.smsSend.qname;  %XForms.format.content; >
]]>

<!ATTLIST %XForms.smsSend.qname;
	%xml-events.attrs.qname;
	%Common.attrib;	
>
<!-- end of smsSend.element -->

<!-- telephoneCall elements -->
<!ENTITY % XForms.telephoneCall.element  "INCLUDE" >
<![%XForms.telephoneCall.element;[
<!ENTITY % XForms.telephoneCall.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.telephoneCall.qname;  %XForms.format.content; >
]]>

<!ATTLIST %XForms.telephoneCall.qname;
	%xml-events.attrs.qname;
	%XForms.cti.attrib;
	%Common.attrib;	
>
<!-- end of telephoneCall.element -->

<!-- validate elements -->
<!ENTITY % XForms.validate.element  "INCLUDE" >
<![%XForms.validate.element;[
<!ENTITY % XForms.validate.content  "(%XForms.Action.class;)" >
<!ELEMENT %XForms.validate.qname;  %XForms.validate.content; >
]]>

<!ATTLIST %XForms.validate.qname;
	%xml-events.attrs.qname;
	%IDEAL.validator.attrib;
	%Common.attrib;	
>
<!-- end of validate.element -->

<!-- end of xforms-extra-1.mod -->