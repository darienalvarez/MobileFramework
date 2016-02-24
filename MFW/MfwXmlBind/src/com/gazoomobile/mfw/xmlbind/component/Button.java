package com.gazoomobile.mfw.xmlbind.component;

public class Button implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2612114371885602466L;
	private String id;
	private String background;
	private String textValue;
	
	public Button() {
		super();
	}

	public Button(String id, String background, String textValue) {
		super();
		this.id = id;
		this.background = background;
		this.textValue = textValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
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
		builder.append("<button ");
		
		if (id == null) 
			throw new RuntimeException(Button.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		if (background != null) {
			builder.append("background=\"");
			builder.append(background);
			builder.append("\" ");
		}
		
		builder.append(">");
		
		if (textValue != null) {
			builder.append(textValue);
		}
		
		builder.append("</button>\r\n");
		return builder.toString();
	}
	
	

}
