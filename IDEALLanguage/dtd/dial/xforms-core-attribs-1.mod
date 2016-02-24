<!-- .................................................................................................................... -->
<!-- .....................................Common Attributes Module  ...................................... -->
<!-- ...........................................xform-core-attribs-1.mod............................................ -->

<!ENTITY % boolean "(true|false)">

<![%XForms.prefixed;[
<!ENTITY % XForms.id.attrib
     "%XForms.pfx;id        ID 	#IMPLIED"
>
]]>
<!ENTITY % XForms.id.attrib
     "id        ID 	#IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.anyAtribute.attrib
     "%XForms.pfx;anyAtribute        CDATA 	#IMPLIED"
>
]]>
<!ENTITY % XForms.anyAtribute.attrib
     "anyAtribute        CDATA 	#IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.functions.attrib
     "%XForms.pfx;functions        QNameList       #IMPLIED"
>
]]>
<!ENTITY % XForms.functions.attrib
     "functions        QNameList       #IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.schema.attrib
     "%XForms.pfx;schema        %URI.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.schema.attrib
     "schema        %URI.datatype;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.version.attrib
     "%XForms.pfx;version        CDATA       #IMPLIED"
>
]]>
<!ENTITY % XForms.version.attrib
     "version        CDATA       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.src.attrib
     "%XForms.pfx;src        %URI.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.src.attrib
     "src        %URI.datatype;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.ref.attrib
     "%XForms.pfx;ref        %URI.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.ref.attrib
     "ref        %URI.datatype;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.bind.attrib
     "%XForms.pfx;bind        IDREF       #IMPLIED"
>
]]>
<!ENTITY % XForms.bind.attrib
     "bind        IDREF       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.action.attrib
     "%XForms.pfx;action        %URI.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.action.attrib
     "action        %URI.datatype;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.method.attrib
     "%XForms.pfx;method       (post |get|put|form-data-post|urlencoded-post|qname-but-not-ncname)       #IMPLIED"
>
]]>
<!ENTITY % XForms.method.attrib
     "method       (post |get|put|form-data-post|urlencoded-post|qname-but-not-ncname)       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.version.attrib
     "%XForms.pfx;version       NMTOKEN       #IMPLIED"
>
]]>
<!ENTITY % XForms.version.attrib
     "version       NMTOKEN       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.indent.attrib
     "%XForms.pfx;indent       %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.indent.attrib
     "indent       %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.mediatype.attrib
     "%XForms.pfx;mediatype       %ContentType.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.mediatype.attrib
     "mediatype       %ContentType.datatype;       #IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.encoding.attrib
     "%XForms.pfx;encoding       %Text.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.encoding.attrib
     "encoding       %Text.datatype;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.omit-xml-declaration.attrib
     "%XForms.pfx;omit-xml-declaration       %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.omit-xml-declaration.attrib
     "omit-xml-declaration       %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.standalone.attrib
     "%XForms.pfx;standalone       %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.standalone.attrib
     "standalone       %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.cdata-section-elements.attrib
     "%XForms.pfx;cdata-section-elements       CDATA       #IMPLIED"
>
]]>
<!ENTITY % XForms.cdata-section-elements.attrib
     "cdata-section-elements       CDATA       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.replace.attrib
     "%XForms.pfx;replace       (all|instance|none|QNameButNotNCNAME)       #IMPLIED"
>
]]>
<!ENTITY % XForms.replace.attrib
     "replace       (all|instance|none|QNameButNotNCNAME)       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.instance.attrib
     "%XForms.pfx;instance        IDREF       #IMPLIED"
>
]]>
<!ENTITY % XForms.instance.attrib
     "instance        IDREF       #IMPLIED"
>

<!ENTITY % semi "&#059;" >
<!ENTITY % amp "&amp;" >

<![%XForms.prefixed;[
<!ENTITY % XForms.separator.attrib
     "%XForms.pfx;separator        ("%semi;" | "&amp;")       #IMPLIED"
>
]]>
<!ENTITY % XForms.separator.attrib
     "separator        ("%semi;" | "&amp;")       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.includenamespaceprefixes.attrib
     "%XForms.pfx;includenamespaceprefixes        CDATA       #IMPLIED"
>
]]>
<!ENTITY % XForms.includenamespaceprefixes.attrib
     "includenamespaceprefixes        CDATA       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.nodeset.attrib
     "%XForms.pfx;nodeset        %URI.datatype;       #IMPLIED"
>
]]>
<!ENTITY % XForms.nodeset.attrib
     "nodeset        %URI.datatype;       #IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.type.attrib
     "%XForms.pfx;type        CDATA       #IMPLIED"
>
]]>
<!ENTITY % XForms.type.attrib
     "type        CDATA       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.readonly.attrib
     "%XForms.pfx;readonly        %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.readonly.attrib
     "readonly        %boolean;       #IMPLIED"
>


<![%XForms.prefixed;[
<!ENTITY % XForms.required.attrib
     "%XForms.pfx;required         %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.required.attrib
     "required         %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.relevant.attrib
     "%XForms.pfx;relevant         %boolean;       #IMPLIED"
>
]]>
<!ENTITY % XForms.relevant.attrib
     "relevant         %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.calculate.attrib
     "%XForms.pfx;calculate         CDATA       #IMPLIED"
>
]]>
<!ENTITY % XForms.calculate.attrib
     "calculate         CDATA       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.constraint.attrib
     "%XForms.pfx;constraint         %boolean;       #IMPLIED"
>
]]> 
<!ENTITY % XForms.constraint.attrib
     "constraint         %boolean;       #IMPLIED"
>

<![%XForms.prefixed;[
<!ENTITY % XForms.p3ptype.attrib
     "%XForms.pfx;p3ptype         CDATA       #IMPLIED"
>
]]> 
<!ENTITY % XForms.p3ptype.attrib
     "p3ptype         CDATA       #IMPLIED"
>
 

<!ENTITY % XForms.global.common.extra.attrib "" >

<!ENTITY % XForms.common.attributes
     "
     %XForms.id.attrib;
     %XForms.anyAtribute.attrib;
	"
>

<!ENTITY % XForms.Linking.attributes
     "
     %XForms.src.attrib;
	"
>

<!ENTITY % XForms.modelItem.attributes
     "
     %XForms.type.attrib;
     %XForms.readonly.attrib;
     %XForms.required.attrib;
     %XForms.relevant.attrib;
     %XForms.calculate.attrib;
     %XForms.constraint.attrib;
     %XForms.p3ptype.attrib;
	"
>

<!-- end of xform-core-attribs-1.mod -->
