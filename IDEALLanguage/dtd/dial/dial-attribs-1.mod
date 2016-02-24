<!-- .................................................................................................................... -->
<!-- .....................................Common Attributes Module  ...................................... -->
<!-- ...........................................dial-attribs-1.mod............................................ -->

<!-- Attributes for navigation list -->


<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.id.attrib
     "%DIAL.pfx;id           ID           #IMPLIED"
>
]]>


<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.src.attrib
     "%DIAL.pfx;src           %URI.datatype;           #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.srctype.attrib
     "%DIAL.pfx;srctype           %ContentType.datatype;           #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.encoding.attrib
     "%DIAL.pfx;encoding           %Text.datatype;           #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.href.attrib
     "%DIAL.pfx;href           %URI.datatype;           #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.hreftype.attrib
     "%DIAL.pfx;hreftype           %ContentType.datatype;           #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.nextfocus.attrib
     "%DIAL.pfx;nextfocus           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.prevfocus.attrib
     "%DIAL.pfx;prevfocus           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.hrefmedia.attrib
     "%DIAL.pfx;hrefmedia           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.hreflang.attrib
     "%DIAL.pfx;hreflang           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.xml:base.attrib
     "%DIAL.pfx;xml:base           %URI.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.title.attrib
     "%DIAL.pfx;title           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.full.attrib
     "%DIAL.pfx;full           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.rel.attrib
     "%DIAL.pfx;rel           CDATA            #IMPLIED"
>
]]>


<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.rev.attrib
     "%DIAL.pfx;rev           CDATA            #IMPLIED"
>
]]>
    
<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.declare.attrib
     "%DIAL.pfx;declare           %Text.datatype;            #IMPLIED"
>
]]>

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.xml:base.attrib
     "%DIAL.pfx;xml:base           %Text.datatype;            #IMPLIED"
>
]]>      
      
<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.name.attrib
     "%DIAL.pfx;name           %Text.datatype;            #IMPLIED"
>
]]>      

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.value.attrib
     "%DIAL.pfx;value           %Text.datatype;            #IMPLIED"
>
]]>      
      
<!ENTITY % DIAL.extra.bind.attrib "" >

<!ENTITY % DIAL.extra.repeat.attrib "" >

<!ENTITY % DIAL.extra.misc.attrib "" >



<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.xml:space.attrib
     "%DIAL.pfx;xml:space           (default|preserve)            #IMPLIED"
>
]]>      


<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.xml:id.attrib
     "%DIAL.pfx;xml:id           %Text.datatype;            #IMPLIED"
>
]]>      

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.xml:lang.attrib
     "%DIAL.pfx;xml:lang           %Text.datatype;            #IMPLIED"
>
]]>      

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.class.attrib
     "%DIAL.pfx;class           NMTOKENS            #IMPLIED"
>
]]>      


<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.title.attrib
     "%DIAL.pfx;title           %Text.datatype;            #IMPLIED"
>
]]>      

<![%DIAL.common.attrs.prefixed;[
<!ENTITY % DIAL.sel:expr.attrib
     "%DIAL.pfx;sel:expr           %Text.datatype;            #IMPLIED"
>
]]>      


<!ENTITY % Common.attrib	"
				%DIAL.xml:space.attrib;				
				%DIAL.xml:id.attrib;
				%DIAL.xml:lang.attrib;
				%DIAL.xml:base.attrib;
				%DIAL.class.attrib;
				%DIAL.title.attrib;
				%xhtml-role.attrs.qname;
				%DISelect.expr.attrib;
				
">

<!ENTITY % embedding.attrib	"
				%DIAL.src.attrib;
				%DIAL.srctype.attrib;
				%DIAL.encoding.attrib;
">

<!ENTITY % hypertext.attrib	"
				%DIAL.href.attrib;
				%DIAL.hreftype.attrib;
				%DIAL.hrefmedia.attrib;
				%DIAL.hreflang.attrib;
				%DIAL.nextfocus.attrib;
				%DIAL.prevfocus.attrib;
">


<!-- end of dial-attribs-1.mod -->
