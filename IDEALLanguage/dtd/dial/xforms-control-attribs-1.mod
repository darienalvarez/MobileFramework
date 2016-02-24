<!-- .................................................................................................................... -->
<!-- ....................................XForm Control Attributes Module  ...................................... -->
<!-- ...........................................xform-control-attribs-1.mod............................................ -->
<!ENTITY % boolean "(true|false)">

<![%XForms.prefixed;[
<!ENTITY % XForms.appearance.attrib
     "%XForms.pfx;appearance        (full|compact|minimal|QNameButNotNCNAME) 	#IMPLIED"
>
]]>
<!ENTITY % XForms.appearance.attrib
     "appearance        (full|compact|minimal|QNameButNotNCNAME) 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.ref.attrib
     "%XForms.pfx;ref        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.ref.attrib
     "ref        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.model.attrib
     "%XForms.pfx;model        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.model.attrib
     "model        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.bind.attrib
     "%XForms.pfx;bind        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.bind.attrib
     "bind        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.inputmode.attrib
     "%XForms.pfx;inputmode        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.inputmode.attrib
     "inputmode        CDATA 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.incremental.attrib
     "%XForms.pfx;incremental        %boolean; 	#IMPLIED"
>
]]>
<!ENTITY % XForms.incremental.attrib
     "incremental        %boolean; 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.value.attrib
     "%XForms.pfx;value        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.value.attrib
     "value        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.mediatype.attrib
     "%XForms.pfx;mediatype        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.mediatype.attrib
     "mediatype        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.start.attrib
     "%XForms.pfx;start        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.start.attrib
     "start        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.end.attrib
     "%XForms.pfx;end        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.end.attrib
     "end        CDATA 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.step.attrib
     "%XForms.pfx;step        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.step.attrib
     "step        CDATA 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.submission.attrib
     "%XForms.pfx;submission        IDREF 	#IMPLIED"
>
]]>
<!ENTITY % XForms.submission.attrib
     "submission        IDREF 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.selection.attrib
     "%XForms.pfx;selection        (open | closed) 	#IMPLIED"
>
]]>
<!ENTITY % XForms.selection.attrib
     "selection        (open | closed) 	#IMPLIED"
>

<!ENTITY % XForms.UICommon.attributes 
	"
     	%XForms.appearance.attrib;
	"
>

<!ENTITY % XForms.SingleNodeBinding.attributes 
	"
     	%XForms.ref.attrib;
     	%XForms.model.attrib;
     	%XForms.bind.attrib;
	"
>
	
	
<!-- end of xform-control-attribs-1.mod -->
