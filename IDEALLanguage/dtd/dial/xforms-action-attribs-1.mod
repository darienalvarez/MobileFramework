<!-- .................................................................................................................... -->
<!-- .....................................XForm Action  Attributes Module  ...................................... -->
<!-- ...........................................xform-action-attribs-1.mod............................................ -->

<!ENTITY % boolean "(true|false)">
<!ENTITY % nonNegativeInteger "NMTOKEN">

<![%XForms.prefixed;[
<!ENTITY % XForms.name.attrib
     "%XForms.pfx;name        NMTOKEN 	#IMPLIED"
>
]]>
<!ENTITY % XForms.name.attrib
     "name        NMTOKEN 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.target.attrib
     "%XForms.pfx;target        IDREF 	#IMPLIED"
>
]]>
<!ENTITY % XForms.target.attrib
     "target        IDREF 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.bubbles.attrib
     "%XForms.pfx;bubbles        %boolean; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.bubbles.attrib
     "bubbles        %boolean; 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.cancelable.attrib
     "%XForms.pfx;cancelable        %boolean; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.cancelable.attrib
     "cancelable        %boolean; 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.resource.attrib
     "%XForms.pfx;resource        %URI.datatype; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.resource.attrib
     "resource        %URI.datatype; 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.show.attrib
     "%XForms.pfx;show        (new | replace) 	#IMPLIED"
>
]]>
<!ENTITY % XForms.show.attrib
     "show        (new | replace) 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.level.attrib
     "%XForms.pfx;level        (ephemeral | modeless| modal) 	#IMPLIED"
>
]]>
<!ENTITY % XForms.level.attrib
     "level        (ephemeral | modeless| modal) 	#IMPLIED"
>

<!-- end of xform-action-attribs-1.mod -->