package com.gazoomobile.mfw.xmbind.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.gazoomobile.mfw.xmlbind.component.Checkbox;
import com.gazoomobile.mfw.xmlbind.component.Combobox;
import com.gazoomobile.mfw.xmlbind.component.Listbox;
import com.gazoomobile.mfw.xmlbind.component.Row;
import com.gazoomobile.mfw.xmlbind.component.Table;
import com.gazoomobile.mfw.xmlbind.layout.HorizontalLayout;
import com.gazoomobile.mfw.xmlbind.layout.VerticalLayout;
import com.gazoomobile.mfw.xmlbind.windows.Windows;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Windows w = new Windows("123", "windows1", "red", null);
		w.newEdit("edit1", "mi texto");
		w.newEdit("edit2", "mi texto2");
		w.newButton("b1", "azul", "Boton1");
		Checkbox cb = w.newCheckbox("check1", "true", null);
		cb.newOption("value1", "true", "opcion1");
		cb.newOption("value2", null, "opcion2");
		cb.newOption("value3", null, "opcion3");
		cb.newOption("value4", null, "opcion4");
		Combobox cbox =w.newCombobox("combo1", "true", "Combo_Label", Combobox.STYLE_COMBO, null);
		cbox.newOption("value1", "true", "opcion1");
		cbox.newOption("value2", null, "opcion2");
		cbox.newOption("value3", null, "opcion3");
		cbox.newOption("value4", null, "opcion4");
		w.newLabel("l1", "labelText");
		w.newLinkbutton("link1", "boton:pagina1", "linkButton");
		Listbox lb = w.newListbox("list1", null);
		lb.newOption("value1", "true", "opcion1");
		lb.newOption("value2", null, "opcion2");
		lb.newOption("value3", null, "opcion3");
		lb.newOption("value4", null, "opcion4");
		w.newTextbox("text1", "este es un textbox");
		Table t = w.newTable("mitabla", null);
		Row r = t.newRow("red", null);
		r.newColumn(null, "columna1");
		r.newColumn(null, "columna2");
		r = t.newRow("red", null);
		r.newColumn(null, "columna1");
		r.newColumn(null, "columna2");
		r = t.newRow("red", null);
		r.newColumn(null, "columna1");
		r.newColumn(null, "columna2");
		
		HorizontalLayout l = w.newHorizontallayout("mi layout", null);
		l.newEdit("edit2", "mi texto2");
		l.newButton("b1", "azul", "Boton1");
		cb = l.newCheckbox("check1", "true", null);
		cb.newOption("value1", "true", "opcion1");
		cb.newOption("value2", null, "opcion2");
		cb.newOption("value3", null, "opcion3");
		cb.newOption("value4", null, "opcion4");
		cbox = l.newCombobox("combo1", "true", "Combo_Label", Combobox.STYLE_COMBO, null);
		cbox.newOption("value1", "true", "opcion1");
		cbox.newOption("value2", null, "opcion2");
		cbox.newOption("value3", null, "opcion3");
		cbox.newOption("value4", null, "opcion4");
		l.newLabel("l1", "labelText");
		l.newLinkbutton("link1", "boton:pagina1", "linkButton");
		lb = l.newListbox("list1", null);
		lb.newOption("value1", "true", "opcion1");
		lb.newOption("value2", null, "opcion2");
		lb.newOption("value3", null, "opcion3");
		lb.newOption("value4", null, "opcion4");
		l.newTextbox("text1", "este es un textbox");
		l.newError("error1", "tremendo palo");
		
		VerticalLayout vl = w.newVerticallayout("mi layout", null);
		vl.newEdit("edit2", "mi texto2");
		vl.newButton("b1", "azul", "Boton1");
		cb = vl.newCheckbox("check1", "true", null);
		cb.newOption("value1", "true", "opcion1");
		cb.newOption("value2", null, "opcion2");
		cb.newOption("value3", null, "opcion3");
		cb.newOption("value4", null, "opcion4");
		cbox = vl.newCombobox("combo1", "true", "Combo_Label", Combobox.STYLE_COMBO, null);
		cbox.newOption("value1", "true", "opcion1");
		cbox.newOption("value2", null, "opcion2");
		cbox.newOption("value3", null, "opcion3");
		cbox.newOption("value4", null, "opcion4");
		vl.newLabel("l1", "labelText");
		vl.newLinkbutton("link1", "boton:pagina1", "linkButton");
		lb = vl.newListbox("list1", null);
		lb.newOption("value1", "true", "opcion1");
		lb.newOption("value2", null, "opcion2");
		lb.newOption("value3", null, "opcion3");
		lb.newOption("value4", null, "opcion4");
		vl.newTextbox("text1", "este es un textbox");
		
		System.out.println(w.toString()); 
		
		try {
			PrintWriter p = new PrintWriter("example.xml");
			p.append(w.toString());
			p.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
