<!-- ..................................................................... -->
<!-- IDEAL Include Qname Module  ............................................ -->
<!-- file: ideal-include-qname-1.mod......................................... -->

<!-- IDEAL Include Qname (Qualified Name) Module -->

<!-- Section A: IDEAL Include Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % IDEAL.prefixed "%NS.prefixed;" >

<!ENTITY % IDEAL.xmlns  "http://www.morfeo-project.org/2008/ideal" >

<!ENTITY % IDEAL.prefix  "ideal" >

<![%IDEAL.prefixed;[
<!ENTITY % IDEAL.pfx  "%IDEAL.prefix;:" >
]]>
<!ENTITY % IDEAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % ideal-include-qname-extra.mod "" >
%ideal-include-qname-extra.mod;

<!-- Section B: IDEAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % IDEAL.include.qname  "%IDEAL.pfx;include" >

<!-- Attributes --> 

<!ENTITY % IDEAL.content.qname  "%IDEAL.pfx;content" >

<!-- end of ideal-include-qname-1.mod -->
