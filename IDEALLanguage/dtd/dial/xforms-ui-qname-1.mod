<!-- ...................................................................... -->
<!-- XForm UI Qname Module ................................................... -->
<!-- file: xform-ui-qname-1.mod

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
<!ENTITY % XForms.group.qname 					"%XForms.pfx;group">
<!ENTITY % XForms.switch.qname 					"%XForms.pfx;switch">
<!ENTITY % XForms.repeat.qname 					"%XForms.pfx;repeat">
<!ENTITY % XForms.case.qname 					"%XForms.pfx;case">
<!ENTITY % XForms.toggle.qname 					"%XForms.pfx;toggle">
<!ENTITY % XForms.itemset.qname 					"%XForms.pfx;itemset">
<!ENTITY % XForms.copy.qname 					"%XForms.pfx;copy">
<!ENTITY % XForms.insert.qname 					"%XForms.pfx;insert">
<!ENTITY % XForms.delete.qname 					"%XForms.pfx;delete">
<!ENTITY % XForms.setindex.qname 				"%XForms.pfx;setindex">