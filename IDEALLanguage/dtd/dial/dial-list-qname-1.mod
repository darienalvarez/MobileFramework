<!-- ..................................................................... -->
<!-- DIAL List Structural Module  ............................................ -->
<!-- file: dial-list-qname-1.mod......................................... -->

<!-- DIAL List Structural Qname (Qualified Name) Module -->

<!-- Section A: DIAL List Structural Namespace :::::::::::::::::::: -->

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

<!-- Section B: DIAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % DIAL.dl.qname  "%DIAL.pfx;dl" >
<!ENTITY % DIAL.di.qname  "%DIAL.pfx;di" >
<!ENTITY % DIAL.dt.qname  "%DIAL.pfx;dt" >
<!ENTITY % DIAL.dd.qname  "%DIAL.pfx;dd" >
<!ENTITY % DIAL.nl.qname  "%DIAL.pfx;nl" >
<!ENTITY % DIAL.ol.qname  "%DIAL.pfx;ol" >
<!ENTITY % DIAL.ul.qname  "%DIAL.pfx;ul" >
<!ENTITY % DIAL.li.qname  "%DIAL.pfx;li" >
<!ENTITY % DIAL.src.qname  "%DIAL.pfx;src" >

<!ENTITY % DIAL.label.qname  "%DIAL.pfx;label" >

<!-- end of dial-list-qname-1.mod -->
