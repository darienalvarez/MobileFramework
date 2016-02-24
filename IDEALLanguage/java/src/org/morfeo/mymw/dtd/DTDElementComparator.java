package org.morfeo.mymw.dtd;

import java.util.Comparator;

import com.wutka.dtd.DTDElement;

public class DTDElementComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {

		DTDElement ele1 = (DTDElement) arg0;
		DTDElement ele2 = (DTDElement) arg1;

		return ele1.getName().compareTo(ele2.getName());
	}

}
