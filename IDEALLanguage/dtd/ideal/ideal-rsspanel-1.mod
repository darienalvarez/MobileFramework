<!-- ..................................................................... -->
<!-- IDEAL RSSPanel Module  ........................................ -->
<!-- file: ideal-rssPanel-1.mod ............................................. -->

<!-- RSSPanel  -->

<!-- rssPanel: RSSPanel ................... -->

<!ENTITY % IDEAL.rssPanel.element  "INCLUDE" >
<![%IDEAL.rssPanel.element;[
<!ENTITY % IDEAL.rssPanel.content "EMPTY" >

<!ELEMENT %IDEAL.rssPanel.qname;  %IDEAL.rssPanel.content; >
<!-- end of ideal.rssPanel.element -->]]>

<!ENTITY % IDEAL.rssPanel.attlist  "INCLUDE" >
<![%IDEAL.rssPanel.attlist;[
<!ATTLIST %IDEAL.rssPanel.qname;
      %Common.attrib;
      %IDEAL.cachecontent.qname; 	 	 CDATA 		#IMPLIED
      %IDEAL.src.qname;           %URI.datatype;     #REQUIRED
      %IDEAL.xmlns.extra.attrib;
>
     
<!-- end of ideal.rssPanel.attlist -->]]>

<!-- end of ideal-rssPanel-1.mod -->
