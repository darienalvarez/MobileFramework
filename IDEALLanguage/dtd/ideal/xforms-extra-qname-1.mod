<!-- ...................................................................... -->
<!-- Xforms Extra Qname Module ................................................... -->
<!-- file: xforms-extra-qname-1.mod -->

	
<!-- Declare the qualified names for all of the elements in the module-->
<!ENTITY % XForms.invoke.qname 			"%IDEAL.pfx;invoke">

<!ENTITY % XForms.format.qname 			"%IDEAL.pfx;format">
<!ENTITY % XForms.phoneBookAdd.qname 		"%IDEAL.pfx;phoneBookAdd">
<!ENTITY % XForms.smsSend.qname 		"%IDEAL.pfx;smsSend">
<!ENTITY % XForms.telephoneCall.qname 		"%IDEAL.pfx;telephoneCall">
<!ENTITY % XForms.validate.qname 		"%IDEAL.pfx;validate">


<!ENTITY % XForms.Action.class "	(
				%XForms.action.qname; 
				| %XForms.dispatch.qname;
				| %XForms.rebuild.qname;
				| %XForms.refresh.qname;
				| %XForms.recalculate.qname;
				| %XForms.revalidate.qname;
				| %XForms.setfocus.qname;
				| %XForms.load.qname;
				| %XForms.setvalue.qname;
				| %XForms.send.qname;
				| %XForms.reset.qname;
				| %XForms.message.qname;
				| %XForms.toggle.qname;
				| %XForms.insert.qname;
				| %XForms.delete.qname;
				| %XForms.setindex.qname;
				| %XForms.invoke.qname;
				| %XForms.format.qname;
				| %XForms.phoneBookAdd.qname;
				| %XForms.smsSend.qname;
				| %XForms.telephoneCall.qname;
				| %XForms.validate.qname;
				)*
				" >
