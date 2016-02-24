package com.gazoomobile.mfw.xmlbind.component;

public class Linkbutton implements TComponent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2366452167738764540L;
	private String id;
	private String textValue;
	private String ref;
	
	public Linkbutton() {
		super();
	}

	public Linkbutton(String id, String ref, String textValue) {
		super();
		this.id = id;
		this.ref = ref;
		this.textValue = textValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<linkbutton ");
		if (id == null) 
			throw new RuntimeException(Linkbutton.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		if (ref != null) {
			builder.append("ref=\"");
			builder.append(ref);
			builder.append("\" ");
		}
		
		builder.append(">");
		if (textValue != null) {
			builder.append(textValue);
		}
		builder.append("</linkbutton>\r\n");
		return builder.toString();
	}

}
