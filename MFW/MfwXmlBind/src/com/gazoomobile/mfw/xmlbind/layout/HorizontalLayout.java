package com.gazoomobile.mfw.xmlbind.layout;

import java.util.List;

import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class HorizontalLayout extends AbstractLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -217827175297732688L;
	private String id;
	
	public HorizontalLayout() {
		super();
	}

	public HorizontalLayout(String id, List<TComponent> components) {
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
		builder.append("<horizontallayout ");
		if (id == null) 
			throw new RuntimeException(HorizontalLayout.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");

		builder.append(">\r\n");
		
		if (components != null) {
			for (TComponent comp : components) {
				builder.append(comp.toString());
			}
		}
		
		builder.append("</horizontallayout>\r\n");
		return builder.toString();
	}

}
