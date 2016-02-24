<!-- ...................................................................... -->
<!-- DIAL Model Module  ....................................... -->
<!-- file: dial-model-1.mod  -->

	
<!ENTITY % Text.class "	
			%DIAL.cite.qname; | 		
			%DIAL.abbr.qname; |
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


<!ENTITY % DIAL.NavigationList.class "
			%DIAL.nl.qname;

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
			)*" 
>

<!ENTITY % header.class "" >
<!ENTITY % footer.class "" >
<!ENTITY % DIAL.section.extra "" >
<!ENTITY % DIAL.div.extra "">

<!-- file: dial-model-1.mod  -->