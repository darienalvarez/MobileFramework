package org.morfeo.mymw.doc;



import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * This class implemets core dynamic presentation proccess, through a SAX
 * interface event-handled proccess supported by a tag stack
 * 
 * @author GregGago
 *  
 */
public class ParserHandler extends DefaultHandler {

	/**
	 * ParserHandler constructor
	 * 
	 */
	public ParserHandler() {
		super();
	}

	///
	/// SAX EVENTS HANDLERS
	///
	/**
	 * An element in XML starts
	 */
	public void startElement(String uri, String name, String qName,
			Attributes atts) throws SAXException {
			System.out.println(qName);
			
			for (int i = 0; i <	atts.getLength(); i ++){
				System.out.println("\t"+atts.getQName(i));
			}
			System.out.println("***");
	}
	

	public void characters(char[] ch,
            int start,
            int length)
     throws SAXException{
			String st = ch.toString();
	}
	
	
	public void endElement(String uri, String localName, java.lang.String qName)
			throws SAXException {
		}
}
