<!-- ..................................................................... -->
<!-- DIAL Table Qname Module  ............................................ -->
<!-- file: dial-table-qname-1.mod......................................... -->

<!-- DIAL Table Qname (Qualified Name) Module -->

<!-- Section A: DIAL Table Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % DIAL.prefixed "%NS.prefixed;" >

<!ENTITY % DIAL.xmlns  "http://www.morfeo-project.org/2008/dial" >

<!ENTITY % DIAL.prefix  "dial" >

<![%DIAL.prefixed;[
<!ENTITY % DIAL.pfx  "%DIAL.prefix;:" >
]]>
<!ENTITY % DIAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % dial-object-qname-extra.mod "" >
%dial-object-qname-extra.mod;

<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.extra.attrib
	"xmlns:%DIAL.prefix;	%URI.datatype;	#FIXED	'%DIAL.xmlns;'" >
]]>

<!ENTITY % DIAL.xmlns.extra.attrib "" >

<!-- Section B: DIAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % DIAL.object.qname  "%DIAL.pfx;object" >

<!-- Attributes -->
<!ENTITY % DIAL.align.qname 			"%DIAL.pfx;align">
<!ENTITY % DIAL.declare.qname 			"%DIAL.pfx;declare">
<!ENTITY % DIAL.classid.qname 			"%DIAL.pfx;classid">
<!ENTITY % DIAL.codebase.qname 			"%DIAL.pfx;codebase">
<!ENTITY % DIAL.data.qname 				"%DIAL.pfx;data">
<!ENTITY % DIAL.type.qname 				"%DIAL.pfx;type">
<!ENTITY % DIAL.codetype.qname 			"%DIAL.pfx;codetype">
<!ENTITY % DIAL.archive.qname 			"%DIAL.pfx;archive">
<!ENTITY % DIAL.standby.qname 			"%DIAL.pfx;standby">
<!ENTITY % DIAL.height.qname 			"%DIAL.pfx;height">
<!ENTITY % DIAL.name.qname 				"%DIAL.pfx;name">
<!ENTITY % DIAL.tabindex.qname 			"%DIAL.pfx;tabindex">
<!ENTITY % DIAL.param.qname 			"%DIAL.pfx;param">

<!-- end of dial-object-qname-1.mod -->
