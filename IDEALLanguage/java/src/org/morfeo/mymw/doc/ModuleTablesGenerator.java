package org.morfeo.mymw.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.jaxme.xs.XSAtomicType;
import org.apache.ws.jaxme.xs.XSAttribute;
import org.apache.ws.jaxme.xs.XSDocumentation;
import org.apache.ws.jaxme.xs.XSElement;
import org.apache.ws.jaxme.xs.XSEnumeration;
import org.apache.ws.jaxme.xs.XSListType;
import org.apache.ws.jaxme.xs.XSParser;
import org.apache.ws.jaxme.xs.XSSchema;
import org.apache.ws.jaxme.xs.XSSimpleType;
import org.apache.ws.jaxme.xs.XSType;
import org.apache.ws.jaxme.xs.XSUnionType;
import org.apache.ws.jaxme.xs.xml.XsQName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;


public class ModuleTablesGenerator {

	
	private static Hashtable namespacesPrefixes = new Hashtable();
	private static Hashtable namespacesDocUris = new Hashtable();
	private static Hashtable elementsDescriptions = new Hashtable();
	private static Hashtable attributesDescriptions = new Hashtable();
	private static Hashtable attributesTypes = new Hashtable();
	
	private static Properties URLs = new Properties();
	
	private static String targetNamespace;
	private static String targetPrefix;


	/**
	 * @param args
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) {

		if (args.length < 3) {
			System.out
					.println("* First argument is the XML Schema file");
			System.out.println("* Second argument is the Module Description XML (module.desc.xml)");
			System.out.println("* Thrid argument is the path to output");
			System.out.println("* Fourth optional argument is the level of the container. (Default is 3)");
		} else {
			try {
				loadProperties();
				String schemaName = args[0];
				File modulesDesc = new File(args[1]);
				File out = new File(args[2]);
				int level = 3;
				if (args.length >=  4){
					level = Integer.parseInt(args[3]);
				}
				readModulesDesc(modulesDesc);
				parseSchema(schemaName);
				generate(modulesDesc, out, level);
				System.out
						.println("Modules Tables generated successfully.");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private static void readModulesDesc(File input)
	throws ParserConfigurationException, SAXException, IOException {
		Document xmlDoc = null;
		Node module_descNode;
		Node externalNamespacesNode;
		Node moduleNode;
		try {

		      DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
		      DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
		      xmlDoc = docBuilder.parse(input);
		      module_descNode = xmlDoc.getChildNodes().item(0);
		      
		      externalNamespacesNode = getChildByName(module_descNode,"externalNamespaces");
		      moduleNode = getChildByName(module_descNode,"module");
		      
		      parseNameSpaces(externalNamespacesNode);
		      
		      targetNamespace = moduleNode.getAttributes().getNamedItem("targetNamespace").getTextContent();
		      targetPrefix = moduleNode.getAttributes().getNamedItem("targetPrefix").getTextContent();
		      System.out.println("targetNamespace:"+targetNamespace);
		      System.out.println("targetPrefix:"+targetPrefix);
 
	    } catch(Exception e) {
	      System.out.println("Error : " + e);
	      e.printStackTrace();
	    }
	}	
	
	private static void generate(File input, File out, int level)
	throws ParserConfigurationException, SAXException, IOException {
		Document xmlDoc = null;
		Node module_descNode;
		Node externalNamespacesNode;
		Node moduleNode;
		try {
			 PrintWriter writer = new PrintWriter(out, "utf8");

		      DocumentBuilderFactory dbFactory = DocumentBuilderFactoryImpl.newInstance();
		      DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
		      xmlDoc = docBuilder.parse(input);
		      module_descNode = xmlDoc.getChildNodes().item(0);
		      
		      externalNamespacesNode = getChildByName(module_descNode,"externalNamespaces");
		      moduleNode = getChildByName(module_descNode,"module");

		      parseNameSpaces(externalNamespacesNode);
		      parseModule(moduleNode, writer, level);
		      
		      
			writer.close(); 
	    } catch(Exception e) {
	      System.out.println("Error : " + e);
	      e.printStackTrace();
	    }
	}

	private static void loadProperties() throws Exception {

		try {
			// Read properties file.
			String path = System.getProperty("user.dir");
			URLs.load(new FileInputStream(path+ "/java/resources/uri.properties"));
		} catch (IOException e) {
			System.out.println("Can not load properties.");
			throw new Exception(e.getMessage());
		}
	}
	
	private static void parseNameSpaces(Node externalNamespacesNodes) throws ParserConfigurationException, SAXException, IOException {
		Node externalNamespaceNode, node = null;
		String prefix,uri,docuri; 
		for (int i = 0; i < externalNamespacesNodes.getChildNodes().getLength(); i++){
			node = externalNamespacesNodes.getChildNodes().item(i);  
			if (node instanceof Element){  
				externalNamespaceNode = externalNamespacesNodes.getChildNodes().item(i);
				prefix = externalNamespaceNode.getAttributes().getNamedItem("prefix").getTextContent();
				uri = externalNamespaceNode.getAttributes().getNamedItem("uri").getTextContent();
				docuri = externalNamespaceNode.getAttributes().getNamedItem("docuri").getTextContent();
				
				namespacesPrefixes.put(prefix, uri);
				namespacesDocUris.put(uri, docuri);
			}
		}	
	}
	
	private static void parseModule(Node moduleNode, PrintWriter writer, int level) throws ParserConfigurationException, SAXException, IOException {
		Node documentationNode = getChildByName(moduleNode,"documentation");
		Node elementsNode = getChildByName(moduleNode,"elements");
		Node attributesNode = getChildByName(moduleNode,"attributes");
		Node extendsNode = getChildByName(moduleNode,"extends");

		//String documentation = documentationNode.getTextContent();
		String documentation = getWholeElementContent(documentationNode, "");
		String moduleName = moduleNode.getAttributes().getNamedItem("name").getTextContent();
		String targetNamespace = moduleNode.getAttributes().getNamedItem("targetNamespace").getTextContent();
		
		
		writer.println("<div"+level+" id=\"" + getElementNameForID(moduleName)+"-def\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
		writer.println("<head>"+moduleName+"</head>");
		if (documentation != null && !documentation.trim().equals("")){
			writer.println("<p>"+documentation+"</p>");
		}
		
		parseExtends(extendsNode, writer);
		boolean hasElementsAndAttributes = (hasElements(elementsNode) && hasElements(attributesNode)); 

		if (hasElementsAndAttributes){
			writer.println("<div"+(level+1)+" id=\"" + getElementNameForID(moduleName)+"-elements\">");
			writer.println("<head>"+moduleName+" elements</head>");		
		}
		parseElements(elementsNode, targetNamespace, writer);
		if (hasElementsAndAttributes){
			writer.println("</div"+(level+1)+">");
		}
		
		if (hasElementsAndAttributes){
			writer.println("<div"+(level+1)+" id=\"" + getElementNameForID(moduleName)+"-attributes\">");
			writer.println("<head>"+moduleName+" attributes</head>");		
		}
		parseAttributes(attributesNode, targetNamespace, writer);
		if (hasElementsAndAttributes){
			writer.println("</div"+(level+1)+">");
		}				
		writer.println("</div"+level+">");
	}

	private static void parseExtends(Node extendsNode, PrintWriter writer) throws ParserConfigurationException, SAXException, IOException {
		
		String extendsName, docName = null;
		//String extendsLocalName = "";
		String definitionURI = "";
		if (extendsNode!=null){
			if (extendsNode instanceof Element){
				extendsName = extendsNode.getAttributes().getNamedItem("name").getTextContent();
				docName = extendsNode.getAttributes().getNamedItem("docName").getTextContent();
				
				definitionURI = getDefinitionURI(extendsName, docName);

				writer.println("<p>All content sets and elements/attributes of ");
				writeLocation(writer, definitionURI, extendsName);
				writer.println(" are mandatory and extended with the following elements:</p>");				
			}
		}
	}
	
	private static void parseElements(Node elementsNode, String targetNamespace, PrintWriter writer) throws ParserConfigurationException, SAXException, IOException {

		if (elementsNode != null){
			writer.println("<table border='1' cellpadding='3' width='100%'>");
			writer.println("<thead>");
			writer.println("<tr>");
			writer.println("<th colspan=\"4\">Elements</th>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<th>Markup</th>");
			writer.println("<th>Purpose</th>");
			writer.println("<th>Content Model</th>");
			writer.println("<th>Attributes</th>");
			writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>");
			
			String definitionURI, attributesURI, description = null;
			String elementName, docName = null;
			Node elementNode = null;
	
			for (int i = 0; i < elementsNode.getChildNodes().getLength(); i++){
				elementNode = elementsNode.getChildNodes().item(i);
				if (elementNode instanceof Element){  
					elementName = elementNode.getAttributes().getNamedItem("name").getTextContent();
					docName = elementNode.getAttributes().getNamedItem("docName").getTextContent();
					description = getElementDescription (elementName);
					definitionURI = getDefinitionURI(elementName,docName);
					attributesURI = getAttributesURI(elementName);				
		
					writer.println("<tr valign='middle'>");
					writer.println("<td>&lt;"+elementName+"&gt;</td>");
					if (isExternalElementOrAttribute(elementName,targetNamespace)){
						writer.println("<td colspan=\"3\">");
							writeLocation(writer, definitionURI, "See "+elementName+" element");
						writer.println("</td>");				}
					else{
						writer.println("<td>"+escapeString2XML(description)+"</td>");
						writer.println("<td>");
							writeLocation(writer, definitionURI, "See");
						writer.println("</td>");
						writer.println("<td>");
						writeLocation(writer, attributesURI, "See");
						writer.println("</td>");				
					}
					writer.println("</tr>");					
				}
			}
			
			writer.println("</tbody>");
			writer.println("</table>");
		}
	}
	
	private static void parseAttributes(Node attributesNode, String targetNamespace, PrintWriter writer) throws ParserConfigurationException, SAXException, IOException {
	
		if (attributesNode != null){
			writer.println("<table border='1' cellpadding='3' width='100%'>");
			writer.println("<thead>");
			writer.println("<tr>");
			writer.println("<th colspan=\"3\">Attributes</th>");
			writer.println("</tr>");
			writer.println("<tr>");
			writer.println("<th>Markup</th>");
			writer.println("<th>Purpose</th>");
			writer.println("<th>Definition</th>");
			writer.println("</tr>");
			writer.println("</thead>");
			writer.println("<tbody>");		
			String description = null;
			String attributeName = null;
			Node attributeNode = null;
	
			for (int i = 0; i < attributesNode.getChildNodes().getLength(); i++){
				attributeNode = attributesNode.getChildNodes().item(i);
				if (attributeNode instanceof Element){
					attributeName = attributeNode.getAttributes().getNamedItem("name").getTextContent();

					description = getAttributeDescription(attributeName);
									
		
					writer.println("<tr valign='middle'>");
					writer.println("<td>"+attributeName+"</td>");
					if (isExternalElementOrAttribute(attributeName,targetNamespace)){
						String docName = attributeNode.getAttributes().getNamedItem("docName").getTextContent();
						String definitionURI = getDefinitionURI(attributeName,docName);
						
						writer.println("<td colspan=\"2\">");
							writeLocation(writer, definitionURI, "See "+attributeName+" attribute");
						writer.println("</td>");
					}
					else{						
						String attributeType  = getAttributeType(attributeName);
						String definitionURI = getAttributeTypeURL(attributeType);
						writer.println("<td>"+escapeString2XML(description)+"</td>");
						writer.println("<td>");
							writeLocation(writer, definitionURI,attributeType);
						writer.println("</td>");	
					}
					writer.println("</tr>");					
				}
			}			
			writer.println("</tbody>");
			writer.println("</table>");
		}
	}
	
	
	private static void parseSchema (String schemaFilename){
		
		try{
			File input = new File(schemaFilename);
			XSParser xsp = new XSParser();
			xsp.setValidating(false);
	
			InputSource isource = new InputSource(new FileInputStream(input));
			isource.setSystemId(input.toURI().toString());
			XSSchema schema = xsp.parse(isource);
	
			// Print the names of all global elements.
			XSElement[] elements = schema.getElements();
			XSElement element;
			String name;
			String description;
			for (int i = 0; i < elements.length; i++) {
				element = elements[i];

				name = getName(element.getName(), targetPrefix);
				description = searchDescriptionForElementInXSD(element);
				elementsDescriptions.put(name, description);
			}
			
			XSAttribute[] attributes = schema.getAttributes();
			XSAttribute attribute;

			for (int i = 0; i < attributes.length; i++) {
				attribute = attributes[i];
				name = getName(attribute.getName(), targetPrefix);
				description = searchDescriptionForAttributeInXSD(attribute);
				
				//System.out.println(name+":"+attribute.getType());
				if (attribute.getType().getName() != null) {
					String typeName = attribute.getType().getName().getLocalName();
					attributesTypes.put(name, typeName);		

				} else if (attribute.getType().getSimpleType() instanceof XSAtomicType) {
					XSSimpleType simple = attribute.getType()
							.getSimpleType();
					String typeName = simple.getRestrictedType().getName()
							.getLocalName();
					attributesTypes.put(name, typeName);
				} else if (attribute.getType().getSimpleType() instanceof XSListType) {
					String typeName;
					if ("includenamespaceprefixes".equals(attribute
							.getName().getLocalName())) {
						typeName = "NMTOKENS";
					} else {
						XSSimpleType simple = attribute.getType()
								.getSimpleType();
						typeName = "List of "+simple.getListType()
								.getItemType().getName().getLocalName();
					}
					attributesTypes.put(name, typeName);
				}				
				attributesDescriptions.put(name, description);
			}			
		}
		catch (Exception e) {
			System.out.print("Error en schema :"+schemaFilename);
			e.printStackTrace();
		}

	}
	
	private static boolean hasElements(Node nodes){
		Node elementNode;
		boolean hasElements = false;
		int i = 0;
		while (nodes!=null && !hasElements &&  nodes.getChildNodes()!=null && i < nodes.getChildNodes().getLength()){
			elementNode = nodes.getChildNodes().item(i);
			if (elementNode instanceof Element){
				hasElements =  true;
			}
			i++;
		}				
		return hasElements;
	}
	
	private static String getElementNameForID(String name) {
		if (name.contains(":")){
			name = name.replace(":", "_");
		}
		if (name.contains("(")){
			name = name.replace("(", "_");
		}
		if (name.contains(")")){
			name = name.replace(")", "_");
		}		
		name = name.replace(" ", "_");
		return name;
	}
	
		
	private static String getAttributesURI(String name) {
		return "#"+name+"-attributes";
	}
	
	private static boolean isExternalElementOrAttribute(String elementname, String targetNamespace) {
		String prefix;
		String namespace;

		boolean isExternalElement = false;
		if (elementname.contains(":")){
			prefix = elementname.substring(0,elementname.indexOf(":"));
			if (namespacesPrefixes.containsKey(prefix)){
				namespace = (String) namespacesPrefixes.get(prefix);
				if (!namespace.equals(targetNamespace)){
					isExternalElement = true;
				}
			}
		}
		
		return isExternalElement;
	}
	
	private static String getDefinitionURI(String name, String docName) {
		String prefix;
		String namespace;
		String docURI ="";
		if (docName.startsWith("http://") ||
				docName.startsWith("https://")){
			docURI = docName; 
		}
		else if (name.contains(":")){
			prefix = name.substring(0,name.indexOf(":"));
			if (namespacesPrefixes.containsKey(prefix)){
				namespace = (String) namespacesPrefixes.get(prefix);
				if (namespacesDocUris.containsKey(namespace)){
					docURI = (String) namespacesDocUris.get(namespace);
					docURI =  docURI+"#"+docName;
				}		
			}
		}
		else{
			docURI = "#"+docName;
		}
		return docURI;
	}
	
	private static String searchDescriptionForElementInXSD(XSElement element) {
		String description = "";
		if (element.getType().getAnnotations().length > 0) {
			if (element.getType().getAnnotations()[0].getDocumentations().length > 0) {
				description = element.getType().getAnnotations()[0].getDocumentations()[0].getText().trim();
			}
		}
		if (element.getAnnotations().length > 0) {
			if (element.getAnnotations()[0].getDocumentations().length > 0) {
				description = element.getAnnotations()[0].getDocumentations()[0].getText().trim();
			}
		}
		return description;
	}
	
	private static String searchDescriptionForAttributeInXSD(XSAttribute attribute) {
		String description = "";
		if (attribute.getType().getAnnotations().length > 0) {
			if (attribute.getType().getAnnotations()[0].getDocumentations().length > 0) {
				description = attribute.getType().getAnnotations()[0].getDocumentations()[0].getText().trim();
			}
		}
		if (attribute.getAnnotations().length > 0) {
			if (attribute.getAnnotations()[0].getDocumentations().length > 0) {
				description = attribute.getAnnotations()[0].getDocumentations()[0].getText().trim();
			}
		}
		return description;
	}	
	
	private static String getElementDescription(String name) {
		String description ="";
		if (elementsDescriptions.containsKey(name)){
			description = (String) elementsDescriptions.get(name);
		}
		return description;
	}
	
	private static String getAttributeDescription(String name) {
		String description ="";
		if (attributesDescriptions.containsKey(name)){
			description = (String) attributesDescriptions.get(name);
		}
		return description;
	}
	
	private static String getAttributeType(String attributeName) {
		String type ="";
		if (attributesTypes.containsKey(attributeName)){
			type = (String) attributesTypes.get(attributeName);
		}
		return type;
	}		
	
	
	private static Node getChildByName(Node n, String name) {
		 NodeList nl = n.getChildNodes();
		 for (int i = 0; i < nl.getLength(); i++) {
		 Node t = nl.item(i);
		 if (t.getNodeName().equals(name))
		  return t;
		 }
		 return null;
		}
	
	private static String getWholeElementContent(Node n, String s) {
		 NodeList nl = n.getChildNodes();
		 for (int i = 0; i < nl.getLength(); i++) {
			 Node t = nl.item(i);
			 if (t.getNodeValue() != null){
				 s = s + t.getNodeValue();
			 }

			 if (t instanceof Element){
				 s = s +"<"+t.getNodeName();
				 NamedNodeMap atts = t.getAttributes();
				 for (int j = 0; j< atts.getLength(); j ++){
					 s = s + " "+atts.item(j).getNodeName();
					 s = s + "=\""+atts.item(j).getNodeValue()+"\"";
				 }
				 s = s +">";
				 s = getWholeElementContent(t, s)+"</"+t.getNodeName()+">";
			 }
		 }
		 return s;
	}
	
	public static String getName(XsQName name, String targetPrefix) {
		return getName(name, targetPrefix, ":");
	}
	
	public static String getName(XsQName name, String targetPrefix, String separator) {

		String localName = name.getLocalName();
		String prefix = name.getPrefix();
		if (prefix == null || prefix.equals("")){
			prefix = getPrefixForNamespace(name.getNamespaceURI());
		}
		if (prefix != null && !prefix.equals("") && !prefix.equals(targetPrefix)) {
			prefix = prefix + separator;
		} else {
			prefix = "";
		}

		return prefix + localName;		
	}
	private static String getPrefixForNamespace(String namespace) {
		String prefix = "";
		if (namespacesPrefixes.containsValue(namespace)){
			Enumeration enumeration = namespacesPrefixes.keys();
			String key; 
			while (enumeration.hasMoreElements() && prefix.equals("")){
				key = (String) enumeration.nextElement();
				if (namespacesPrefixes.get(key).equals(namespace)){
					prefix = key;
				}
			}
		}
		return prefix;
	}
	private static String escapeString2XML(String text) {
		if (text != null){
			text = text.replace("<", "&lt;");
			text = text.replace(">", "&gt;");
		}
		return text;
	}

	private static void writeLocation(PrintWriter writer, String loc,
			String name) {
		if (loc != null) {
			writer.print("<loc href=\"");
			writer.print(loc + "\"");
			writer.print(" xlink:show=\"replace\"");
			writer.print(" xlink:actuate=\"onRequest\"");
			writer.print(">");
		}
		writer.print(name);
		if (loc != null)
			writer.println("</loc>");
	}
	
	/*
	private static String getContentTypeURL(String contenttype) {
		return URLs.getProperty(contenttype);
	}
	*/
	private static String getAttributeTypeURL(String atttype) {
		return URLs.getProperty(atttype);
	}
}
