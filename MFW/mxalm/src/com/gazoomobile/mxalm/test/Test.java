/**
 * 
 */
package com.gazoomobile.mxalm.test;

import com.gazoomobile.mxalm.TButton;
import com.gazoomobile.mxalm.TCheckbox;
import com.gazoomobile.mxalm.TColumn;
import com.gazoomobile.mxalm.TEdit;
import com.gazoomobile.mxalm.TForm;
import com.gazoomobile.mxalm.THorizontallayout;
import com.gazoomobile.mxalm.TOption;
import com.gazoomobile.mxalm.TRow;
import com.gazoomobile.mxalm.TTable;
import com.gazoomobile.mxalm.TVerticallayout;
import com.gazoomobile.mxalm.TWindows;
import com.gazoomobile.mxalm.WindowsDocument;

/**
 * @author darien
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		WindowsDocument doc = WindowsDocument.Factory.newInstance();
		
		TWindows w = doc.addNewWindows();
		w.setId("windows1");
		
		TEdit e = w.addNewEdit();
		e.setId("edit1");
		e.setStringValue("Este es un Edit");
		
		TButton b = w.addNewButton();
		b.setId("button1");
		b.setStringValue("Submit Button1");
		
		e = w.addNewEdit();
		e.setId("edit1");
		e.setStringValue("Este es un Edit");
		
		// Adicionando un formulario a la ventana.
		TForm f = w.addNewForm();
		f.setId("form1");
		f.setAction("/my_action");
		
		TButton t = f.addNewButton();
		t.setId("button2");
		t.setStringValue("Submit Button2");
		
		TTable table = f.addNewTable();
		table.setId("tabla1");
		
		TRow row = table.addNewRow();
		TColumn col = row.addNewColumn();
		col.setText("Hello world");
		
		row = table.addNewRow();
		col = row.addNewColumn();
		t = col.addNewButton();
		t.setId("button3");
		t.setStringValue("Submit 3");
		
		row = table.addNewRow();
		col = row.addNewColumn();
		e = col.addNewEdit();
		e.setId("Edit 2");
		e.setStringValue("Soy un edit");
		
		TCheckbox cb = w.addNewCheckbox();
		TOption op = cb.addNewOption();
		op.setStringValue("Option1");
		op.setValue("1");
		op.setSelected("true");
		op = cb.addNewOption();
		op.setStringValue("Option2");
		op.setValue("2");
		op = cb.addNewOption();
		op.setStringValue("Option3");
		op.setValue("3");
		
		TVerticallayout vl = w.addNewVerticallayout();
		THorizontallayout hl = vl.addNewHorizontallayout();
		
		e = hl.addNewEdit();
		e.setId("editlayyout");
		e.setStringValue("mi texto");
		
		
		System.out.println(doc.toString());
	}

}
