<!-- .................................................................................................................... -->
<!-- .....................................Ideal Common Attributes Module  ...................................... -->
<!-- ...........................................ideal-attribs-1.mod............................................ -->

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.bindingtype.attrib
     "%IDEAL.pfx;bindingtype           CDATA           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.bindingtype.attrib
     "bindingtype         CDATA           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.beantype.attrib
     "%IDEAL.pfx;beantype           CDATA           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.beantype.attrib
     "beantype         CDATA           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.decorator.attrib
     "%IDEAL.pfx;decorator           %URI.datatype;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.decorator.attrib
     "decorator         %URI.datatype;           #IMPLIED"
>


<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.handler.attrib
     "%IDEAL.pfx;handler           %URI.datatype;          #IMPLIED"
>
]]>
<!ENTITY % IDEAL.handler.attrib
     "handler         %URI.datatype;           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.type.attrib
     "%IDEAL.pfx;type           %QName;          #IMPLIED"
>
]]>
<!ENTITY % IDEAL.type.attrib
     "type         %QName;           #IMPLIED"
>


<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.pattern.attrib
     "%IDEAL.pfx;pattern           CDATA          #IMPLIED"
>
]]>
<!ENTITY % IDEAL.pattern.attrib
     "pattern         CDATA           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.enumeration.attrib
     "%IDEAL.pfx;enumeration           %anySimpleType;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.enumeration.attrib
     "enumeration         %anySimpleType;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.whiteSpace.attrib
     "%IDEAL.pfx;whiteSpace            (preserve | replace | collapse)            #IMPLIED"
>
]]>
<!ENTITY % IDEAL.whiteSpace.attrib
     "whiteSpace         (preserve | replace | collapse)            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.length.attrib
     "%IDEAL.pfx;length           %nonNegativeInteger;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.length.attrib
     "length         %nonNegativeInteger;            #IMPLIED"
>
<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.maxlength.attrib
     "%IDEAL.pfx;maxlength           %nonNegativeInteger;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.maxlength.attrib
     "maxlength         %nonNegativeInteger;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.minlength.attrib
     "%IDEAL.pfx;minlength           %positiveInteger;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.minlength.attrib
     "minlength         %nonNegativeInteger;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.totalDigits.attrib
     "%IDEAL.pfx;totalDigits           %positiveInteger;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.totalDigits.attrib
     "totalDigits         %positiveInteger;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.fractionDigits.attrib
     "%IDEAL.pfx;fractionDigits           %nonNegativeInteger;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.fractionDigits.attrib
     "fractionDigits         %nonNegativeInteger;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.maxInclusive.attrib
     "%IDEAL.pfx;maxInclusive           %anySimpleType;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.maxInclusive.attrib
     "maxInclusive         %anySimpleType;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.maxExclusive.attrib
     "%IDEAL.pfx;maxExclusive           %anySimpleType;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.maxExclusive.attrib
     "maxExclusive         %anySimpleType;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.minInclusive.attrib
     "%IDEAL.pfx;minInclusive           %anySimpleType;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.minInclusive.attrib
     "minInclusive         %anySimpleType;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.minExclusive.attrib
     "%IDEAL.pfx;minExclusive           %anySimpleType;           #IMPLIED"
>
]]>	
<!ENTITY % IDEAL.minExclusive.attrib
     "minExclusive         %anySimpleType;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.locale.attrib
     "%IDEAL.pfx;locale           CDATA           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.locale.attrib
     "locale         CDATA            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.timeZone.attrib
     "%IDEAL.pfx;timeZone           %dateTime;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.timeZone.attrib
     "timeZone         %dateTime;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.if.attrib
     "%IDEAL.pfx;if           %XPathExpression;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.if.attrib
     "if         %XPathExpression;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % DIAL.src.attrib
     "%IDEAL.pfx;src           %URI.datatype;           #IMPLIED"
>
]]>
<!ENTITY % DIAL.src.attrib
     "src           %URI.datatype;           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % DIAL.srctype.attrib
     "%IDEAL.pfx;srctype           %ContentType.datatype;           #IMPLIED"
>
]]>
<!ENTITY % DIAL.srctype.attrib
     "srctype           %ContentType.datatype;           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % DIAL.encoding.attrib
     "%IDEAL.pfx;encoding           %Text.datatype;           #IMPLIED"
>
]]>
<!ENTITY % DIAL.encoding.attrib
     "encoding           %Text.datatype;           #IMPLIED"
>


<!ENTITY % embedding.attrib	"
				%DIAL.src.attrib;
				%DIAL.srctype.attrib;
				%DIAL.encoding.attrib;
">

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.formatter.attrib
     "%IDEAL.pfx;formatter         IDREF           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.formatter.attrib
     "formatter         IDREF           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.validator.attrib
     "%IDEAL.pfx;validator         IDREF           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.validator.attrib
     "validator         IDREF           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.targetrole.attrib
     "%IDEAL.pfx;targetrole         %CURIEs.datatype;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.targetrole.attrib
     "targetrole         %CURIEs.datatype;           #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.targetid.attrib
     "%IDEAL.pfx;targetid         %IDREFs.datatype;           #IMPLIED"
>
]]>
<!ENTITY % IDEAL.targetid.attrib
     "targetid         %IDREFs.datatype;           #IMPLIED"
>

<!ENTITY % XML.Events.extra.attrib
     "
     %IDEAL.targetrole.attrib;
     %IDEAL.targetid.attrib;
     %IDEAL.if.attrib;
     "
>

<!ENTITY % IDEAL.xmlAttrs.prefixed "INCLUDE" >
<!ENTITY % IDEAL.xmlAttrs.pfx "xml:" >


<![%IDEAL.xmlAttrs.prefixed;[
<!ENTITY % xml:id.attrib
     "%IDEAL.xmlAttrs.pfx;id           ID           #IMPLIED"
>
]]>
<!ENTITY % xml:id.attrib
     "id           ID            #IMPLIED"
>

<![%IDEAL.xmlAttrs.prefixed;[
<!ENTITY % xml:space.attrib
     "%IDEAL.xmlAttrs.pfx;space           (default|preserve)            #IMPLIED"
>
]]>
<!ENTITY % xml:space.attrib
     "space           (default|preserve)            #IMPLIED"
>

<![%IDEAL.xmlAttrs.prefixed;[
<!ENTITY % xml:lang.attrib
     "%IDEAL.xmlAttrs.pfx;lang           %Text.datatype;            #IMPLIED"
>
]]>   
<!ENTITY % xml:lang.attrib
     "lang           %Text.datatype;            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.class.attrib
     "%IDEAL.pfx;class           NMTOKENS            #IMPLIED"
>
]]>      
<!ENTITY % IDEAL.class.attrib
     "class           NMTOKENS            #IMPLIED"
>

<![%IDEAL.attrs.prefixed;[
<!ENTITY % IDEAL.title.attrib
     "%IDEAL.pfx;title           %Text.datatype;            #IMPLIED"
>
]]>    
<!ENTITY % IDEAL.title.attrib
     "title           %Text.datatype;            #IMPLIED"
>

<!ENTITY % Common.attrib	"
				%xml:space.attrib;				
				%xml:id.attrib;
				%xml:lang.attrib;
				%IDEAL.class.attrib;
				%IDEAL.title.attrib;
				%xhtml-role.attrs.qname;
				%DISelect.expr.attrib;
				%DISelect.selid.attrib;
				
">

<!-- end of ideal-attribs-1.mod -->
