<!-- ...................................................................... -->
<!-- IDEAL               ................................................... -->
<!-- file: ideal-1.mod	-->

<!ENTITY % ideal-menu.module "INCLUDE" >
<![%ideal-menu.module;[
<!ENTITY % ideal-menu.mod
     SYSTEM "ideal-menu-1.mod" >
%ideal-menu.mod;]]>

<!ENTITY % ideal-chainedmenu.module "INCLUDE" >
<![%ideal-chainedmenu.module;[
<!ENTITY % ideal-chainedmenu.mod
     SYSTEM "ideal-chainedmenu-1.mod" >
%ideal-chainedmenu.mod;]]>

<!ENTITY % ideal-datefield.module "INCLUDE" >
<![%ideal-datefield.module;[
<!ENTITY % ideal-datefield.mod
     SYSTEM "ideal-datefield-1.mod" >
%ideal-datefield.mod;]]>

<!ENTITY % ideal-include.module "INCLUDE" >
<![%ideal-include.module;[
<!ENTITY % ideal-include.mod
     SYSTEM "ideal-include-1.mod" >
%ideal-include.mod;]]>

<!ENTITY % ideal-rsspanel.module "INCLUDE" >
<![%ideal-rsspanel.module;[
<!ENTITY % ideal-rsspanel.mod
     SYSTEM "ideal-rsspanel-1.mod" >
%ideal-rsspanel.mod;]]>

<!-- header element................ -->
<!ENTITY % IDEAL.header.element  "INCLUDE" >
<![%IDEAL.header.element;[
<!ENTITY % IDEAL.header.content  " ( %DIAL.h.qname;?, ( %DIAL.section.qname; | %DIAL.div.qname; |  %DIAL.p.qname; | %DIAL.separator.qname;  )* ) " >
<!ELEMENT %IDEAL.header.qname;  %IDEAL.header.content; >
<!-- end of header.element -->]]>

<!ENTITY % IDEAL.header.attlist  "INCLUDE" >
<![%IDEAL.header.attlist;[
<!ATTLIST %IDEAL.header.qname;
	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
>
<!-- end of header.attlist -->]]>

<!-- footer element................ -->
<!ENTITY % IDEAL.footer.element  "INCLUDE" >
<![%IDEAL.footer.element;[
<!ENTITY % IDEAL.footer.content  " ( %DIAL.h.qname;?, ( %DIAL.section.qname; | %DIAL.div.qname; |  %DIAL.p.qname; | %DIAL.separator.qname;  )* ) " >
<!ELEMENT %IDEAL.footer.qname;  %IDEAL.footer.content; >
<!-- end of footer.element -->]]>

<!ENTITY % IDEAL.footer.attlist  "INCLUDE" >
<![%IDEAL.footer.attlist;[
<!ATTLIST %IDEAL.footer.qname;
      %Common.attrib;
      %embedding.attrib;
      %hypertext.attrib;
      
>
<!-- end of header.attlist -->]]>

<!-- end of ideal-1.mod -->