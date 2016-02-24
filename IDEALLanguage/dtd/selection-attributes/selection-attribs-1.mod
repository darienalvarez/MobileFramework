<!-- ........................................................................................................ -->
<!-- .....................................Selection Attributes Module  ...................................... -->

<!-- file: selection-attribs-1.mod

     This is XHTML-Selection Attributes modules for general purpose content selection or filtering.     
     
     This DTD module is identified by the PUBLIC and SYSTEM identifiers:

       PUBLIC "-//W3C//ENTITIES Selection Attributes 1.0//EN"
       SYSTEM "selection-attribs-1.mod"

     Revisions:
     (none)
     ....................................................................... -->


<![%SELATTRIBUTES.prefixed;[
<!ENTITY % selection.expr.attrib
     "%SELATTRIBUTES.prefix;:expr           CDATA        #IMPLIED"
>
]]>
<!ENTITY % selection.expr.attrib
     "expr        CDATA             #IMPLIED"
>


<![%SELATTRIBUTES.prefixed;[
<!ENTITY % selection.selid.attrib
     "%SELATTRIBUTES.prefix;:selid           CDATA        #IMPLIED"
>
]]>
<!ENTITY % selection.selid.attrib
     "selid        CDATA             #IMPLIED"
>


<![%SELATTRIBUTES.prefixed;[
<!ENTITY % selection.selidname.attrib
     "%SELATTRIBUTES.prefix;:selidname           CDATA        #IMPLIED"
>
]]>
<!ENTITY % selection.selidname.attrib
     "selidname        CDATA             #IMPLIED"
>


<!-- Define a common set of attributes for all module elements -->
<!ENTITY % selection.attributes
		"
		%selection.expr.attrib;
		%selection.selid.attrib;
	  	%selection.selidname.attrib;
	  	"
>

<!-- end of selection-attribs-1.mod -->