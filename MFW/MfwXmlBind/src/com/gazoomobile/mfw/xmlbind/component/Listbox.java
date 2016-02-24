package com.gazoomobile.mfw.xmlbind.component;

import java.util.ArrayList;
import java.util.List;

public class Listbox implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2146623141896409875L;
	private String id;
	private List<Option> options;
	
	public Listbox() {
		super();
		this.options = new ArrayList<Option>();
	}
	
	public Listbox(String id, List<Option> options) {
		super();
		this.id = id;
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

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<listbox ");
		if (id == null) 
			throw new RuntimeException(Listbox.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		builder.append(">\r\n");
		if (options != null) {
			for (Option opt : options) {
				builder.append(opt.toString());
			}
		}

		builder.append("</listbox>\r\n");
		return builder.toString();
	}


	

	

}
