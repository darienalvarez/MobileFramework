<!-- ..................................................................... -->
<!-- IDEAL Include Module  ........................................ -->
<!-- file: ideal-include-1.mod ............................................. -->

<!-- Include  

	 Include section or div
	 
-->

<!-- include: Include ................... -->

<!ENTITY % IDEAL.include.element  "INCLUDE" >
<![%IDEAL.include.element;[
<!ENTITY % IDEAL.include.content "EMPTY" >

<!ELEMENT %IDEAL.include.qname;  %IDEAL.include.content; >
<!-- end of ideal.include.element -->]]>

<!ENTITY % IDEAL.include.attlist  "INCLUDE" >
<![%IDEAL.include.attlist;[
<!ATTLIST %IDEAL.include.qname;
      %Common.attrib;      
      %IDEAL.content.qname; 	 CDATA 		#REQUIRED
      %IDEAL.xmlns.extra.attrib;       
>
<!-- end of ideal.include.attlist -->]]>

<!-- end of ideal-include-1.mod -->
