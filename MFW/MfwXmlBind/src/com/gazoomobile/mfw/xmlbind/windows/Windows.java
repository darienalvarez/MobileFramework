package com.gazoomobile.mfw.xmlbind.windows;

import java.util.List;

import com.gazoomobile.mfw.xmlbind.component.TComponent;

public class Windows extends AbstractWindows{
	
	private String id;
	private String title;
	private String backgroundColor;
	
	public Windows() {
		super();
	}

	public Windows(String id, String title, String backgroundColor,
			List<TComponent> windowsComponents) {
		super();
		this.id = id;
		this.title = title;
		this.backgroundColor = backgroundColor;
		if(windowsComponents != null)
				this.windowsComponents = windowsComponents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		builder.append("<windows ");
		if (id == null) 
			throw new RuntimeException(Windows.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");

		if (id == null) 
			throw new RuntimeException(Windows.class.getName() + " TITLE is a Mandatory Field");
		
		builder.append("title=\"");
		builder.append(title);
		builder.append("\" ");
		
		if (backgroundColor != null) {
			builder.append("backgroundColor=\"");
			builder.append(backgroundColor);
			builder.append("\" ");
		}
		
		builder.append(">\r\n");
		
		if (windowsComponents != null) {
			for (TComponent winComp : windowsComponents) {
				builder.append(winComp.toString());
			}
		}
		
		builder.append("</windows>\r\n");
		return builder.toString();
	}
	
	
	
}
