<!-- ..................................................................... -->
<!-- DIAL Structure Module  ................................................... -->
<!-- file: dial-struct-qname-1.mod............................................ -->


<!-- DIAL Block Struct Qname (Qualified Name) Module -->

<!-- Section A: DIAL Block Struct Namespace :::::::::::::::::::: -->

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


<!-- Block Elements -->
<!ENTITY % DIAL.div.qname 							"%DIAL.pfx;div">
<!ENTITY % DIAL.section.qname 							"%DIAL.pfx;section">
<!ENTITY % DIAL.p.qname 							"%DIAL.pfx;p">
<!ENTITY % DIAL.h.qname  							"%DIAL.pfx;h" >
<!ENTITY % DIAL.separator.qname 						"%DIAL.pfx;separator">



