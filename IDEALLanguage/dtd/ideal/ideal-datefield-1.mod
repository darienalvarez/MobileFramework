<!-- ..................................................................... -->
<!-- IDEAL DateField Module  ........................................ -->
<!-- file: ideal-datefield-1.mod ............................................. -->

<!-- Embedded DateField  -->

<!-- datefield: Embedded DateField ................... -->

<!ENTITY % IDEAL.datefield.element  "INCLUDE" >
<![%IDEAL.datefield.element;[
<!ENTITY % IDEAL.datefield.content "EMPTY" >

<!ELEMENT %IDEAL.datefield.qname;  %IDEAL.datefield.content; >
<!-- end of ideal.datefield.element -->]]>

<!ENTITY % IDEAL.datefield.attlist  "INCLUDE" >
<![%IDEAL.datefield.attlist;[
<!ATTLIST %IDEAL.datefield.qname;
      %Common.attrib;
      %XForms.ref.attrib;
      %XForms.bind.attrib;
      %XForms.model.attrib;
      %IDEAL.xmlns.extra.attrib;      
>
<!-- end of ideal.datefield.attlist -->]]>

<!-- end of ideal-datefield-1.mod -->
