<!-- ..................................................................... -->
<!-- DIAL Embedded Object Module  ........................................ -->
<!-- file: dial-object-1.mod ............................................. -->

<!-- Embedded Objects

        object

     This module declares the object element type and its attributes, used
     to embed external objects as part of XHTML pages. In the document,
     place param elements prior to other content within the object element.

     Note that use of this module requires instantiation of the Param
     Element Module.
-->

<!-- object: Generic Embedded Object ................... -->
<!ENTITY % object.element  "INCLUDE" >
<![%object.element;[
<!ENTITY % object.content 
	 "( %DIAL.param.qname; )*"
>

<!ELEMENT %DIAL.object.qname;  %object.content; >
<!-- end of object.element -->]]>


<!ENTITY % object.attlist  "INCLUDE" >
<![%object.attlist;[
<!ATTLIST %DIAL.object.qname;
      	%Common.attrib;
	%embedding.attrib;
      	%DIAL.declare.attrib;
	%hypertext.attrib;
>
<!-- end of object.attlist -->]]>


<!-- param ................... -->
<!ENTITY % param.element  "INCLUDE" >
<![%param.element;[
<!ENTITY % param.content "EMPTY"
>

<!ELEMENT %DIAL.param.qname;  %param.content; >
<!-- end of param.element -->]]>


<!ENTITY % param.attlist  "INCLUDE" >
<![%param.attlist;[
<!ATTLIST %DIAL.param.qname;
      %Common.attrib;
      %DIAL.name.attrib;
      %DIAL.value.attrib;
>
<!-- end of param.attlist -->]]>


<!-- end of dial-object-1.mod -->
