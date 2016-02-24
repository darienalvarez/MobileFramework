<!-- ..................................................................... -->
<!-- DIAL Block Phrasal Module  ............................................ -->
<!-- file: dial-blkphras-qname-1.mod -->

<!-- DIAL Block Phrasal Qname (Qualified Name) Module -->

<!-- Section A: DIAL Block Phrasal Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % DIAL.prefixed "%NS.prefixed;" >

<!ENTITY % DIAL.xmlns  "http://www.morfeo-project.org/2008/dial" >

<!ENTITY % DIAL.prefix  "dial" >

<![%DIAL.prefixed;[
<!ENTITY % DIAL.pfx  "%DIAL.prefix;:" >
]]>
<!ENTITY % DIAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % dial-list-qname-extra.mod "" >
%dial-list-qname-extra.mod;

<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.extra.attrib
	"xmlns:%DIAL.prefix;	%URI.datatype;	#FIXED	'%DIAL.xmlns;'" >
]]>

<!ENTITY % DIAL.xmlns.extra.attrib "" >


	
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % DIAL.html.qname 				"%DIAL.pfx;html">
<!ENTITY % DIAL.head.qname 				"%DIAL.pfx;head">
<!ENTITY % DIAL.body.qname 				"%DIAL.pfx;body">
<!ENTITY % DIAL.title.qname 				"%DIAL.pfx;title">

