<!-- ...................................................................... -->
<!-- XForm Model Qname Module ................................................... -->
<!-- file: xform-model-qname-1.mod

	PUBLIC "-//MY COMPANY//ELEMENTS XHTML XForm Qnames 1.0//EN"
     	SYSTEM "http://www.w3.org/XFORM/xform-model-qname-1.mod"

	xmlns:xforms="http://www.w3.org/2002/xforms"
     ...................................................................... -->

<!-- Declare the default value for prefixing of this module's elements -->
<!-- Note that the NS.prefixed will get overridden by the XHTML Framework or
     by a document instance. -->
<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % XForms.prefixed "%NS.prefixed;" >

<!-- Declare the actual namespace of this module -->
<!ENTITY % XForms.xmlns "http://www.w3.org/2002/xforms" >

<!-- Declare the default prefix for this module -->
<!ENTITY % XForms.prefix "xforms" >

<!-- Declare the prefix for this module -->
<![%XForms.prefixed;[
<!ENTITY % XForms.pfx "%XForms.prefix;:" >
]]>
<!ENTITY % XForms.pfx "" >

<!--namespace prefixes-->
<!ENTITY % xsd_prefix "xsd">
<!ENTITY % ev_prefix "ev">
<!ENTITY % xforms_prefix "xforms">
<!ENTITY % xml_prefix "xml">
<!--namespace prefix to namespace uri mappings-->
<!ENTITY % xsd_prefix.. "%xsd_prefix;:">
<!ENTITY % ev_prefix.. "%ev_prefix;:">
<!ENTITY % xforms_prefix.. "%xforms_prefix;:">
<!ENTITY % xml_prefix.. "%xml_prefix;:">
<!--namespaces attributes for root element-->
<!ENTITY % documentElementAttributes " xmlns:%xsd_prefix; CDATA 'http://www.w3.org/2001/XMLSchema' xmlns:%ev_prefix; CDATA 'http://www.w3.org/2001/xml-events' xmlns:%xforms_prefix; CDATA 'http://www.w3.org/2002/xforms' xmlns:%xml_prefix; CDATA 'http://www.w3.org/XML/1998/namespace'">


<!-- Declare the xml namespace attribute for this module -->
<![%XForms.prefixed;[
<!ENTITY % XForms.xmlns.extra.attrib
	"xmlns:%XForms.prefix;	%URI.datatype;	#FIXED	'%XForms.xmlns;'" >
]]>
<!ENTITY % XForms.xmlns.extra.attrib "">
	
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % XForms.model.qname 					"%XForms.pfx;model">
<!ENTITY % XForms.instance.qname 				"%XForms.pfx;instance">
<!ENTITY % XForms.submission.qname 			"%XForms.pfx;submission">
<!ENTITY % XForms.bind.qname 					"%XForms.pfx;bind">
<!ENTITY % XForms.action.qname 					"%XForms.pfx;action">
<!ENTITY % XForms.send.qname 					"%XForms.pfx;send">
<!ENTITY % XForms.reset.qname 					"%XForms.pfx;reset">
<!ENTITY % XForms.xs:schema.qname 			"%XForms.pfx;xs:schema">

<!ENTITY % XForms.functions.qname 			"%XForms.pfx;functions">
<!ENTITY % XForms.schema.qname 			"%XForms.pfx;schema">
<!ENTITY % XForms.version.qname 			"%XForms.pfx;version">

<!ENTITY % XForms.src.qname 					"%XForms.pfx;src">

<!ENTITY % XForms.nodeset.qname 			"%XForms.pfx;nodeset">
<!ENTITY % XForms.calculate.qname 			"%XForms.pfx;calculate">
<!ENTITY % XForms.type.qname	 				"%XForms.pfx;type">
<!ENTITY % XForms.required.qname 			"%XForms.pfx;required">
<!ENTITY % XForms.constraint.qname 		"%XForms.pfx;constraint">
<!ENTITY % XForms.relevant.qname 			"%XForms.pfx;relevant">
<!ENTITY % XForms.readonly.qname 			"%XForms.pfx;readonly">
<!ENTITY % XForms.p3ptype.qname 			"%XForms.pfx;p3ptype">

<!ENTITY % XForms.if.qname 					"%XForms.pfx;if">
<!ENTITY % XForms.while.qname 			"%XForms.pfx;while">

<!ENTITY % XForms.resource.qname 			"%XForms.pfx;resource">
<!ENTITY % XForms.method.qname 			"%XForms.pfx;method">
<!ENTITY % XForms.header.qname 				"%XForms.pfx;header">
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % XForms.input.qname 			"%XForms.pfx;input">
<!ENTITY % XForms.select.qname 		"%XForms.pfx;select">
<!ENTITY % XForms.select1.qname		"%XForms.pfx;select1">
<!ENTITY % XForms.item.qname 			"%XForms.pfx;item">
<!ENTITY % XForms.value.qname 			"%XForms.pfx;value">
<!ENTITY % XForms.itemset.qname 			"%XForms.pfx;itemset">
<!ENTITY % XForms.textarea.qname 	"%XForms.pfx;textarea">
<!ENTITY % XForms.range.qname 		"%XForms.pfx;range">
<!ENTITY % XForms.hint.qname 			"%XForms.pfx;hint">
<!ENTITY % XForms.help.qname 			"%XForms.pfx;help">
<!ENTITY % XForms.alert.qname 			"%XForms.pfx;alert">
<!ENTITY % XForms.upload.qname 		"%XForms.pfx;upload">
<!ENTITY % XForms.secret.qname 		"%XForms.pfx;secret">
<!ENTITY % XForms.range.qname 		"%XForms.pfx;range">
<!ENTITY % XForms.choices.qname 		"%XForms.pfx;choices">
<!ENTITY % XForms.trigger.qname 		"%XForms.pfx;trigger">

<!ENTITY % XForms.filename.qname 		"%XForms.pfx;filename">
<!ENTITY % XForms.mediatype.qname 		"%XForms.pfx;mediatype">

<!ENTITY % XForms.ref.qname 				"%XForms.pfx;ref">
<!ENTITY % XForms.bind.qname 			"%XForms.pfx;bind">


<!-- select attributes -->
<!ENTITY % XForms.appearance.qname 			"%XForms.pfx;appearance">
<!ENTITY % XForms.full.qname 						"full">
<!ENTITY % XForms.compact.qname 				"compact">
<!ENTITY % XForms.minimal.qname 					"minimal">
<!ENTITY % XForms.selection.qname 				"%XForms.pfx;selection">
<!ENTITY % XForms.open.qname 						"open">
<!ENTITY % XForms.closed.qname 					"closed">
<!ENTITY % XForms.incremental.qname 			"%XForms.pfx;incremental">
<!ENTITY % XForms.inputmode.qname 				"%XForms.pfx;inputmode">
<!ENTITY % XForms.mediatype.qname 				"%XForms.pfx;mediatype">
<!ENTITY % XForms.start.qname 						"%XForms.pfx;start">
<!ENTITY % XForms.end.qname 						"%XForms.pfx;end">
<!ENTITY % XForms.step.qname 						"%XForms.pfx;step">