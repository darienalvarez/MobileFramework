<!-- .................................................................................................................... -->
<!-- .....................................Common Attributes Module  ...................................... -->
<!-- ...........................................diselect-attribs-1.mod............................................ -->

<![%DISelect.prefixed;[
<!ENTITY % DISelect.expr.attrib
     "%DISelect.pfx;expr        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.expr.attrib
     "expr        CDATA       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.selid.attrib
     "%DISelect.pfx;selid        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.selid.attrib
     "selid        CDATA       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.selidname.attrib
     "%DISelect.pfx;selidname        IDREF       #IMPLIED"
>
]]>
<!ENTITY % DISelect.selidname.attrib
     "selidname        IDREF       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.functions.attrib
     "%DISelect.pfx;functions        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.functions.attrib
     "functions        CDATA       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.precept.attrib
     "%DISelect.pfx;precept        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.precept.attrib
     "precept        CDATA       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.ref.attrib
     "%DISelect.pfx;ref        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.ref.attrib
     "ref        CDATA       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.name.attrib
     "%DISelect.pfx;name        (matchfirst | matchevery)       #IMPLIED"
>
]]>
<!ENTITY % DISelect.name.attrib
     "name        (matchfirst | matchevery)       #IMPLIED"
>

<![%DISelect.prefixed;[
<!ENTITY % DISelect.value.attrib
     "%DISelect.pfx;value        CDATA       #IMPLIED"
>
]]>
<!ENTITY % DISelect.value.attrib
     "value        CDATA       #IMPLIED"
>

<!-- Define a common set of attributes for all module elements -->
<!ENTITY % DISelect.Common.attributes
		"
		%DISelect.expr.attrib;
		%DISelect.selid.attrib;
	  	%DISelect.selidname.attrib;
	  	%DISelect.functions.attrib;
	  	"
>


<!-- end of dial-attribs-1.mod -->
