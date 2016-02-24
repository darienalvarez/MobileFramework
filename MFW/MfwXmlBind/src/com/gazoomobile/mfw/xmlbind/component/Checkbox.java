package com.gazoomobile.mfw.xmlbind.component;

import java.util.ArrayList;
import java.util.List;

public class Checkbox implements TComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6028175113874718562L;
	public String id;
	public String selected;
	private List<Option> options;
	
	public Checkbox() {
		super();
		this.options = new ArrayList<Option>();
	}

	public Checkbox(String id, String selected, List<Option> options) {
		super();
		this.id = id;
		this.selected = selected;
		if(options == null)
			this.options = new ArrayList<Option>();
		else
			this.options = options;
	}
	
	public Option newOption(){
		Option o = new Option();
		options.add(o);
		return o;
	}
	
	public Option newOption(String value, String selected, String textValue){
		Option o = new Option(value, selected, textValue);
		options.add(o);
		return o;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<checkbox ");
		if (id == null) 
			throw new RuntimeException(Checkbox.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
				
		if (selected != null) {
			builder.append("selected=\"");
			builder.append(selected);
			builder.append("\" ");
		}
		builder.append(">\r\n");
		
		if (options != null) {
			for (Option opt : options) {
				builder.append(opt.toString());
			}
		}
		
		builder.append("</checkbox>\r\n");
		return builder.toString();
	}
	
}
