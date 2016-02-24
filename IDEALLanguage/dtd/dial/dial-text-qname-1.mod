<!-- ..................................................................... -->
<!-- DIAL Inline Phrase Module  ............................................ -->
<!-- file: dial-inlphras-qname-1.mod......................................... -->

<!-- DIAL Inline Phrase Qname (Qualified Name) Module -->

<!-- Section A: DIAL Inline Phrase Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % DIAL.prefixed "%NS.prefixed;" >

<!ENTITY % DIAL.xmlns  "http://www.morfeo-project.org/2008/dial" >

<!ENTITY % DIAL.prefix  "dial" >

<![%DIAL.prefixed;[
<!ENTITY % DIAL.pfx  "%DIAL.prefix;:" >
]]>
<!ENTITY % DIAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % dial-inlstruct-qname-extra.mod "" >
%dial-inlstruct-qname-extra.mod;

<![%DIAL.prefixed;[
<!ENTITY % DIAL.xmlns.extra.attrib
	"xmlns:%DIAL.prefix;	%URI.datatype;	#FIXED	'%DIAL.xmlns;'" >
]]>

<!ENTITY % DIAL.xmlns.extra.attrib "" >

<!-- Section B: DIAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % DIAL.abbr.qname  "%DIAL.pfx;abbr" >
<!ENTITY % DIAL.cite.qname  "%DIAL.pfx;cite" >
<!ENTITY % DIAL.code.qname  "%DIAL.pfx;code" >
<!ENTITY % DIAL.dfn.qname  "%DIAL.pfx;dfn" >
<!ENTITY % DIAL.em.qname  "%DIAL.pfx;em" >
<!ENTITY % DIAL.kbd.qname  "%DIAL.pfx;kbd" >
<!ENTITY % DIAL.l.qname  "%DIAL.pfx;l" >
<!ENTITY % DIAL.q.qname  "%DIAL.pfx;q" >
<!ENTITY % DIAL.samp.qname  "%DIAL.pfx;samp" >
<!ENTITY % DIAL.strong.qname  "%DIAL.pfx;strong" >
<!ENTITY % DIAL.sub.qname  "%DIAL.pfx;sub" >
<!ENTITY % DIAL.sup.qname  "%DIAL.pfx;sup" >
<!ENTITY % DIAL.var.qname  "%DIAL.pfx;var" >
<!ENTITY % DIAL.span.qname  "%DIAL.pfx;span" >

<!ENTITY % Text.class "	%DIAL.abbr.qname; |
			%DIAL.cite.qname; | 		
			%DIAL.code.qname; | 			
			%DIAL.dfn.qname; | 
			%DIAL.em.qname; | 
			%DIAL.kbd.qname; | 
			%DIAL.l.qname; | 
			%DIAL.q.qname; | 
			%DIAL.samp.qname; | 
			%DIAL.span.qname; | 			
			%DIAL.strong.qname; | 
			%DIAL.sub.qname; | 
			%DIAL.sup.qname; | 			
			%DIAL.var.qname; 
				" >
				
<!-- end of dial-text-qname-1.mod -->