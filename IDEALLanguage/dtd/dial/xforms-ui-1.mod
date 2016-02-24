<!-- ...................................................................... -->
<!-- Xform UI Elements Module ................................................... -->
<!-- file: xform-ui-1.mod

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


<!-- group.element -->
<!ENTITY % XForms.group.element  "INCLUDE" >
<![%XForms.group.element;[
<!ENTITY % XForms.group.content  "(%XForms.label.qname;?, (%XForms.Controls.class; | %XForms.group.qname; |  %XForms.switch.qname; | %XForms.repeat.qname; | %XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.group.qname;  %XForms.group.content; >
]]>

<!ATTLIST %XForms.group.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of group.element -->


<!-- switch.element -->
<!ENTITY % XForms.switch.element  "INCLUDE" >
<![%XForms.switch.element;[
<!ENTITY % XForms.switch.content  "(%XForms.case.qname;+)" >
<!ELEMENT %XForms.switch.qname;  %XForms.switch.content; >
]]>

<!ATTLIST %XForms.switch.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of switch.element -->

<!-- case.element -->
<!ENTITY % XForms.case.element  "INCLUDE" >
<![%XForms.case.element;[
<!ENTITY % XForms.case.content  "(%XForms.label.qname;?, (%XForms.Controls.class; | %XForms.Action.class;| %XForms.group.qname; | %XForms.switch.qname; | %XForms.repeat.qname;)*)">
<!ELEMENT %XForms.case.qname;  %XForms.case.content; >
]]>

<!ATTLIST %XForms.case.qname;
	%XForms.common.attributes;
	%XForms.selected.attrib;
	%XForms.extra.attributes;
	%Common.attrib;	
>
<!-- end of case.element -->


<!-- toggle.element -->
<!ENTITY % XForms.toggle.element  "INCLUDE" >
<![%XForms.toggle.element;[
<!ENTITY % XForms.toggle.content  "EMPTY">
<!ELEMENT %XForms.toggle.qname;  %XForms.toggle.content; >
]]>

<!ATTLIST %XForms.toggle.qname;
	%XForms.common.attributes;
	%XForms.case.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of toggle.element -->

<!-- repeat.element -->
<!ENTITY % XForms.repeat.element  "INCLUDE" >
<![%XForms.repeat.element;[
<!ENTITY % XForms.repeat.content  "(%XForms.Controls.class; | %XForms.group.qname; | %XForms.switch.qname; | %XForms.repeat.qname;)*">
<!ELEMENT %XForms.repeat.qname;  %XForms.repeat.content; >
]]>

<!ATTLIST %XForms.repeat.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.NodeSetBinding.attributes;
	%XForms.startindex.attrib;
	%XForms.number.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of repeat.element -->


<!-- itemset.element -->
<!ENTITY % XForms.itemset.element  "INCLUDE" >
<![%XForms.itemset.element;[
<!ENTITY % XForms.itemset.content  "(%XForms.label.qname;?, (%XForms.value.qname; | %XForms.copy.qname;), (%XForms.UICommon.class;)*)">
<!ELEMENT %XForms.itemset.qname;  %XForms.itemset.content; >
]]>

<!ATTLIST %XForms.itemset.qname;
	%XForms.common.attributes;
	%XForms.NodeSetBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of itemset.element -->

<!-- copy.element -->
<!ENTITY % XForms.copy.element  "INCLUDE" >
<![%XForms.copy.element;[
<!ENTITY % XForms.copy.content  "EMPTY">
<!ELEMENT %XForms.copy.qname;  %XForms.copy.content; >
]]>

<!ATTLIST %XForms.copy.qname;
	%XForms.common.attributes;
	%XForms.NodeSetBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of copy.element -->

<!-- insert.element -->
<!ENTITY % XForms.insert.element  "INCLUDE" >
<![%XForms.insert.element;[
<!ENTITY % XForms.insert.content  "EMPTY">
<!ELEMENT %XForms.insert.qname;  %XForms.insert.content; >
]]>

<!ATTLIST %XForms.insert.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.NodeSetBinding.attributes;
	%XForms.at.attrib;
	%XForms.position.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of insert.element -->


<!-- delete.element -->
<!ENTITY % XForms.delete.element  "INCLUDE" >
<![%XForms.delete.element;[
<!ENTITY % XForms.delete.content  "EMPTY">
<!ELEMENT %XForms.delete.qname;  %XForms.delete.content; >
]]>

<!ATTLIST %XForms.delete.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.NodeSetBinding.attributes;
	%XForms.at.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of delete.element -->

<!-- setindex.element -->
<!ENTITY % XForms.setindex.element  "INCLUDE" >
<![%XForms.setindex.element;[
<!ENTITY % XForms.setindex.content  "EMPTY">
<!ELEMENT %XForms.setindex.qname;  %XForms.setindex.content; >
]]>

<!ATTLIST %XForms.setindex.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.repeat.attrib;
	%XForms.index.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of setindex.element -->

<!-- end of xform-ui-1.mod -->