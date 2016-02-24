package com.gazoomobile.mfw.xmlbind.layout;

import java.util.ArrayList;
import java.util.List;

import com.gazoomobile.mfw.xmlbind.component.Button;
import com.gazoomobile.mfw.xmlbind.component.Checkbox;
import com.gazoomobile.mfw.xmlbind.component.Combobox;
import com.gazoomobile.mfw.xmlbind.component.ComponentFactory;
import com.gazoomobile.mfw.xmlbind.component.Edit;
import com.gazoomobile.mfw.xmlbind.component.Label;
import com.gazoomobile.mfw.xmlbind.component.Linkbutton;
import com.gazoomobile.mfw.xmlbind.component.Listbox;
import com.gazoomobile.mfw.xmlbind.component.Option;
import com.gazoomobile.mfw.xmlbind.component.Row;
import com.gazoomobile.mfw.xmlbind.component.TComponent;
import com.gazoomobile.mfw.xmlbind.component.Table;
import com.gazoomobile.mfw.xmlbind.component.Textbox;

public abstract class AbstractLayout extends ComponentFactory implements TLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1135259988128747414L;
	protected List<TComponent> components;
	
	public AbstractLayout(){
		components = new ArrayList<TComponent>();
	}

	public List<TComponent> getComponents() {
		return components;
	}

	public void setComponents(List<TComponent> components) {
		this.components = components;
	}

	@Override
	public Button newButton() {
		Button component = super.newButton();
		components.add(component);
		return component;
	}

	@Override
	public Button newButton(String id, String background, String textValue) {
		Button component = super.newButton(id, background, textValue);
		components.add(component);
		return component;
	}

	@Override
	public Checkbox newCheckbox() {
		Checkbox component = super.newCheckbox();
		components.add(component);
		return component;
	}

	@Override
	public Checkbox newCheckbox(String id, String selected,
			List<Option> optionList) {
		Checkbox component = super.newCheckbox(id, selected, optionList);
		components.add(component);
		return component;
	}

	@Override
	public Combobox newCombobox() {
		Combobox component =  super.newCombobox();
		components.add(component);
		return component;
	}

	@Override
	public Combobox newCombobox(String id, String selected, String label,
			String style, List<Option> optionList) {
		Combobox component = super.newCombobox(id, selected, label, style, optionList);
		components.add(component);
		return component;
	}

	@Override
	public Edit newEdit() {
		Edit component = super.newEdit();
		components.add(component);
		return component;
	}

	@Override
	public Edit newEdit(String id, String textValue) {
		Edit component = super.newEdit(id, textValue);
		components.add(component);
		return component;
	}

	@Override
	public Label newLabel() {
		Label component =  super.newLabel();
		components.add(component);
		return component;
	}

	@Override
	public Label newLabel(String id, String textValue) {
		Label component =  super.newLabel(id, textValue);
		components.add(component);
		return component;
	}

	@Override
	public Linkbutton newLinkbutton() {
		Linkbutton component = super.newLinkbutton();
		components.add(component);
		return component;
	}

	@Override
	public Linkbutton newLinkbutton(String id, String ref, String textValue) {
		Linkbutton component =  super.newLinkbutton(id, ref, textValue);
		components.add(component);
		return component;
	}

	@Override
	public Listbox newListbox() {
		Listbox component = super.newListbox();
		components.add(component);
		return component;
	}

	@Override
	public Listbox newListbox(String id, List<Option> options) {
		Listbox component =  super.newListbox(id, options);
		components.add(component);
		return component;
	}

	@Override
	public Textbox newTextbox() {
		Textbox component = super.newTextbox();
		components.add(component);
		return component;
	}

	@Override
	public Textbox newTextbox(String id, String textValue) {
		Textbox component = super.newTextbox(id, textValue);
		components.add(component);
		return component;
	}
	
	@Override
	public Table newTable() {
		Table component = super.newTable();
		components.add(component);
		return component;
	}

	@Override
	public Table newTable(String id, List<Row> rows) {
		Table component =  super.newTable(id, rows);
		components.add(component);
		return component;
	}
	
	@Override
	public com.gazoomobile.mfw.xmlbind.component.Error newError() {
		com.gazoomobile.mfw.xmlbind.component.Error component = super.newError();
		components.add(component);
		return component;
	}

	@Override
	public com.gazoomobile.mfw.xmlbind.component.Error newError(String id, String textValue) {
		com.gazoomobile.mfw.xmlbind.component.Error component =  super.newError(id, textValue);
		components.add(component);
		return component;
	}
	
	public VerticalLayout newVerticallayout(){
		VerticalLayout component = new VerticalLayout();
		components.add(component);
		return component;
	}
	
	public VerticalLayout newVerticallayout(String id, List<TComponent> components){
		VerticalLayout component = new VerticalLayout(id, components);
		components.add(component);
		return component;
	}
	
	public HorizontalLayout newHorizontallayout(){
		HorizontalLayout component = new HorizontalLayout();
		components.add(component);
		return component;
	}
	
	public HorizontalLayout newHorizontallayout(String id, List<TComponent> components){
		HorizontalLayout component = new HorizontalLayout(id, components);
		components.add(component);
		return component;
	}
	

}
