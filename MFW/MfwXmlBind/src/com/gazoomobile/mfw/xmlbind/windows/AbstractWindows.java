package com.gazoomobile.mfw.xmlbind.windows;

import java.util.ArrayList;
import java.util.List;

import com.gazoomobile.mfw.xmlbind.component.Button;
import com.gazoomobile.mfw.xmlbind.component.Checkbox;
import com.gazoomobile.mfw.xmlbind.component.Combobox;
import com.gazoomobile.mfw.xmlbind.component.ComponentFactory;
import com.gazoomobile.mfw.xmlbind.component.Edit;
import com.gazoomobile.mfw.xmlbind.component.Error;
import com.gazoomobile.mfw.xmlbind.component.Label;
import com.gazoomobile.mfw.xmlbind.component.Linkbutton;
import com.gazoomobile.mfw.xmlbind.component.Listbox;
import com.gazoomobile.mfw.xmlbind.component.Option;
import com.gazoomobile.mfw.xmlbind.component.Row;
import com.gazoomobile.mfw.xmlbind.component.TComponent;
import com.gazoomobile.mfw.xmlbind.component.Table;
import com.gazoomobile.mfw.xmlbind.component.Textbox;
import com.gazoomobile.mfw.xmlbind.layout.HorizontalLayout;
import com.gazoomobile.mfw.xmlbind.layout.TLayout;
import com.gazoomobile.mfw.xmlbind.layout.VerticalLayout;

public abstract class AbstractWindows extends ComponentFactory{
	
	protected List<TComponent> windowsComponents;
	
	public AbstractWindows(){
		windowsComponents = new ArrayList<TComponent>();
	}
	
	public HorizontalLayout newHorizontallayout(){
		HorizontalLayout hl = new HorizontalLayout();
		windowsComponents.add((TLayout) hl);
		return hl;
	}
	
	public HorizontalLayout newHorizontallayout(String id, List<TComponent> components){
		HorizontalLayout hl = new HorizontalLayout(id, components);
		windowsComponents.add(hl);
		return hl;
	}
	
	public VerticalLayout newVerticallayout(){
		VerticalLayout vl = new VerticalLayout();
		windowsComponents.add(vl);
		return vl;
	}
	
	public VerticalLayout newVerticallayout(String id, List<TComponent> components){
		VerticalLayout vl = new VerticalLayout(id, components);
		windowsComponents.add( vl);
		return vl;
	}
	
	@Override
	public Button newButton() {
		Button component = super.newButton();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Button newButton(String id, String background, String textValue) {
		Button component = super.newButton(id, background, textValue);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Checkbox newCheckbox() {
		Checkbox component = super.newCheckbox();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Checkbox newCheckbox(String id, String selected,
			List<Option> optionList) {
		Checkbox component = super.newCheckbox(id, selected, optionList);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Combobox newCombobox() {
		Combobox component =  super.newCombobox();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Combobox newCombobox(String id, String selected, String label,
			String style, List<Option> optionList) {
		Combobox component = super.newCombobox(id, selected, label, style, optionList);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Edit newEdit() {
		Edit component = super.newEdit();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Edit newEdit(String id, String textValue) {
		Edit component = super.newEdit(id, textValue);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Label newLabel() {
		Label component =  super.newLabel();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Label newLabel(String id, String textValue) {
		Label component =  super.newLabel(id, textValue);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Linkbutton newLinkbutton() {
		Linkbutton component = super.newLinkbutton();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Linkbutton newLinkbutton(String id, String ref, String textValue) {
		Linkbutton component =  super.newLinkbutton(id, ref, textValue);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Listbox newListbox() {
		Listbox component = super.newListbox();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Listbox newListbox(String id, List<Option> options) {
		Listbox component =  super.newListbox(id, options);
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Textbox newTextbox() {
		Textbox component = super.newTextbox();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Textbox newTextbox(String id, String textValue) {
		Textbox component = super.newTextbox(id, textValue);
		windowsComponents.add( component);
		return component;
	}
	
	@Override
	public Table newTable() {
		Table component = super.newTable();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Table newTable(String id, List<Row> rows) {
		Table component =  super.newTable(id, rows);
		windowsComponents.add( component);
		return component;
	}
	
	@Override
	public Error newError() {
		Error component = super.newError();
		windowsComponents.add( component);
		return component;
	}

	@Override
	public Error newError(String id, String textValue) {
		Error component =  super.newError(id, textValue);
		windowsComponents.add( component);
		return component;
	}
	
	public List<TComponent> getWindowsComponents() {
		return windowsComponents;
	}

	public void setWindowsComponents(List<TComponent> windowsComponents) {
		this.windowsComponents = windowsComponents;
	}
}
