package com.gazoomobile.mfw.xmlbind.component;

public class Textbox implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4384426623310416401L;
	private String id;
	private String textValue;
	
	public Textbox() {
		super();
	}

	public Textbox(String id, String textValue) {
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
		builder.append("<textbox ");
		if (id == null) 
			throw new RuntimeException(Textbox.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		builder.append(">");
		if (textValue != null) {
			builder.append(textValue);
		}
		builder.append("</textbox>\r\n");
		return builder.toString();
	}

}
