<!-- .................................................................................................................... -->
<!-- .....................................XForm UI  Attributes Module  ...................................... -->
<!-- ...........................................xform-ui-attribs-1.mod............................................ -->

<!ENTITY % boolean "(true|false)">
<!ENTITY % nonNegativeInteger "NMTOKEN">

<![%XForms.prefixed;[
<!ENTITY % XForms.selected.attrib
     "%XForms.pfx;selected        %boolean; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.selected.attrib
     "selected        %boolean; 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.case.attrib
     "%XForms.pfx;case        IDREF 	#IMPLIED"
>
]]>
<!ENTITY % XForms.case.attrib
     "case        IDREF 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.startindex.attrib
     "%XForms.pfx;startindex         %Number.datatype;  	#IMPLIED"
>
]]>
<!ENTITY % XForms.startindex.attrib
     "startindex         %Number.datatype;  	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.number.attrib
     "%XForms.pfx;number        %nonNegativeInteger; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.number.attrib
     "number        %nonNegativeInteger; 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.at.attrib
     "%XForms.pfx;at        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.at.attrib
     "at        CDATA 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.position.attrib
     "%XForms.pfx;position        (before|after) 	#IMPLIED"
>
]]>
<!ENTITY % XForms.position.attrib
     "position        (before|after) 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.repeat.attrib
     "%XForms.pfx;repeat        IDREF 	#IMPLIED"
>
]]>
<!ENTITY % XForms.repeat.attrib
     "repeat        IDREF 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.index.attrib
     "%XForms.pfx;index        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.index.attrib
     "index        CDATA 	#IMPLIED"
>

<!ENTITY % XForms.NodeSetBinding.attributes
     "
     %XForms.nodeset.attrib;
     %XForms.model.attrib;
     %XForms.bind.attrib;
	"
>

<!-- end of xform-ui-attribs-1.mod -->
