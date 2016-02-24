/**
 * 
 */
package com.gazoomobile.mfw.xmlbind.component;

/**
 * @author Administrator
 *
 */
public class Error implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2754712286056307794L;
	private String id;
	private String textValue;
	
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

	public Error() {
		super();
	}
	
	public Error(String id, String textValue) {
		super();
		this.id = id;
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<error ");
		
		if (id == null) 
			throw new RuntimeException(Error.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\">");
		
		if (textValue != null) {
			builder.append(textValue);
		}
		
		builder.append("</error>\r\n");
		return builder.toString();
	}
	
}
