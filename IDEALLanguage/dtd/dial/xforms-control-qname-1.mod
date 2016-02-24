<!-- ...................................................................... -->
<!-- XForm Control Qname Module ................................................... -->
<!-- file: xform-control-qname-1.mod

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
<!ENTITY % XForms.prefix "xf" >

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
	
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % XForms.input.qname 				"%XForms.pfx;input">

<!ENTITY % XForms.secret.qname 				"%XForms.pfx;secret">
<!ENTITY % XForms.textarea.qname 			"%XForms.pfx;textarea">
<!ENTITY % XForms.output.qname 				"%XForms.pfx;output">
<!ENTITY % XForms.upload.qname 				"%XForms.pfx;upload">
<!ENTITY % XForms.range.qname 				"%XForms.pfx;range">
<!ENTITY % XForms.trigger.qname 				"%XForms.pfx;trigger">
<!ENTITY % XForms.submit.qname 				"%XForms.pfx;submit">
<!ENTITY % XForms.select.qname 				"%XForms.pfx;select">
<!ENTITY % XForms.select1.qname 				"%XForms.pfx;select1">
<!ENTITY % XForms.choices.qname 				"%XForms.pfx;choices">
<!ENTITY % XForms.item.qname 				"%XForms.pfx;item">
<!ENTITY % XForms.filename.qname 			"%XForms.pfx;filename">
<!ENTITY % XForms.mediatype.qname 			"%XForms.pfx;mediatype">
<!ENTITY % XForms.value.qname 				"%XForms.pfx;value">
<!ENTITY % XForms.label.qname 				"%XForms.pfx;label">
<!ENTITY % XForms.help.qname 				"%XForms.pfx;help">
<!ENTITY % XForms.hint.qname 				"%XForms.pfx;hint">
<!ENTITY % XForms.alert.qname 				"%XForms.pfx;alert">
