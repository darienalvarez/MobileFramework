<!-- ..................................................................... -->
<!-- DIAL Hypertext Module  ............................................ -->
<!-- file: dial-Hypertext-qname-1.mod......................................... -->

<!-- DIAL Hypertext Qname (Qualified Name) Module -->

<!-- Section A: DIAL Hypertext Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % DIAL.prefixed "%NS.prefixed;" >

<!ENTITY % DIAL.xmlns  "http://www.morfeo-project.org/2008/dial" >

<!ENTITY % DIAL.prefix  "dial" >

<![%DIAL.prefixed;[
<!ENTITY % DIAL.pfx  "%DIAL.prefix;:" >
]]>
<!ENTITY % DIAL.pfx  "" >

<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.extra.attrib
	"xmlns:%DIAL.prefix;	%URI.datatype;	#FIXED	'%DIAL.xmlns;'" >
]]>

<!ENTITY % DIAL.xmlns.extra.attrib "" >

<!-- Section B: DIAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % DIAL.a.qname  "%DIAL.pfx;a" >

<!-- end of dial-Hypertext-qname-1.mod -->
