package com.gazoomobile.mfw.xmlbind.component;

import java.util.ArrayList;
import java.util.List;

public class Row implements TComponent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String background;
	private List<Column> columns;
	
	public Row() {
		super();
		this.columns = new ArrayList<Column>();
	}

	public Row(String background, List<Column> columns) {
		super();
		this.background = background;
		if(columns == null)
			this.columns = new ArrayList<Column>();
		else
			this.columns = columns;
	}
	
	public Column newColumn(){
		Column c = new Column();
		columns.add(c);
		return c;
	}
	
	public Column newColumn(String colspan, String textValue){
		Column c = new Column(colspan, textValue);
		columns.add(c);
		return c;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<row ");
				
		if (background != null) {
			builder.append("background=\"");
			builder.append(background);
			builder.append("\" ");
		}
		builder.append(">\r\n");
		
		if (columns != null) {
			for (Column col : columns) {
				builder.append(col.toString());
			}
		}
		
		builder.append("</row>\r\n");
		return builder.toString();
	}

}
