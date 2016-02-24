package org.morfeo.mymw.doc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.morfeo.mymw.dtd.DTDElementComparator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.wutka.dtd.DTD;
import com.wutka.dtd.DTDAttribute;
import com.wutka.dtd.DTDCardinal;
import com.wutka.dtd.DTDChoice;
import com.wutka.dtd.DTDContainer;
import com.wutka.dtd.DTDElement;
import com.wutka.dtd.DTDEmpty;
import com.wutka.dtd.DTDEnumeration;
import com.wutka.dtd.DTDItem;
import com.wutka.dtd.DTDMixed;
import com.wutka.dtd.DTDName;
import com.wutka.dtd.DTDPCData;
import com.wutka.dtd.DTDParser;
import com.wutka.dtd.DTDSequence;

public class ParserDTD {


	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out.println("* First argument is the DTD file.");
			System.out.println("* Second argument is the output file.");
		} else {
			File input = new File(args[0]);
			File out = new File(args[1]);
			listElements(input, out);
			
		}
	}


	private static void listElements(File input, File out) throws IOException {
		DTDParser parser = new DTDParser(input);
		DTD dtd = parser.parse();
		
		Vector res = dtd.getItemsByType(DTDElement.class);
		java.util.Collections.sort(res, new DTDElementComparator());
		String name, attr;
		PrintWriter writer = new PrintWriter(out, "utf8");
		writer.println("Elements:");
		
		for (Iterator iterator = res.iterator(); iterator.hasNext();) {
			DTDElement ele = (DTDElement) iterator.next();
			name = ele.getName();
			System.out.println(name);
			writer.println(name);
			writer.print("attributes:");
			Enumeration enumeration = ele.attributes.elements();
			while (enumeration.hasMoreElements()) {
				attr = ((DTDAttribute) enumeration.nextElement()).getName();
				System.out.print(attr+" ");
				writer.print(attr+" ");
			}
			System.out.println("\n");
			writer.println("");
			writer.println("");
		}		
		writer.close();
	}
	}
