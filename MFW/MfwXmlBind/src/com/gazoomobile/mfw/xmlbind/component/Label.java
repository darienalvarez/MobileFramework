package com.gazoomobile.mfw.xmlbind.component;

public class Label implements TComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6233771041109681765L;
	private String id;
	private String textValue;
	
	public Label() {
		super();
	}

	public Label(String id, String textValue) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<label ");
		if (id == null) 
			throw new RuntimeException(Label.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		builder.append(">");
		
		if (textValue != null) {
			builder.append(textValue);
		}
		builder.append("</label>\r\n");
		return builder.toString();
	}
}
