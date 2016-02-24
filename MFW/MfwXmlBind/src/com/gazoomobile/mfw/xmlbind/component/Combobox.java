package com.gazoomobile.mfw.xmlbind.component;

import java.util.ArrayList;
import java.util.List;

public class Combobox implements TComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5048018041211752497L;
	public String id;
	public String selected;
	public String label;
	public String style;
	private List<Option> options;
	
	public static String STYLE_RADIO = "radio";
	public static String STYLE_COMBO = "combo";
	
	public Combobox() {
		super();
		this.options = new ArrayList<Option>();
	}
	
	public Combobox(String id, String selected, String label, String style,
			List<Option> options) {
		super();
		this.id = id;
		this.selected = selected;
		this.label = label;
		if(style.equalsIgnoreCase(Combobox.STYLE_COMBO) || style.equalsIgnoreCase(Combobox.STYLE_RADIO))
			this.style = style;
		else 
			this.style = Combobox.STYLE_COMBO;
		
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		if(style.equalsIgnoreCase(Combobox.STYLE_COMBO) || style.equalsIgnoreCase(Combobox.STYLE_RADIO))
			this.style = style;
		else 
			this.style = Combobox.STYLE_COMBO;
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
		builder.append("<combobox ");
		if (id == null) 
			throw new RuntimeException(Combobox.class.getName() + " ID is a Mandatory Field");
		
		builder.append("id=\"");
		builder.append(id);
		builder.append("\" ");
		
		if (label != null){ 
			builder.append("label=\"");
			builder.append(label);
			builder.append("\" ");
		}
		
		if (selected != null) {
			builder.append("selected=\"");
			builder.append(selected);
			builder.append("\" ");
		}
		
		if (style != null) {
			builder.append("style=\"");
			builder.append(style);
			builder.append("\" ");
		}
		
		builder.append(">\r\n");
		
		if (options != null) {
			for (Option opt : options) {
				builder.append(opt.toString());
			}
		}
		
		builder.append("</combobox>\r\n");
		return builder.toString();
	}
	
	
	

}
