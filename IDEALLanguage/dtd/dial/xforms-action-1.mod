<!-- ...................................................................... -->
<!-- Xform Action Elements Module ................................................... -->
<!-- file: xform-action-1.mod

	xmlns:xforms="http://www.w3.org/2002/xforms"
     ...................................................................... 
-->

<!-- Define the global namespace attributes -->
<![%XForms.prefixed;[
<!ENTITY % XForms.xmlns.attrib
    "%NS.decl.attrib;"
>
]]>
<!ENTITY % XForms.xmlns.attrib
	 "%NS.decl.attrib; 
	 xmlns	%URI.datatype;	#FIXED '%XForms.xmlns;' "
>

<!-- namespaces attributes for root element -->
<!ENTITY % documentElementAttributes 
	" xmlns:%XForms.prefix; CDATA 'http://www.w3.org/2002/xforms'	
	">

<!-- XForms.extra.attributes lets to include new attributes in all xform elements,   -->
<!ENTITY % XForms.extra.attributes "" >


<!-- action.element -->
<!ENTITY % XForms.action.element  "INCLUDE" >
<![%XForms.action.element;[
<!ENTITY % XForms.action.content  "(%XForms.Action.class;)+" >
<!ELEMENT %XForms.action.qname;  %XForms.action.content; >
]]>

<!ATTLIST %XForms.action.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.extra.attributes;
	%Common.attrib;	
>
<!-- end of action.element -->

<!-- dispatch.element -->
<!ENTITY % XForms.dispatch.element  "INCLUDE" >
<![%XForms.dispatch.element;[
<!ENTITY % XForms.dispatch.content  "EMPTY" >
<!ELEMENT %XForms.dispatch.qname;  %XForms.dispatch.content; >
]]>

<!ATTLIST %XForms.dispatch.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.name.attrib;
	%XForms.target.attrib;
	%XForms.bubbles.attrib;
	%XForms.cancelable.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of dispatch.element -->

<!-- rebuild.element -->
<!ENTITY % XForms.rebuild.element  "INCLUDE" >
<![%XForms.rebuild.element;[
<!ENTITY % XForms.rebuild.content  "EMPTY" >
<!ELEMENT %XForms.rebuild.qname;  %XForms.rebuild.content; >
]]>

<!ATTLIST %XForms.rebuild.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of rebuild.element -->

<!-- recalculate.element -->
<!ENTITY % XForms.recalculate.element  "INCLUDE" >
<![%XForms.recalculate.element;[
<!ENTITY % XForms.recalculate.content  "EMPTY" >
<!ELEMENT %XForms.recalculate.qname;  %XForms.recalculate.content; >
]]>

<!ATTLIST %XForms.recalculate.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of recalculate.element -->

<!-- revalidate.element -->
<!ENTITY % XForms.revalidate.element  "INCLUDE" >
<![%XForms.revalidate.element;[
<!ENTITY % XForms.revalidate.content  "EMPTY" >
<!ELEMENT %XForms.revalidate.qname;  %XForms.revalidate.content; >
]]>

<!ATTLIST %XForms.revalidate.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of revalidate.element -->

<!-- refresh.element -->
<!ENTITY % XForms.refresh.element  "INCLUDE" >
<![%XForms.refresh.element;[
<!ENTITY % XForms.refresh.content  "EMPTY" >
<!ELEMENT %XForms.refresh.qname;  %XForms.refresh.content; >
]]>

<!ATTLIST %XForms.refresh.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of refresh.element -->

<!-- setfocus.element -->
<!ENTITY % XForms.setfocus.element  "INCLUDE" >
<![%XForms.setfocus.element;[
<!ENTITY % XForms.setfocus.content  "EMPTY" >
<!ELEMENT %XForms.setfocus.qname;  %XForms.setfocus.content; >
]]>

<!ATTLIST %XForms.setfocus.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of setfocus.element -->

<!-- load.element -->
<!ENTITY % XForms.load.element  "INCLUDE" >
<![%XForms.load.element;[
<!ENTITY % XForms.load.content  "EMPTY" >
<!ELEMENT %XForms.load.qname;  %XForms.load.content; >
]]>

<!ATTLIST %XForms.load.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;	
	%XForms.SingleNodeBinding.attributes;
	%XForms.resource.attrib;
	%XForms.show.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of load.element -->

<!-- setvalue.element -->
<!ENTITY % XForms.setvalue.element  "INCLUDE" >
<![%XForms.setvalue.element;[
<!ENTITY % XForms.setvalue.content  "(#PCDATA)" >
<!ELEMENT %XForms.setvalue.qname;  %XForms.setvalue.content; >
]]>

<!ATTLIST %XForms.setvalue.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;	
	%XForms.SingleNodeBinding.attributes;
	%XForms.value.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of setvalue.element -->

<!-- send.element -->
<!ENTITY % XForms.send.element  "INCLUDE" >
<![%XForms.send.element;[
<!ENTITY % XForms.send.content  "EMPTY" >
<!ELEMENT %XForms.send.qname;  %XForms.send.content; >
]]>

<!ATTLIST %XForms.send.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;	
	%XForms.submission.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of send.element -->

<!-- reset.element -->
<!ENTITY % XForms.reset.element  "INCLUDE" >
<![%XForms.reset.element;[
<!ENTITY % XForms.reset.content  "EMPTY" >
<!ELEMENT %XForms.reset.qname;  %XForms.reset.content; >
]]>

<!ATTLIST %XForms.reset.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;	
	%XForms.model.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of reset.element -->

<!-- message.element -->
<!ENTITY % XForms.message.element  "INCLUDE" >
<![%XForms.message.element;[
<!ENTITY % XForms.message.content  "(PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %XForms.message.qname;  %XForms.message.content; >
]]>

<!ATTLIST %XForms.message.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.SingleNodeBinding.attributes;
	%XForms.Linking.attributes;
	%XForms.level.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of message.element -->

<!-- end of xform-action-1.mod -->