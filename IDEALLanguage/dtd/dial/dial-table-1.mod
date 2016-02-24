<!-- ...................................................................... -->
<!-- DIAL Table Module  .................................................. -->
<!-- ...................................................................... -->

<!ENTITY % CellHAlign.attrib
     "%DIAL.align.qname;  ( left | center | right | justify | char )              #IMPLIED
      %DIAL.char.qname;         %Character.datatype;     #IMPLIED
      %DIAL.charoff.qname;      %Length.datatype;        #IMPLIED"
>

<!-- vertical alignment attribute for cell contents
-->
<!ENTITY % CellVAlign.attrib
     "%DIAL.valign.qname;       ( top | middle | bottom | baseline )             #IMPLIED"
>


<!-- scope is simpler than axes attribute for common tables
-->
<!ENTITY % scope.attrib
     "%DIAL.scope.qname;        ( row | col | rowgroup | colgroup )             #IMPLIED"
>

<!-- table: Table Element .............................. -->

<!ENTITY % table.element  "INCLUDE" >
<![%table.element;[
<!ENTITY % table.content
      "( (%DIAL.label.qname; | %DIAL.caption.qname;)?, %DIAL.summary.qname;?, ( %DIAL.col.qname;* | %DIAL.colgroup.qname;*), %DIAL.thead.qname;?, %DIAL.tbody.qname; , %DIAL.tfoot.qname;?)"
>
<!ELEMENT %DIAL.table.qname;  %table.content; >
<!-- end of table.element -->]]>

<!ENTITY % table.extra.attrib  "" >
<!ENTITY % table.attlist  "INCLUDE" >
<![%table.attlist;[
<!ATTLIST %DIAL.table.qname;
      	%Common.attrib;
	%embedding.attrib;
	%hypertext.attrib;
      	%DIAL.extra.misc.attrib;
      	%DIAL.extra.repeat.attrib;
      	%DIAL.extra.bind.attrib;      
      	%DIAL.extra.repeat.attrib; 
      	%DIAL.extra.bind.attrib;     
      	%table.extra.attrib;
>
<!-- end of table.attlist -->]]>

<!-- caption: Table Caption ............................ -->

<!ENTITY % caption.element  "INCLUDE" >
<![%caption.element;[
<!ENTITY % caption.content
     "( #PCDATA | %Text.class; | %XForms.UIInline.class;)*"
>
<!ELEMENT %DIAL.caption.qname;  %caption.content; >
<!-- end of caption.element -->]]>

<!ENTITY % caption.attlist  "INCLUDE" >
<![%caption.attlist;[
<!ATTLIST %DIAL.caption.qname;
      %Common.attrib;      
>
<!-- end of caption.attlist -->]]>


<!-- summary: Table summary ............................ -->

<!ENTITY % summary.element  "INCLUDE" >
<![%summary.element;[
<!ENTITY % summary.content
     "( #PCDATA | %Text.class; | %XForms.UIInline.class;)*"
>
<!ELEMENT %DIAL.summary.qname;  %summary.content; >
<!-- end of summary.element -->]]>

<!ENTITY % summary.attlist  "INCLUDE" >
<![%summary.attlist;[
<!ATTLIST %DIAL.summary.qname;
      %Common.attrib;      
>
<!-- end of summary.attlist -->]]>

<!-- col: Table Column ................................. -->

<!-- col elements define the alignment properties for
     cells in one or more columns.

     The span attribute causes the attributes of one
     col element to apply to more than one column.
-->

<!ENTITY % col.element  "INCLUDE" >
<![%col.element;[
<!ENTITY % col.content  "EMPTY" >
<!ELEMENT %DIAL.col.qname;  %col.content; >
<!-- end of col.element -->]]>

<!ENTITY % col.attlist  "INCLUDE" >
<![%col.attlist;[
<!ATTLIST %DIAL.col.qname;
      %Common.attrib;
      %DIAL.span.qname;         %Number.datatype;        '1'      
      %CellHAlign.attrib;
      %CellVAlign.attrib;      
>
<!-- end of col.attlist -->]]>

<!-- col: Table Column ................................. -->

<!-- colgroup: Table Column Group ...................... -->

<!-- colgroup groups a set of col elements. It allows you
     to group several semantically-related columns together.
-->

<!ENTITY % colgroup.element  "INCLUDE" >
<![%colgroup.element;[
<!ENTITY % colgroup.content  "( %DIAL.col.qname; )*" >
<!ELEMENT %DIAL.colgroup.qname;  %colgroup.content; >
<!-- end of colgroup.element -->]]>

<!ENTITY % colgroup.attlist  "INCLUDE" >
<![%colgroup.attlist;[
<!ATTLIST %DIAL.colgroup.qname;
      %Common.attrib;
      %DIAL.span.qname;         %Number.datatype;        '1'      
      %CellHAlign.attrib;
      %CellVAlign.attrib;  
>
<!-- end of colgroup.attlist -->]]>



<!-- thead: Table Header ............................... -->

<!-- Use thead to duplicate headers when breaking table
     across page boundaries, or for static headers when
     tbody sections are rendered in scrolling panel.
-->

<!ENTITY % thead.element  "INCLUDE" >
<![%thead.element;[
<!ENTITY % thead.content  "( %DIAL.tr.qname; )+" >
<!ELEMENT %DIAL.thead.qname;  %thead.content; >
<!-- end of thead.element -->]]>

<!ENTITY % thead.attlist  "INCLUDE" >
<![%thead.attlist;[
<!ATTLIST %DIAL.thead.qname;
      %Common.attrib;
      %CellHAlign.attrib;
      %CellVAlign.attrib;
>
<!-- end of thead.attlist -->]]>

<!-- tfoot: Table Footer ............................... -->

<!-- Use tfoot to duplicate footers when breaking table
     across page boundaries, or for static footers when
     tbody sections are rendered in scrolling panel.
-->

<!ENTITY % tfoot.element  "INCLUDE" >
<![%tfoot.element;[
<!ENTITY % tfoot.content  "( %DIAL.tr.qname; )+" >
<!ELEMENT %DIAL.tfoot.qname;  %tfoot.content; >
<!-- end of tfoot.element -->]]>

<!ENTITY % tfoot.attlist  "INCLUDE" >
<![%tfoot.attlist;[
<!ATTLIST %DIAL.tfoot.qname;
      %Common.attrib;
      %CellHAlign.attrib;
      %CellVAlign.attrib;
>
<!-- end of tfoot.attlist -->]]>

<!-- tbody: Table Body ................................. -->

<!-- Use multiple tbody sections when rules are needed
     between groups of table rows.
-->

<!ENTITY % tbody.element  "INCLUDE" >
<![%tbody.element;[
<!ENTITY % tbody.content  "( %DIAL.tr.qname; )+" >
<!ELEMENT %DIAL.tbody.qname;  %tbody.content; >
<!-- end of tbody.element -->]]>

<!ENTITY % tbody.attlist  "INCLUDE" >
<![%tbody.attlist;[
<!ATTLIST %DIAL.tbody.qname;
      %Common.attrib;
      %CellHAlign.attrib;
      %CellVAlign.attrib;
>
<!-- end of tbody.attlist -->]]>


<!-- tr: Table Row ..................................... -->

<!ENTITY % tr.element  "INCLUDE" >
<![%tr.element;[
<!ENTITY % tr.content  "( %DIAL.td.qname; | %DIAL.th.qname; )+" >
<!ELEMENT %DIAL.tr.qname;  %tr.content; >
<!-- end of tr.element -->]]>

<!ENTITY % tr.extra.attrib  "" >
<!ENTITY % tr.attlist  "INCLUDE" >
<![%tr.attlist;[
<!ATTLIST %DIAL.tr.qname;
      %Common.attrib;
      %CellHAlign.attrib;
      %CellVAlign.attrib;
      %DIAL.extra.repeat.attrib; 
      %tr.extra.attrib;
>
<!-- end of tr.attlist -->]]>

<!-- th: Table Header Cell ............................. -->

<!-- th is for header cells, td for data,
     but for cells acting as both use td
-->

<!ENTITY % th.element  "INCLUDE" >
<![%th.element;[
<!ENTITY % th.content "(#PCDATA | %Text.class;)*"
>
<!ELEMENT %DIAL.th.qname;  %th.content; >
<!-- end of th.element -->]]>

<!ENTITY % th.attlist  "INCLUDE" >
<![%th.attlist;[
<!ATTLIST %DIAL.th.qname;
	%Common.attrib;
	%DIAL.rowspan.qname;      %Number.datatype;        '1'            
	%DIAL.abbr.qname;         %Text.datatype;          #IMPLIED
	%DIAL.colspan.qname;      %Number.datatype;        '1'
	%DIAL.headers.qname;      IDREFS                   #IMPLIED
	%scope.attrib;      
	%hypertext.attrib;
	%embedding.attrib;
>
<!-- end of th.attlist -->]]>

<!-- td: Table Data Cell ............................... -->

<!ENTITY % td.element  "INCLUDE" >
<![%td.element;[
<!ENTITY % td.content
     "( #PCDATA | %Text.class;)*"
>
<!ELEMENT %DIAL.td.qname;  %td.content; >
<!-- end of td.element -->]]>

<!ENTITY % td.attlist  "INCLUDE" >
<![%td.attlist;[
<!ATTLIST %DIAL.td.qname;
	%Common.attrib;
	%DIAL.rowspan.qname;      %Number.datatype;        '1'            
	%DIAL.abbr.qname;         %Text.datatype;          #IMPLIED
	%DIAL.colspan.qname;      %Number.datatype;        '1'
	%DIAL.headers.qname;      IDREFS                   #IMPLIED
	%scope.attrib;      
	%hypertext.attrib;
	%embedding.attrib;
>
<!-- end of td.attlist -->]]>

<!-- end of dial-table-1.mod -->
