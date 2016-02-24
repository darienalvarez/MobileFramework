package com.gazoomobile.mfw.xmlbind.component;

import java.util.List;

public abstract class ComponentFactory {

	public Button newButton(){
		return new Button();
	}
	
	public Button newButton(String id, String background, String textValue){
		return new Button(id, background, textValue);
	}
	
	public  Checkbox newCheckbox(){
		return new Checkbox();
	}
	
	public  Checkbox newCheckbox(String id, String selected, List<Option> optionList){
		return new Checkbox(id, selected, optionList);
	}
	
	public  Combobox newCombobox(){
		return new Combobox();
	}
	
	public  Combobox newCombobox(String id, String selected, String label, String style, List<Option> optionList){
		return new Combobox(id, selected, label, style, optionList);
	}
	
	public  Edit newEdit(){
		return new Edit();
	}
	
	public  Edit newEdit(String id, String textValue){
		return new Edit(id, textValue);
	}
	
	public  Label newLabel(){
		return new Label();
	}
	
	public  Label newLabel(String id, String textValue){
		return new Label(id, textValue);
	}
	
	public  Linkbutton newLinkbutton(){
		return new Linkbutton();
	}
	
	public  Linkbutton newLinkbutton(String id, String ref, String textValue){
		return new Linkbutton(id, ref, textValue);
	}
	
	public  Listbox newListbox(){
		return new Listbox();
	}
	
	public  Listbox newListbox(String id, List<Option> options){
		return new Listbox(id, options);
	}
	
	public  Textbox newTextbox(){
		return new Textbox();
	}
	
	public  Textbox newTextbox(String id, String textValue){
		return new Textbox(id, textValue);
	}
	
	public Table newTable(){
		return new Table();
	}
	
	public Table newTable(String id, List<Row> rows){
		return new Table(id, rows);
	}
	
	public Error newError(){
		return new Error();
	}
	
	public Error newError(String id, String textValue){
		return new Error(id, textValue);
	}
}
