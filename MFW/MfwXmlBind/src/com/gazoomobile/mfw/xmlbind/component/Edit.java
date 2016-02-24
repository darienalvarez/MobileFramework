package com.gazoomobile.mfw.xmlbind.component;

public class Edit implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2178258369196456836L;
	private String id;
	private String textValue;
	
	public Edit() {
		super();
	}

	public Edit(String id, String textValue) {
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
		builder.append("<edit ");
		if (id == null) 
			throw new RuntimeException(Edit.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		builder.append(">");
		if (textValue != null) {
			builder.append(textValue);
		}
		builder.append("</edit>\r\n");
		return builder.toString();
	}

}
