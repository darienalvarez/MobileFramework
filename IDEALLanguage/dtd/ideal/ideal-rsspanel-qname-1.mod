<!-- ..................................................................... -->
<!-- IDEAL RSSPanel Qname Module  ............................................ -->
<!-- file: ideal-rsspanel-qname-1.mod......................................... -->

<!-- IDEAL RSSPanel Qname (Qualified Name) Module -->

<!-- Section A: IDEAL RSSPanel Namespace :::::::::::::::::::: -->

<!ENTITY % NS.prefixed "IGNORE" >
<!ENTITY % IDEAL.prefixed "%NS.prefixed;" >

<!ENTITY % IDEAL.xmlns  "http://www.morfeo-project.org/2008/ideal" >

<!ENTITY % IDEAL.prefix  "ideal" >

<![%IDEAL.prefixed;[
<!ENTITY % IDEAL.pfx  "%IDEAL.prefix;:" >
]]>
<!ENTITY % IDEAL.pfx  "" >

<!-- declare qualified name extensions here ............ -->
<!ENTITY % ideal-phonebookadder-qname-extra.mod "" >
%ideal-phonebookadder-qname-extra.mod;

<!-- Section B: IDEAL Qualified Names ::::::::::::::::::::::::::::: -->

<!ENTITY % IDEAL.rssPanel.qname  "%IDEAL.pfx;rssPanel" >

<!-- Attributes --> 

<!ENTITY % IDEAL.cachecontent.qname  "%IDEAL.pfx;cachecontent" >
<!ENTITY % IDEAL.src.qname  "%IDEAL.pfx;src" >

<!-- end of ideal-rsspanel-qname-1.mod -->
