package com.gazoomobile.mfw.xmlbind.component;

public class Column implements TComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String colspan;
	private String textValue;
	
	public Column() {
		super();
	}

	public Column(String colspan, String textValue) {
		super();
		this.colspan = colspan;
		this.textValue = textValue;
	}

	public String getColspan() {
		return colspan;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
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
		builder.append("<column ");
		

		if (colspan != null) {
			builder.append("colspan=\"");
			builder.append(colspan);
			builder.append("\"");
		}
		
		builder.append(">");
		
		if (textValue != null) {
			builder.append(textValue);
		}
		
		builder.append("</column>\r\n");
		return builder.toString();
	}
	
	
	
}
