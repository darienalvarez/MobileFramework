package com.gazoomobile.mfw.xmlbind.component;

import java.util.ArrayList;
import java.util.List;

public class Table implements TComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4117065723952593215L;
	private String id;
	private List<Row> rows;
	
	public Table() {
		super();
		this.rows = new ArrayList<Row>();
	}

	public Table(String id, List<Row> rows) {
		super();
		this.id = id;
		if(rows == null)
			this.rows = new ArrayList<Row>();
		else
			this.rows = rows;
	}
	
	public Row newRow(){
		Row r = new Row();
		rows.add(r);
		return r;
	}
	
	public Row newRow(String background, List<Column> columnList){
		Row r = new Row(background, columnList);
		rows.add(r);
		return r;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<table ");
		if (id == null) 
			throw new RuntimeException(Table.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
				
		builder.append(">\r\n");
		
		if (rows != null) {
			for (Row row : rows) {
				builder.append(row.toString());
			}
		}
		
		builder.append("</table>\r\n");
		return builder.toString();
	}
	
}
