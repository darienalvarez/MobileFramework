
<!-- ...................................................................... -->
<!-- DISelect Qname Module ................................................... -->
<!-- file: diselect-qname-1.mod

	 xmlns:sel="http://www.w3.org/2004/06/diselect"
     ...................................................................... -->

<!-- Declare the default value for prefixing of this module's elements -->
<!-- Note that the NS.prefixed will get overridden by the XHTML Framework or
     by a document instance. -->
<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % DISelect.prefixed "%NS.prefixed;" >

<!-- Declare the actual namespace of this module -->
<!ENTITY % DISelect.xmlns "http://www.w3.org/2005/sel" >

<!-- Declare the default prefix for this module -->
<!ENTITY % DISelect.prefix "sel" >

<!-- Declare the prefix for this module -->
<![%DISelect.prefixed;[
<!ENTITY % DISelect.pfx "%DISelect.prefix;:" >
]]>
<!ENTITY % DISelect.pfx "" >

<!-- Declare the xml namespace attribute for this module -->
<![%DISelect.prefixed;[
<!ENTITY % DISelect.xmlns.extra.attrib
	"xmlns:%DISelect.prefix;	%URI.datatype;	#FIXED	'%DISelect.xmlns;'" >
]]>
<!ENTITY % DISelect.xmlns.extra.attrib "">
	
	
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % DISelect.if.qname 			"%DISelect.pfx;if">
<!ENTITY % DISelect.select.qname 		"%DISelect.pfx;select">
<!ENTITY % DISelect.when.qname 			"%DISelect.pfx;when">
<!ENTITY % DISelect.otherwise.qname 		"%DISelect.pfx;otherwise">
<!ENTITY % DISelect.variable.qname 		"%DISelect.pfx;variable">
<!ENTITY % DISelect.value.qname 		"%DISelect.pfx;value">
<!ENTITY % DISelect.expr.qname 			"%DISelect.pfx;expr">
<!ENTITY % DISelect.selid.qname 		"%DISelect.pfx;selid">
<!ENTITY % DISelect.selidName.qname 		"%DISelect.pfx;selidName">
<!ENTITY % DISelect.functions.qname 		"%DISelect.pfx;functions">
<!ENTITY % DISelect.name.qname	 		"%DISelect.pfx;name">
<!ENTITY % DISelect.ref.qname 			"%DISelect.pfx;ref">
<!ENTITY % DISelect.value.qname 		"%DISelect.pfx;value">