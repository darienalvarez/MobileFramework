<!-- ...................................................................... -->
<!-- IDEAL validator              ................................................... -->
<!-- file: ideal-validator-1.mod	-->

<!-- validator element................ -->
<!ENTITY % IDEAL.validator.element  "INCLUDE" >
<![%IDEAL.validator.element;[
<!ENTITY % IDEAL.validator.content  " EMPTY " >
<!ELEMENT %IDEAL.validator.qname;  %IDEAL.validator.content; >
<!-- end of validator.element -->]]>

<!ENTITY % IDEAL.validator.attlist  "INCLUDE" >
<![%IDEAL.validator.attlist;[
<!ATTLIST %IDEAL.validator.qname;
	%Common.attrib;
	%IDEAL.handler.attrib;
	%IDEAL.type.attrib;
>
<!-- end of validator.attlist -->]]>

<!-- stringValidator element................ -->
<!ENTITY % IDEAL.stringValidator.element  "INCLUDE" >
<![%IDEAL.stringValidator.element;[
<!ENTITY % IDEAL.stringValidator.content  " EMPTY " >
<!ELEMENT %IDEAL.stringValidator.qname;  %IDEAL.stringValidator.content; >
<!-- end of stringValidator.element -->]]>

<!ENTITY % IDEAL.stringValidator.attlist  "INCLUDE" >
<![%IDEAL.stringValidator.attlist;[
<!ATTLIST %IDEAL.stringValidator.qname;
	%Common.attrib;
	%IDEAL.enumeration.attrib;
	%IDEAL.length.attrib;
	%IDEAL.maxlength.attrib;
	%IDEAL.minlength.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.whiteSpace.attrib;
>
<!-- end of stringValidator.attlist -->]]>

<!-- dateTimeValidator element................ -->
<!ENTITY % IDEAL.dateTimeValidator.element  "INCLUDE" >
<![%IDEAL.dateTimeValidator.element;[
<!ENTITY % IDEAL.dateTimeValidator.content  " EMPTY " >
<!ELEMENT %IDEAL.dateTimeValidator.qname;  %IDEAL.dateTimeValidator.content; >
<!-- end of dateTimeValidator.element -->]]>

<!ENTITY % IDEAL.dateTimeValidator.attlist  "INCLUDE" >
<![%IDEAL.dateTimeValidator.attlist;[
<!ATTLIST %IDEAL.dateTimeValidator.qname;
	%Common.attrib;
	%IDEAL.enumeration.attrib;
	%IDEAL.locale.attrib;
	%IDEAL.maxExclusive.attrib;
	%IDEAL.maxInclusive.attrib;
	%IDEAL.minExclusive.attrib;
	%IDEAL.minInclusive.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.whiteSpace.attrib;
>
<!-- end of dateTimeValidator.attlist -->]]>

<!-- numberValidator element................ -->
<!ENTITY % IDEAL.numberValidator.element  "INCLUDE" >
<![%IDEAL.numberValidator.element;[
<!ENTITY % IDEAL.numberValidator.content  " EMPTY " >
<!ELEMENT %IDEAL.numberValidator.qname;  %IDEAL.numberValidator.content; >
<!-- end of numberValidator.element -->]]>

<!ENTITY % IDEAL.numberValidator.attlist  "INCLUDE" >
<![%IDEAL.numberValidator.attlist;[
<!ATTLIST %IDEAL.numberValidator.qname;
	%Common.attrib;
	%IDEAL.enumeration.attrib;
	%IDEAL.fractionDigits.attrib;
	%IDEAL.locale.attrib;
	%IDEAL.maxExclusive.attrib;
	%IDEAL.maxInclusive.attrib;
	%IDEAL.minExclusive.attrib;
	%IDEAL.minInclusive.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.totalDigits.attrib;
	%IDEAL.type.attrib;
	%IDEAL.whiteSpace.attrib;
>
<!-- end of numberValidator.attlist -->]]>

<!-- formatter element................ -->
<!ENTITY % IDEAL.formatter.element  "INCLUDE" >
<![%IDEAL.formatter.element;[
<!ENTITY % IDEAL.formatter.content  " EMPTY " >
<!ELEMENT %IDEAL.formatter.qname;  %IDEAL.formatter.content; >
<!-- end of formatter.element -->]]>

<!ENTITY % IDEAL.formatter.attlist  "INCLUDE" >
<![%IDEAL.formatter.attlist;[
<!ATTLIST %IDEAL.formatter.qname;
	%Common.attrib;
	%IDEAL.handler.attrib;
	%IDEAL.locale.attrib;
>
<!-- end of formatter.attlist -->]]>


<!-- stringFormatter element................ -->
<!ENTITY % IDEAL.stringFormatter.element  "INCLUDE" >
<![%IDEAL.stringFormatter.element;[
<!ENTITY % IDEAL.stringFormatter.content  " EMPTY " >
<!ELEMENT %IDEAL.stringFormatter.qname;  %IDEAL.stringFormatter.content; >
<!-- end of stringFormatter.element -->]]>

<!ENTITY % IDEAL.stringFormatter.attlist  "INCLUDE" >
<![%IDEAL.stringFormatter.attlist;[
<!ATTLIST %IDEAL.stringFormatter.qname;
	%Common.attrib;
	%IDEAL.pattern.attrib;
>
<!-- end of stringFormatter.attlist -->]]>

<!-- numberFormatter element................ -->
<!ENTITY % IDEAL.numberFormatter.element  "INCLUDE" >
<![%IDEAL.numberFormatter.element;[
<!ENTITY % IDEAL.numberFormatter.content  " EMPTY " >
<!ELEMENT %IDEAL.numberFormatter.qname;  %IDEAL.numberFormatter.content; >
<!-- end of numberFormatter.element -->]]>

<!ENTITY % IDEAL.numberFormatter.attlist  "INCLUDE" >
<![%IDEAL.numberFormatter.attlist;[
<!ATTLIST %IDEAL.numberFormatter.qname;
	%Common.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.locale.attrib;
>
<!-- end of numberFormatter.attlist -->]]>

<!-- currencyFormatter element................ -->
<!ENTITY % IDEAL.currencyFormatter.element  "INCLUDE" >
<![%IDEAL.currencyFormatter.element;[
<!ENTITY % IDEAL.currencyFormatter.content  " EMPTY " >
<!ELEMENT %IDEAL.currencyFormatter.qname;  %IDEAL.currencyFormatter.content; >
<!-- end of currencyFormatter.element -->]]>

<!ENTITY % IDEAL.currencyFormatter.attlist  "INCLUDE" >
<![%IDEAL.currencyFormatter.attlist;[
<!ATTLIST %IDEAL.currencyFormatter.qname;
	%Common.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.locale.attrib;
>
<!-- end of currencyFormatter.attlist -->]]>

<!-- dateTimeFormatter element................ -->
<!ENTITY % IDEAL.dateTimeFormatter.element  "INCLUDE" >
<![%IDEAL.dateTimeFormatter.element;[
<!ENTITY % IDEAL.dateTimeFormatter.content  " EMPTY " >
<!ELEMENT %IDEAL.dateTimeFormatter.qname;  %IDEAL.dateTimeFormatter.content; >
<!-- end of dateTimeFormatter.element -->]]>

<!ENTITY % IDEAL.dateTimeFormatter.attlist  "INCLUDE" >
<![%IDEAL.dateTimeFormatter.attlist;[
<!ATTLIST %IDEAL.dateTimeFormatter.qname;
	%Common.attrib;
	%IDEAL.pattern.attrib;
	%IDEAL.locale.attrib;
	%IDEAL.timeZone.attrib;
>
<!-- end of dateTimeFormatter.attlist -->]]>

<!-- end of ideal-validator-1.mod -->