package com.gazoomobile.mfw.xmlbind.component;

public class Option implements TComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;
	private String selected;
	private String textValue;
	
	public Option() {
		super();
	}

	public Option(String value, String selected, String textValue) {
		this.value = value;
		this.selected = selected;
		this.textValue = textValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSelected() {
		return selected;
	}
	
	public void setSelected(String selected) {
		this.selected = selected;
	}

	public String getTextValue() {
		return textValue;
	}
	
	public void setTextValue(String texValue) {
		this.textValue = texValue;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<option ");
		if (selected != null) {
			builder.append("selected=\"");
			builder.append(selected);
			builder.append("\" ");
		}
		
		if (value != null) {
			builder.append("value=\"");
			builder.append(value);
			builder.append("\" ");
		}
		
		builder.append(">");
		
		if (textValue != null) {
			builder.append(textValue);
		}
		
		builder.append("</option>\r\n");
		return builder.toString();
	}
	

}
