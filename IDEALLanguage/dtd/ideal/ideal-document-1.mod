<!-- ...................................................................... -->
<!-- IDEAL document              ................................................... -->
<!-- file: ideal-document-1.mod	-->


<!-- ideal element................ -->

<!ENTITY % IDEAL.ideal.element  "INCLUDE" >
<![%IDEAL.ideal.element;[
<!ENTITY % IDEAL.ideal.content  " ( %IDEAL.metadata.qname;?, %IDEAL.accessibility.qname;?, %IDEAL.behaviour.qname;?, %IDEAL.definitions.qname;?, %body.qname;? ) " >
<!ELEMENT %IDEAL.ideal.qname;  %IDEAL.ideal.content; >

<!-- end of ideal.element -->]]>
<!ENTITY % IDEAL.ideal.attlist  "INCLUDE" >
<![%IDEAL.ideal.attlist;[
<!ATTLIST %IDEAL.ideal.qname;
	%Common.attrib;
	%IDEAL.xmlns.attrib;
>
<!-- end of ideal.attlist -->]]>


<!-- metadata element................ -->
<!ENTITY % IDEAL.metadata.element  "INCLUDE" >
<![%IDEAL.metadata.element;[
<!ENTITY % IDEAL.metadata.content  " (%title.qname;, ( %meta.qname;)*) " >
<!ELEMENT %IDEAL.metadata.qname;  %IDEAL.metadata.content; >
<!-- end of metadata.element -->]]>

<!ENTITY % IDEAL.metadata.attlist  "INCLUDE" >
<![%IDEAL.metadata.attlist;[
<!ATTLIST %IDEAL.metadata.qname;
	%Common.attrib;
>
<!-- end of metadata.attlist -->]]>

<!-- accessibility element................ -->
<!ENTITY % IDEAL.accessibility.element  "INCLUDE" >
<![%IDEAL.accessibility.element;[
<!ENTITY % IDEAL.accessibility.content  " ( %XHTML-ACCESS.access.qname;)* " >
<!ELEMENT %IDEAL.accessibility.qname;  %IDEAL.accessibility.content; >
<!-- end of accessibility.element -->]]>

<!ENTITY % IDEAL.accessibility.attlist  "INCLUDE" >
<![%IDEAL.accessibility.attlist;[
<!ATTLIST %IDEAL.accessibility.qname;
	%Common.attrib;
>
<!-- end of accessibility.attlist -->]]>

<!-- behaviour element................ -->
<!ENTITY % IDEAL.behaviour.element  "INCLUDE" >
<![%IDEAL.behaviour.element;[
<!ENTITY % IDEAL.behaviour.content  " ( %xml-events.listener.qname; | %XForms.Action.class;)* " >
<!ELEMENT %IDEAL.behaviour.qname;  %IDEAL.behaviour.content; >
<!-- end of behaviour.element -->]]>

<!ENTITY % IDEAL.behaviour.attlist  "INCLUDE" >
<![%IDEAL.behaviour.attlist;[
<!ATTLIST %IDEAL.behaviour.qname;
	%Common.attrib;
>
<!-- end of behaviour.attlist -->]]>

<!-- definitions element................ -->
<!ENTITY % IDEAL.definitions.element  "INCLUDE" >
<![%IDEAL.definitions.element;[
<!ENTITY % IDEAL.definitions.content  " ( %IDEAL.validator.qname; | %IDEAL.stringValidator.qname; | %IDEAL.dateTimeValidator.qname; | %IDEAL.numberValidator.qname;
					| %IDEAL.formatter.qname; | %IDEAL.stringFormatter.qname; | %IDEAL.numberFormatter.qname; | %IDEAL.currencyFormatter.qname;
					| %IDEAL.dateTimeFormatter.qname; | %DISelect.variable.qname; | %XForms.model.qname;
					)* " >
<!ELEMENT %IDEAL.definitions.qname;  %IDEAL.definitions.content; >
<!-- end of definitions.element -->]]>

<!ENTITY % IDEAL.definitions.attlist  "INCLUDE" >
<![%IDEAL.definitions.attlist;[
<!ATTLIST %IDEAL.definitions.qname;
	%Common.attrib;
>
<!-- end of definitions.attlist -->]]>

<!-- body element................ -->
<!ENTITY % IDEAL.body.element  "INCLUDE" >
<![%IDEAL.body.element;[
<!ENTITY % IDEAL.body.content  " ( %IDEAL.header.qname;? , %DIAL.h.qname;? , (%DIAL.section.qname; | %DIAL.separator.qname;)*,  %IDEAL.footer.qname;?)" >
<!ELEMENT %body.qname;  %IDEAL.body.content; >
<!-- end of body.element -->]]>

<!ENTITY % IDEAL.body.attlist  "INCLUDE" >
<![%IDEAL.body.attlist;[
<!ATTLIST %body.qname;
	%Common.attrib;
>
<!-- end of body.attlist -->]]>

<!-- title element................ -->
<!ENTITY % IDEAL.title.element  "INCLUDE" >
<![%IDEAL.title.element;[
<!ENTITY % IDEAL.title.content  "( #PCDATA | %XForms.UIInline.class;)*" >
<!ELEMENT %title.qname;  %IDEAL.title.content; >
<!-- end of title.element -->]]>


<!ENTITY % IDEAL.title.attlist  "INCLUDE" >
<![%IDEAL.title.attlist;[
<!ATTLIST %title.qname;
	%Common.attrib;
	%IDEAL.decorator.attrib;
	%embedding.attrib;
>
<!-- end of title.attlist -->]]>

<!-- end of ideal-document-1.mod -->