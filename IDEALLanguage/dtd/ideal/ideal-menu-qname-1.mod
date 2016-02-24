<!-- ..................................................................... -->
<!-- IDEAL Menu Qname Module  ............................................ -->
<!-- file: ideal-menu-qname-1.mod......................................... -->

<!-- IDEAL Menu Qname (Qualified Name) Module -->

<!-- Section A: IDEAL Menu Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % IDEAL.prefixed "%NS.prefixed;" >

<!ENTITY % IDEAL.xmlns  "http://www.morfeo-project.org/2008/ideal" >

<!ENTITY % IDEAL.prefix  "ideal" >

<![%IDEAL.prefixed;[
<!ENTITY % IDEAL.pfx  "%IDEAL.prefix;:" >
]]>
<!ENTITY % IDEAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % ideal-cnl-qname-extra.mod "" >
%ideal-cnl-qname-extra.mod;

<!-- Section B: IDEAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % IDEAL.menu.qname  "%IDEAL.pfx;menu" >

<!-- end of ideal-menu-qname-1.mod -->
