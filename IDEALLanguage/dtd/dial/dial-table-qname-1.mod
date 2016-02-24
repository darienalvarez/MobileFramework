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
<!ENTITY % dial-table-qname-extra.mod "" >
%dial-table-qname-extra.mod;

<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.extra.attrib
	"xmlns:%DIAL.prefix;	%URI.datatype;	#FIXED	'%DIAL.xmlns;'" >
]]>

<!ENTITY % DIAL.xmlns.extra.attrib "" >


<!-- Section B: DIAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % DIAL.table.qname  "%DIAL.pfx;table" >
<!ENTITY % DIAL.caption.qname  "%DIAL.pfx;caption" >
<!ENTITY % DIAL.thead.qname  "%DIAL.pfx;thead" >
<!ENTITY % DIAL.tfoot.qname  "%DIAL.pfx;tfoot" >
<!ENTITY % DIAL.tbody.qname  "%DIAL.pfx;tbody" >
<!ENTITY % DIAL.colgroup.qname  "%DIAL.pfx;colgroup" >
<!ENTITY % DIAL.col.qname  "%DIAL.pfx;col" >
<!ENTITY % DIAL.tr.qname  "%DIAL.pfx;tr" >
<!ENTITY % DIAL.th.qname  "%DIAL.pfx;th" >
<!ENTITY % DIAL.td.qname  "%DIAL.pfx;td" >

<!-- Attributes -->
<!ENTITY % DIAL.align.qname 			"%DIAL.pfx;align">
<!ENTITY % DIAL.char.qname 			"%DIAL.pfx;char">
<!ENTITY % DIAL.charoff.qname 		"%DIAL.pfx;charoff">

<!ENTITY % DIAL.valign.qname 			"%DIAL.pfx;valign">

<!ENTITY % DIAL.scope.qname 			"%DIAL.pfx;scope">

<!-- Table attributes -->
<!ENTITY % DIAL.summary.qname 			"%DIAL.pfx;summary">

<!-- Colgroup and col attributes -->
<!ENTITY % DIAL.span.qname 			"%DIAL.pfx;span">

<!-- Th and tr attributes -->
<!ENTITY % DIAL.abbr.qname 			"%DIAL.pfx;abbr">
<!ENTITY % DIAL.axis.qname 			"%DIAL.pfx;axis">
<!ENTITY % DIAL.headers.qname 			"%DIAL.pfx;headers">
<!ENTITY % DIAL.rowspan.qname 			"%DIAL.pfx;rowspan">
<!ENTITY % DIAL.colspan.qname 			"%DIAL.pfx;colspan">
<!ENTITY % DIAL.axis.qname 			"%DIAL.pfx;axis">

<!-- end of dial-table-qname-1.mod -->
