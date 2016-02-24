<!-- ...................................................................... -->
<!-- IDEAL               ................................................... -->
<!-- file: ideal-qname-1.mod	-->

<!ENTITY % ideal-chainedmenu-qname.module "INCLUDE" >
<![%ideal-chainedmenu-qname.module;[
<!ENTITY % ideal-chainedmenu-qname.mod
     SYSTEM "ideal-chainedmenu-qname-1.mod" >
%ideal-chainedmenu-qname.mod;]]>

<!ENTITY % ideal-menu-qname.module "INCLUDE" >
<![%ideal-menu-qname.module;[
<!ENTITY % ideal-menu-qname.mod
     SYSTEM "ideal-menu-qname-1.mod" >
%ideal-menu-qname.mod;]]>

<!ENTITY % ideal-datefield-qname.module "INCLUDE" >
<![%ideal-datefield-qname.module;[
<!ENTITY % ideal-datefield-qname.mod
     SYSTEM "ideal-datefield-qname-1.mod" >
%ideal-datefield-qname.mod;]]>

<!ENTITY % ideal-include-qname.module "INCLUDE" >
<![%ideal-include-qname.module;[
<!ENTITY % ideal-include-qname.mod
     SYSTEM "ideal-include-qname-1.mod" >
%ideal-include-qname.mod;]]>

<!ENTITY % ideal-rsspanel-qname.module "INCLUDE" >
<![%ideal-rsspanel-qname.module;[
<!ENTITY % ideal-rsspanel-qname.mod
     SYSTEM "ideal-rsspanel-qname-1.mod" >
%ideal-rsspanel-qname.mod;]]>
 
<!ENTITY % IDEAL.header.qname  "%IDEAL.pfx;header" >

<!ENTITY % IDEAL.footer.qname  "%IDEAL.pfx;footer" >



<!ENTITY % IDEAL.xmlns.attrib.prefixed
     "xmlns:%IDEAL.prefix;  %URI.datatype;   #FIXED '%IDEAL.xmlns;'"
>

<!-- Define the xmlns extension attributes -->
<!ENTITY % IDEAL.xmlns.extra.attrib
         "
         %XForms.xmlns.extra.attrib;
         %DISelect.xmlns.extra.attrib;
         %XML-EVENTS.xmlns.extra.attrib;
         " >

<![%IDEAL.prefixed;[
<!ENTITY % NS.decl.attrib
     "%IDEAL.xmlns.attrib.prefixed;
      %IDEAL.xmlns.extra.attrib;"
>
]]>
<!ENTITY % NS.decl.attrib
     "%IDEAL.xmlns.extra.attrib;"
>


<![%IDEAL.prefixed;[
<!ENTITY % IDEAL.xmlns.attrib
     "%NS.decl.attrib;
	"
>
]]>
<!ENTITY % IDEAL.xmlns.attrib
     "xmlns        %URI.datatype;           #FIXED '%IDEAL.xmlns;'
      %NS.decl.attrib;
	"
>

<!-- end of ideal-qname-1.mod -->