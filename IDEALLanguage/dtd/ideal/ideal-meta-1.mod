<!-- ...................................................................... -->
<!-- Dial Metainformation Module  ............................... -->
<!-- file: dial-meta-1.mod

     ....................................................................... -->

<!-- Meta Information

        meta

     This module declares the meta element type and its attributes,
     used to provide declarative document metainformation.
-->

<!-- meta: Generic Metainformation ..................... -->

<!ENTITY % meta.element  "INCLUDE" >
<![%meta.element;[

<!ENTITY % meta.content  "EMPTY" >

<!ENTITY % meta.qname  "meta" >
<!ELEMENT %meta.qname;  %meta.content; >
<!-- end of meta.element -->]]>

<!ENTITY % meta.attlist  "INCLUDE" >
<![%meta.attlist;[
<!ATTLIST %meta.qname;
	  about      	  %URI.datatype;        #IMPLIED
      property        CDATA                 #IMPLIED
      content      	  CDATA                	#IMPLIED
      datatype		  CDATA					#IMPLIED
      %Common.attrib;		      
>
<!-- end of meta.attlist -->]]>

<!-- end of dial-meta-1.mod -->
