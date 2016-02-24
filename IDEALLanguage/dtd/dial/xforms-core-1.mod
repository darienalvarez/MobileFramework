<!-- ...................................................................... -->
<!-- DISelect Elements Module ................................................... -->
<!-- file: xform-core-1.mod

	PUBLIC "-//MY COMPANY//ELEMENTS XHTML XForm Qnames 1.0//EN"
     	SYSTEM "http://www.w3.org/XFORM/xform-model-qname-1.mod"

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
<!ENTITY % documentElementattributes 
	" xmlns:%XForms.prefix; CDATA 'http://www.w3.org/2002/xforms'	
	">

<!-- XForms.extra.attributes lets to include new attributes in all xform elements,   -->
<!ENTITY % XForms.extra.attributes "" >

<!ENTITY % XForms.Action.class "	(
				%XForms.action.qname; 
				| %XForms.dispatch.qname;
				| %XForms.rebuild.qname;
				| %XForms.refresh.qname;
				| %XForms.recalculate.qname;
				| %XForms.revalidate.qname;
				| %XForms.setfocus.qname;
				| %XForms.load.qname;
				| %XForms.setvalue.qname;
				| %XForms.send.qname;
				| %XForms.reset.qname;
				| %XForms.message.qname;
				| %XForms.toggle.qname;
				| %XForms.insert.qname;
				| %XForms.delete.qname;
				| %XForms.setindex.qname;
				)*
				" >


<!ENTITY % XForms.model.element  "INCLUDE" >
<![%XForms.model.element;[
<!ENTITY % XForms.model.content  "(%XForms.instance.qname;  | %schema; | %XForms.submission.qname; | %XForms.bind.qname; |  %XForms.Action.class; )*" >
<!ELEMENT %XForms.model.qname;  %XForms.model.content; >
]]>

<!ATTLIST %XForms.model.qname;
	%XForms.common.attributes;
	%xml-events.attrs.qname;
	%XForms.functions.qname; 		CDATA 	#IMPLIED
	%XForms.schema.qname; 		CDATA		#IMPLIED
	%XForms.version.qname; 		CDATA		#IMPLIED
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of model.element -->

<!ENTITY % XForms.instance.element  "INCLUDE" >
<![%XForms.instance.element;[
<!ENTITY % XForms.instance.content  "( #PCDATA)" >
<!ELEMENT %XForms.instance.qname;  %XForms.instance.content; >
]]>

<!ATTLIST %XForms.instance.qname;
	%XForms.common.attributes;
	%XForms.Linking.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of instance.element -->


<!ENTITY % XForms.submission.element  "INCLUDE" >
<![%XForms.submission.element;[
<!ENTITY % XForms.submission.content  "(%XForms.Action.class;)*" >
<!ELEMENT %XForms.submission.qname;  %XForms.submission.content; >
]]>

<!ATTLIST %XForms.submission.qname;
	%XForms.common.attributes;
	%XForms.ref.attrib;
	%XForms.bind.attrib;
	%XForms.action.attrib;
	%XForms.method.attrib;
	%XForms.version.attrib;
	%XForms.indent.attrib;
	%XForms.mediatype.attrib;
	%XForms.encoding.attrib;
	%XForms.omit-xml-declaration.attrib;
	%XForms.standalone.attrib;
	%XForms.cdata-section-elements.attrib;
	%XForms.replace.attrib;
	%XForms.instance.attrib;
	%XForms.includenamespaceprefixes.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!--	%XForms.separator.attrib; -->
<!-- end of submission -->


<!ENTITY % XForms.bind.element  "INCLUDE" >
<![%XForms.bind.element;[
<!ENTITY % XForms.bind.content  "(%XForms.bind.qname;)*" >
<!ELEMENT %XForms.bind.qname;  %XForms.bind.content; >
]]>

<!ATTLIST %XForms.bind.qname;
	%XForms.common.attributes;
	%XForms.modelItem.attributes;
	%XForms.nodeset.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of bind -->


<!-- end of xform-core-1.mod -->