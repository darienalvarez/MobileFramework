package org.morfeo.mymw.doc;

import java.util.Comparator;

import org.apache.ws.jaxme.xs.XSElement;

public class XSElementComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {

		XSElement ele1 = (XSElement) arg0;
		XSElement ele2 = (XSElement) arg1;

		return Generator.getElementName(ele1.getName()).compareTo(
				Generator.getElementName(ele2.getName()));

	}

}
