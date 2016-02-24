package com.gazoomobile.mfw.xmlbind.layout;

import java.util.List;

import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class VerticalLayout extends AbstractLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6147252390316975578L;
	private String id;
	
	public VerticalLayout() {
		super();
	}

	public VerticalLayout(String id, List<TComponent> components) {
		super();
		this.id = id;
		if(components != null)
			this.components = components;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<verticallayout ");
		if (id == null) 
			throw new RuntimeException(VerticalLayout.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");

		builder.append(">\r\n");
		
		if (components != null) {
			for (TComponent comp : components) {
				builder.append(comp.toString());
			}
		}
		
		builder.append("</verticallayout>\r\n");
		return builder.toString();
	}

	
}
