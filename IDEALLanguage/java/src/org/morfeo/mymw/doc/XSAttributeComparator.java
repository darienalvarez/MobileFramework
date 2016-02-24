package org.morfeo.mymw.doc;

import java.util.Comparator;

import org.apache.ws.jaxme.xs.XSAttribute;

public class XSAttributeComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {

		int ret = -1;

		try {
			XSAttribute ele1 = (XSAttribute) arg0;
			XSAttribute ele2 = (XSAttribute) arg1;

			ret = Generator.getElementName(ele1.getName()).compareTo(
					Generator.getElementName(ele2.getName()));
		} catch (ClassCastException e) {
		}

		return ret;

	}

}
