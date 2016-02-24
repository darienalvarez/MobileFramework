package org.morfeo.mymw.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Greg Gago
 * 
 * Implements the dynamic generation of document from a valid MyMobileWeb xml
 * source document
 */
public class Parser {

	/** Unique class instance */
	private static Parser instance = new Parser();

	/**
	 * Instance is unique: constructor is not available
	 */
	private Parser() {
		// Set appropiate System Property for SAXDriver
		System.setProperty("org.xml.sax.driver",
				"org.apache.xerces.parsers.SAXParser");
	}

	/**
	 * User can get the DynPresGenerator instance through this method
	 * 
	 * @return DynPresGenerator
	 */
	public static Parser getInstance() {
		return instance;
	}

	/**
	 * Core generator method. Generate in output writer the device-oriented
	 * presentation from a xml input
	 * 
	 * @param sourceXml
	 *            MyMobileWeb source XML document
	 * @param context
	 *            User context
	 * @param writer
	 *            Output writer
	 * @throws SAXException
	 */
	public void generate(String sourceXml)
			throws IOException, SAXException {
		System.out.println("Begins");

		////////////////////////////

		XMLReader xr = XMLReaderFactory.createXMLReader();
		
		//MySAXTest myTest = new MySAXTest();
		ParserHandler handler = new ParserHandler();
		xr.setContentHandler( handler );
		
		File f = new File( sourceXml );
		if( f.exists() && !f.isDirectory() ) {		
		InputStreamReader file = new InputStreamReader(new FileInputStream( sourceXml ), "UTF-8");
		//InputStreamReader file = new InputStreamReader(new FileInputStream( sourceXml ));
		xr.parse( new InputSource(file) );
		} else {
			System.out.println(sourceXml + " is not a file");
		}

		System.out.println("OK!!");

		System.out.println("Ends");
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		try {
			Parser
					.getInstance()
					.generate(
							"D:/codigo_mymw/MyMobileWebUtil/IDEALLanguage/dtd/dial/example14.xhtml");
		} catch (IOException e) {			
			System.out.println("Error:"+e);
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("Error:"+e);
			e.printStackTrace();
		}
	}

}