<!-- ...................................................................... -->
<!-- Dial Structure Module  ....................................... -->
<!-- file: ideal-model-1.mod  -->

	
<!ENTITY % Text.class "	%DIAL.abbr.qname; |
			%DIAL.cite.qname; | 		
			%DIAL.code.qname; | 			
			%DIAL.dfn.qname; | 
			%DIAL.em.qname; | 
			%DIAL.kbd.qname; | 
			%DIAL.l.qname; | 
			%DIAL.q.qname; | 
			%DIAL.samp.qname; | 
			%DIAL.span.qname; | 			
			%DIAL.strong.qname; | 
			%DIAL.sub.qname; | 
			%DIAL.sup.qname; | 			
			%DIAL.var.qname; 
" >


<!ENTITY % DIAL.NavigationList.extra "		
	| %IDEAL.menu.qname;
"
>
<!ENTITY % DIAL.NavigationList.class "
			%DIAL.nl.qname;
			%DIAL.NavigationList.extra;
			

" >
					
<!ENTITY % DIAL.List.class "
			%DIAL.ol.qname; |
			%DIAL.ul.qname; |
			%DIAL.dl.qname;			
" >

<!ENTITY % XForms.UIInline.class "%XForms.output.qname;" >

<!ENTITY % DIAL.label.content "(%Text.class; | 
				%XForms.UIInline.class;)
" >

<!ENTITY % DIAL.label.content "%Text.class; 
" >

<!ENTITY % XForms.Controls.extra " 
			| %IDEAL.selgroup.qname;
			| %IDEAL.inputDate.qname;		
			| %IDEAL.rssPanel.qname;
			| %IDEAL.inputTime.qname;
			| %IDEAL.teloutput.qname;
			" 
>

<!ENTITY % XForms.Controls.class " (
			%XForms.input.qname; | 
			%XForms.textarea.qname; |
			%XForms.secret.qname; |
			%XForms.output.qname; | 
			%XForms.upload.qname; | 
			%XForms.select1.qname; |			
			%XForms.select.qname; | 			
			%XForms.range.qname; | 
			%XForms.submit.qname; | 			
			%XForms.trigger.qname;
			%XForms.Controls.extra;
			)*" 
>

<!ENTITY % header.class " %IDEAL.header.qname;" >
<!ENTITY % footer.class "%IDEAL.footer.qname;" >

<!ENTITY % DIAL.section.extra " | %IDEAL.include.qname;" >


<!ENTITY % DIAL.div.extra " | %XForms.repeat.qname; 
			    | %XForms.group.qname; 
">

<!-- file: ideal-model-1.mod  -->