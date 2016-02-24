<!-- ...................................................................... -->
<!-- XForm Control Module ................................................... -->
<!-- file: xform-control-1.mod

	xmlns:xforms="http://www.w3.org/2002/xforms"
     ...................................................................... 
-->

<!-- Define the global namespace attributes -->
<![%XForms.prefixed;[
<!ENTITY % XForms.xmlns.attrib
    "%NS.decl.attrib;"
>
]]>
<!ENTITY % XForms.xmlns.attrib
	 "%NS.decl.attrib; 
	 xmlns	%URI.datatype;	#FIXED '%XForms.xmlns;' "
>

<!-- namespaces attributes for root element -->
<!ENTITY % documentElementattributes 
	" xmlns:%XForms.prefix; CDATA 'http://www.w3.org/2002/xforms'	
	">

<!-- XForms.extra.attributes lets to include new attributes in all xform elements,   -->
<!ENTITY % XForms.extra.attributes "" >


<!ENTITY % XForms.UICommon.class " (%XForms.help.qname; | %XForms.hint.qname; | %XForms.alert.qname; | %XForms.Action.class;)*" >
<!ENTITY % XForms.ListUICommon.class "(%XForms.choices.qname; | %XForms.item.qname; | %XForms.itemset.qname; )+" >
<!ENTITY % XForms.Extra.Controls.class "">
<!ENTITY % XForms.Controls.class " (%XForms.input.qname; | %XForms.secret.qname; | %XForms.textarea.qname; | %XForms.output.qname; | %XForms.upload.qname; | %XForms.range.qname; | %XForms.trigger.qname; | %XForms.submit.qname; | %XForms.select.qname; | %XForms.select1.qname; %XForms.Extra.Controls.class;)*" >
<!ENTITY % XForms.UIInline.class "%XForms.output.qname;" >

<!-- Elements -->

<!-- input.element -->
<!ENTITY % XForms.input.element  "INCLUDE" >
<![%XForms.input.element;[
<!ENTITY % XForms.input.content  "(%XForms.label.qname;, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.input.qname;  %XForms.input.content; >
]]>

<!ATTLIST %XForms.input.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.inputmode.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;	
>
<!-- end of input.element -->


<!-- secret.element -->
<!ENTITY % XForms.secret.element  "INCLUDE" >
<![%XForms.secret.element;[
<!ENTITY % XForms.secret.content  "(%XForms.label.qname;, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.secret.qname;  %XForms.secret.content; >
]]>

<!ATTLIST %XForms.secret.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.inputmode.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of secret.element -->

<!-- textarea.element -->
<!ENTITY % XForms.textarea.element  "INCLUDE" >
<![%XForms.textarea.element;[
<!ENTITY % XForms.textarea.content  "(%XForms.label.qname;, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.textarea.qname;  %XForms.textarea.content; >
]]>

<!ATTLIST %XForms.textarea.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.inputmode.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of textarea.element -->

<!-- output.element -->
<!ENTITY % XForms.output.element  "INCLUDE" >
<![%XForms.output.element;[
<!ENTITY % XForms.output.content  "(%XForms.label.qname;)?" >
<!ELEMENT %XForms.output.qname;  %XForms.output.content; >
]]>

<!ATTLIST %XForms.output.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.appearance.attrib;
	%XForms.value.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of output.element -->

<!-- upload.element -->
<!ENTITY % XForms.upload.element  "INCLUDE" >
<![%XForms.upload.element;[
<!ENTITY % XForms.upload.content  "(%XForms.label.qname;, %XForms.filename.qname;?, %XForms.mediatype.qname;?, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.upload.qname;  %XForms.upload.content; >
]]>

<!ATTLIST %XForms.upload.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.mediatype.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of upload.element -->

<!-- range.element -->
<!ENTITY % XForms.range.element  "INCLUDE" >
<![%XForms.range.element;[
<!ENTITY % XForms.range.content  "(%XForms.label.qname; , (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.range.qname;  %XForms.range.content; >
]]>

<!ATTLIST %XForms.range.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.start.attrib;
	%XForms.end.attrib;
	%XForms.step.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of range.element -->

<!-- trigger.element -->
<!ENTITY % XForms.trigger.element  "INCLUDE" >
<![%XForms.trigger.element;[
<!ENTITY % XForms.trigger.content  "(%XForms.label.qname; , (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.trigger.qname;  %XForms.trigger.content; >
]]>

<!ATTLIST %XForms.trigger.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of trigger.element -->

<!-- submit.element -->
<!ENTITY % XForms.submit.element  "INCLUDE" >
<![%XForms.submit.element;[
<!ENTITY % XForms.submit.content  "(%XForms.label.qname; , (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.submit.qname;  %XForms.submit.content; >
]]>

<!ATTLIST %XForms.submit.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.submission.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of submit.element -->

<!-- select.element -->
<!ENTITY % XForms.select.element  "INCLUDE" >
<![%XForms.select.element;[
<!ENTITY % XForms.select.content  "(%XForms.label.qname; , (%XForms.ListUICommon.class;)+, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.select.qname;  %XForms.select.content; >
]]>

<!ATTLIST %XForms.select.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.selection.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of select.element -->

<!-- select1.element -->
<!ENTITY % XForms.select1.element  "INCLUDE" >
<![%XForms.select1.element;[
<!ENTITY % XForms.select1.content  "(%XForms.label.qname; , (%XForms.ListUICommon.class;)+, (%XForms.UICommon.class;)*)" >
<!ELEMENT %XForms.select1.qname;  %XForms.select1.content; >
]]>

<!ATTLIST %XForms.select1.qname;
	%XForms.common.attributes;
	%XForms.UICommon.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.selection.attrib;
	%XForms.incremental.attrib;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of select1.element -->

<!-- choices.element -->
<!ENTITY % XForms.choices.element  "INCLUDE" >
<![%XForms.choices.element;[
<!ENTITY % XForms.choices.content  "(%XForms.label.qname; , (%XForms.ListUICommon.class;)+)" >
<!ELEMENT %XForms.choices.qname;  %XForms.choices.content; >
]]>

<!ATTLIST %XForms.choices.qname;
	%XForms.common.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of choices.element -->

<!-- item.element -->
<!ENTITY % XForms.item.element  "INCLUDE" >
<![%XForms.item.element;[
<!ENTITY % XForms.item.content  "(%XForms.label.qname; , %XForms.value.qname;, (%XForms.ListUICommon.class;)+)" >
<!ELEMENT %XForms.item.qname;  %XForms.item.content; >
]]>

<!ATTLIST %XForms.item.qname;
	%XForms.common.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of item.element -->

<!-- filename.element -->
<!ENTITY % XForms.filename.element  "INCLUDE" >
<![%XForms.filename.element;[
<!ENTITY % XForms.filename.content  "(EMPTY)" >
<!ELEMENT %XForms.filename.qname;  %XForms.filename.content; >
]]>

<!ATTLIST %XForms.filename.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of filename.element -->

<!-- mediatype.element -->
<!ENTITY % XForms.mediatype.element  "INCLUDE" >
<![%XForms.mediatype.element;[
<!ENTITY % XForms.mediatype.content  "(EMPTY)" >
<!ELEMENT %XForms.mediatype.qname;  %XForms.mediatype.content; >
]]>

<!ATTLIST %XForms.filename.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of mediatype.element -->

<!-- value.element -->
<!ENTITY % XForms.value.element  "INCLUDE" >
<![%XForms.value.element;[
<!ENTITY % XForms.value.content  "(#PCDATA)" >
<!ELEMENT %XForms.value.qname;  %XForms.value.content; >
]]>

<!ATTLIST %XForms.value.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of value.element -->

<!-- label.element -->
<!ENTITY % XForms.label.element  "INCLUDE" >
<![%XForms.label.element;[
<!ENTITY % XForms.label.content  "( #PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %XForms.label.qname;  %XForms.label.content; >
]]>

<!ATTLIST %XForms.label.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.Linking.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of label.element -->

<!-- help.element -->
<!ENTITY % XForms.help.element  "INCLUDE" >
<![%XForms.help.element;[
<!ENTITY % XForms.help.content  "(#PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %XForms.help.qname;  %XForms.help.content; >
]]>

<!ATTLIST %XForms.help.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.Linking.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of help.element -->

<!-- hint.element -->
<!ENTITY % XForms.hint.element  "INCLUDE" >
<![%XForms.hint.element;[
<!ENTITY % XForms.hint.content  "(#PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %XForms.hint.qname;  %XForms.hint.content; >
]]>

<!ATTLIST %XForms.hint.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.Linking.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of hint.element -->

<!-- alert.element -->
<!ENTITY % XForms.alert.element  "INCLUDE" >
<![%XForms.alert.element;[
<!ENTITY % XForms.alert.content  "(#PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %XForms.alert.qname;  %XForms.alert.content; >
]]>

<!ATTLIST %XForms.alert.qname;
	%XForms.common.attributes;
	%XForms.SingleNodeBinding.attributes;
	%XForms.Linking.attributes;
	%XForms.extra.attributes;
	%Common.attrib;		
>
<!-- end of alert.element -->


<!-- end of xform-control-1.mod -->