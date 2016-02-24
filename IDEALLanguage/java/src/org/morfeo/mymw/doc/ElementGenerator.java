package org.morfeo.mymw.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.jaxme.xs.XSAnnotation;
import org.apache.ws.jaxme.xs.XSAtomicType;
import org.apache.ws.jaxme.xs.XSAttributable;
import org.apache.ws.jaxme.xs.XSAttribute;
import org.apache.ws.jaxme.xs.XSComplexType;
import org.apache.ws.jaxme.xs.XSDocumentation;
import org.apache.ws.jaxme.xs.XSElement;
import org.apache.ws.jaxme.xs.XSEnumeration;
import org.apache.ws.jaxme.xs.XSGroup;
import org.apache.ws.jaxme.xs.XSListType;
import org.apache.ws.jaxme.xs.XSParser;
import org.apache.ws.jaxme.xs.XSParticle;
import org.apache.ws.jaxme.xs.XSSchema;
import org.apache.ws.jaxme.xs.XSSimpleType;
import org.apache.ws.jaxme.xs.XSType;
import org.apache.ws.jaxme.xs.XSUnionType;
import org.apache.ws.jaxme.xs.xml.XsAnyURI;
import org.apache.ws.jaxme.xs.xml.XsQName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;

public class ElementGenerator {

	private static Properties URLs = new Properties();
	private static Properties groupNames = new Properties();
	private static Properties elementsExcluded = new Properties();
	private static Properties namespacesExcluded = new Properties();
	private static Properties attributesDocumentation = new Properties();
	
	private static Hashtable attributesCollection = new Hashtable();	
	private static Hashtable namespacesPrefixes = new Hashtable();
	private static String targetNamespace;
	private static String targetPrefix;

	private static String getURL(String type) {
		if (URLs.getProperty(type) != null){
			return URLs.getProperty(type).trim();
		}
		return null;
	}

	private static String getHumanName(XSGroup group) {
		String ret = null;

		if (group != null && group.getName() != null)
			ret = groupNames.getProperty(group.getName().getLocalName());

		if (ret != null)
			ret = ret.trim();

		return ret;
	}
	private static String getHumanName(String group) {
		String ret = null;

		if (group != null )
			ret = groupNames.getProperty(group);

		if (ret != null)
			ret = ret.trim();

		return ret;
	}
	

	/**
	 * Read properties file.
	 * 
	 * @throws Throwable
	 */
	private static void loadProperties(String targetPrefix) throws Throwable {

		try {
			// Read properties file.
			String path = System.getProperty("user.dir");
			URLs.load(new FileInputStream(path
					+ "/java/resources/uri.properties"));
			groupNames.load(new FileInputStream(path
					+ "/java/resources/group.name.properties"));
			elementsExcluded.load(new FileInputStream(path
					+ "/java/resources/elements.excluded.properties"));
			namespacesExcluded.load(new FileInputStream(path
					+ "/java/resources/namespaces.excluded.properties"));
			attributesDocumentation.load(new FileInputStream(path
					+ "/java/resources/attributes.documentation.properties"));
			
			Properties tmp = new Properties();
			tmp.load(new FileInputStream(path
					+ "/java/resources/attributes.collections.properties"));
			Enumeration keys = tmp.keys();
			String key;
			String attributeName;
			List attributes;
			String[] elements;
			String elementsList;
			while (keys.hasMoreElements()) {
				key = (String) keys.nextElement();
				elementsList = tmp.getProperty(key);
				elements = elementsList.split(",");
				attributes = new ArrayList();
				for (int i = 0; i < elements.length; i++) {
					attributeName = getAttributePrefixAndName(elements[i].trim(),targetPrefix);
					attributes.add(attributeName);
				}
				attributesCollection.put(key, attributes);	
			}

		} catch (IOException e) {
			System.out.println("Can not load properties.");
			throw new Throwable(e.getMessage());
		}

	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("* First argument is the XML Schema file");
			System.out.println("* Second argument is the Module Description XML (module.desc.xml)");
			System.out.println("* Thrid argument is the path to output");			
		} else {
			try {			
				File input = new File(args[0]);
				File modulesDesc = new File (args[1]);
				File out = new File(args[2]);
				readModulesDesc(modulesDesc);
				loadProperties(targetPrefix);
				generate(input, out);
				System.out
						.println("XML Schema was exported to HTML successfully.");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private static void generate(File input, File out)
			throws ParserConfigurationException, SAXException, IOException {

		PrintWriter writer = new PrintWriter(out, "utf8");
		
		writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		writer.println("<div1 id=\"elements\" xmlns:xlink=\"http://www.w3.org/1999/xlink\">");
		writer.println("<head> Elements </head>");
		
		XSParser xsp = new XSParser();
		xsp.setValidating(false);

		InputSource isource = new InputSource(new FileInputStream(input));
		isource.setSystemId(input.toURI().toString());
		XSSchema schema = xsp.parse(isource);

		List definedElements = new ArrayList();
		// Print the names of all global elements.
		XSElement[] elements = schema.getElements();
		Arrays.sort(elements, new XSElementComparator());
		
		//String prefix;
		String namespaceURI;
		
		for (int i = 0; i < elements.length; i++) {
			//prefix = elements[i].getName().getPrefix();			
			namespaceURI = elements[i].getName().getNamespaceURI();
			if (!definedElements.contains(elements[i].getName()) &&
				elementNeedsDefinition(elements[i])	) {
				writer.print("<div2 id=\"");
				writer.print(getElementNameForID(elements[i].getName(),targetPrefix));
				writer.println("-element\">");
				writer.print("<head>The <code>&lt;");
				writer.print(getElementName(elements[i].getName(),targetPrefix));
				writer.println("&gt;</code> element</head>");
				addContentModelSection(elements[i], writer);
				addAttributesSection(schema, elements[i], writer);

				if (!namespaceURI.equals(targetNamespace)){
					addExternalElementReference(elements[i], writer);	
				}
				writer.println("</div2>");					
				definedElements.add(elements[i].getName());
			}
		}

		writer.println("</div1>");
		writer.close();

	}

	private static boolean isNextXSParticlePrinted(XSParticle particle) {

		boolean ret = false;

		if (particle.isElement()) {
			if (elementNeedsDefinition(particle.getElement())){
				ret = true;	
			}
		} else if (particle.isGroup()) {
			ret = addContentModelGroup(particle.getGroup(), new StringBuffer(),
					-2, -2, false);
		}

		return ret;
	}
	
	private static void addContentModelSubGroup(XSGroup group,
			StringBuffer buffer) {

		XSParticle[] particles = group.getParticles();
		int size = particles.length;

		for (int i = 0; i < size; i++) {
			XSParticle particle = particles[i];
			if (particle.isGroup() && particle.getGroup().getName() != null) {
				String name = getHumanName(particle.getGroup());
				String url = getURL(particle.getGroup().getName()
						.getLocalName());
				buffer.append(" | <loc href=\"");
				buffer.append(url + "\"");
				buffer.append(" xlink:show=\"replace\"");
				buffer.append(" xlink:actuate=\"onRequest\"");
				buffer.append(">");
				buffer.append(name);
				buffer.append("</loc>");
			}

		}
	}

	private static boolean nextXSParticlePrinted(XSParticle[] particles) {
		boolean ret = false;
		int size = particles.length;
		for (int i = 0; i < size; i++) {
			XSParticle particle = particles[i];

			if (particle.isElement() &&  
				elementNeedsDefinition(particle.getElement())
				) {
				ret = true;
			} else if (particle.isGroup()) {
				if (particle.getGroup().getName() != null
						&& getHumanName(particle.getGroup()) != null) {
					ret = true;
				}
			} 
		}
		return ret;
	}	
	
	private static boolean addContentModelGroup(XSGroup group,
			StringBuffer buffer, int minOccurs, int maxOccurs,
			boolean openParentheses) {

		boolean ret = false;

		XSParticle[] particles = group.getParticles();
		int size = particles.length;
		
		boolean nextPrinted = nextXSParticlePrinted(particles);

		if (openParentheses && nextPrinted)
			buffer.append("( ");

		boolean previousPrinted = false;
		for (int i = 0; i < size; i++) {
			XSParticle particle = particles[i];

			if (previousPrinted && isNextXSParticlePrinted(particle)) {
				if (group.isSequence())
					buffer.append(" , ");
				else if (group.isChoice())
					buffer.append(" | ");
				else if (group.isAll())
					buffer.append(" ");
			}

			if (particle.isElement() &&  
				elementNeedsDefinition(particle.getElement())
				) {
				ret = previousPrinted = true;
				String name = getElementName(particle.getElement().getName(),targetPrefix);
				String nameForID = getElementNameForID(particle.getElement().getName(),targetPrefix);
				String url = "#" + nameForID + "-element";
				buffer.append("<loc href=\"");
				buffer.append(url + "\"");
				buffer.append(" xlink:show=\"replace\"");
				buffer.append(" xlink:actuate=\"onRequest\"");
				buffer.append(">");
				buffer.append(name);
				buffer.append("</loc>");
				if (particle.getMinOccurs() == 0
						&& particle.getMaxOccurs() == 1) {
					buffer.append("?");
				} else if (particle.getMinOccurs() == 0
						&& particle.getMaxOccurs() == -1) {
					buffer.append("*");
				} else if (particle.getMinOccurs() == 1
						&& particle.getMaxOccurs() == -1) {
					buffer.append("+");
				}	
			} else if (particle.isGroup()) {
				if (particle.getGroup().getName() != null
						&& getHumanName(particle.getGroup()) != null) {
					previousPrinted = ret = true;
					String name = getHumanName(particle.getGroup());
					String url = getURL(particle.getGroup().getName()
							.getLocalName());
					buffer.append("<loc href=\"");
					buffer.append(url + "\"");
					buffer.append(" xlink:show=\"replace\"");
					buffer.append(" xlink:actuate=\"onRequest\"");
					buffer.append(">");
					buffer.append(name);
					buffer.append("</loc>");
					addContentModelSubGroup(particle.getGroup(), buffer);
				} else {
					previousPrinted = addContentModelGroup(particle.getGroup(),
							buffer, particle.getMinOccurs(), particle
									.getMaxOccurs(), true);
					if (previousPrinted)
						ret = true;
				}
			} else {
				previousPrinted = false;
			}

		}

		if (!openParentheses || (ret && nextPrinted))
			buffer.append(" )");

		if (ret) {
			if (minOccurs != -2) {
				if (minOccurs == 0 && maxOccurs == 1) {
					buffer.append("?");
				} else if (minOccurs == 0 && maxOccurs == -1) {
					buffer.append("*");
				} else if (minOccurs == 1 && maxOccurs == -1) {
					buffer.append("+");
				}
			}
		}

		return ret;
	}

	private static String escapeString2XML(String text) {
		text = text.replace("<", "&lt;");
		text = text.replace(">", "&gt;");
		return text;
	}

	private static void addContentModelSection(XSElement element,
			PrintWriter writer) throws SAXException {

		writer.println("<p id=\"" + getElementNameForID(element.getName(),targetPrefix)
				+ "-content-model\">");
		if (element.getType().getAnnotations().length > 0) {
			if (element.getType().getAnnotations()[0].getDocumentations().length > 0) {
				writer.println(escapeString2XML(element.getType()
						.getAnnotations()[0].getDocumentations()[0].getText()));
			}
		}
		writer.println("</p>");

		XSComplexType type = element.getType().getComplexType();
		
		if (type.isExtension()) {
			writer.println("<p><emph>Content Model</emph></p>");
			writer.println("<glist role=\"contentDef\">");
			writer.println("<gitem><label><code>");
			XSType ext = type.getExtendedType();
			if ("string".equals(ext.getName().getLocalName())) {
				writer.println("( PCDATA )*");
			} else {
				writer.println("Extension of " + ext.getName());
			}
			writer.println("</code></label><def></def></gitem></glist>");
		} else {
			XSParticle particle = type.getParticle();
			if (particle != null && particle.isGroup() ){
				writer.println("<p><emph>Content Model</emph></p>");
				writer.println("<glist role=\"contentDef\">");
				writer.println("<gitem><label><code>");
				if ( particle.getGroup().getParticles().length == 0) {
					writer.print(" EMPTY ");
				} else if (type.isMixed()) {
					writer.print("( PCDATA | ");
					StringBuffer tmp = new StringBuffer();
					addContentModelGroup(particle.getGroup(), tmp, -2, -2,
							false);
					writer.println(tmp.toString());
					//writer.print("*");
				} else {
					StringBuffer tmp = new StringBuffer();
					addContentModelGroup(particle.getGroup(), tmp, -2, -2, true);
					writer.println(tmp.toString());
				}
				writer.println("</code></label><def></def></gitem></glist>");
			}
		}
	}

	private static void addExternalElementReference(XSElement element,
			PrintWriter writer) throws SAXException {

		String url = getURL(getElementName(element.getName(),targetPrefix));
		writer.println("<p id=\"" + getElementNameForID(element.getName(),targetPrefix)
				+ "-external-content-model\">");
		writer.print("View definition of this element is on " + "<loc href='"
				+ url + "'  xlink:show='replace' xlink:actuate='onRequest'>" + getElementName(element.getName(),targetPrefix) + "</loc></p>");

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

	private static boolean hasAllAttributes(XSAttributable[] all,
			List attributes) {
		int cont = 0;
		String attributeName;
		for (int i = 0; i < all.length; i++) {
			try {
				XSAttribute attr = (XSAttribute) all[i];
				attributeName = getAttributePrefixAndName(getElementName(attr.getName(),targetPrefix),targetPrefix);
				if (attributes.contains(attributeName)){
					cont++;
				}
			} catch (ClassCastException e) {
			}
		}
		return cont == attributes.size();
	}

	private static void addAttributesSection(XSSchema schema,
			XSElement element, PrintWriter writer) throws SAXException {

		String elementLocalName = element.getName().getLocalName();
		writer.println("<p id=\"" + getElementNameForID(element.getName(),targetPrefix)
				+ "-attributes\"><emph>Attributes</emph></p>");
		XSComplexType type = element.getType().getComplexType();

//		if (!elementsWithoutCommonAttributes.contains(elementLocalName))
//			writer.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#common-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Common</loc> collection</label><def><p>Collection of common attributes.</p></def></gitem></glist>");

		boolean includedEmbeddingAttributes = false;
		boolean includedHypertextAttributes = false;
		boolean includedRepeatAttributes = false;
		boolean includedEventsAttributes = false;
		boolean includedBindingAttributes = false;
		boolean includedModelItemPropertyAttributes = false;
		XSAttributable[] attributes = type.getAttributes();
		Arrays.sort(attributes, new XSAttributeComparator());

		List alreadyIncludedAttributes = new ArrayList();
		String key;
		Enumeration keys = attributesCollection.keys();
		List attributesList;
		while (keys.hasMoreElements()) {
			key = (String) keys.nextElement();
			attributesList = (List) attributesCollection.get(key);
			if (hasAllAttributes(attributes, attributesList)) {
				writer.println("<glist role=\"attrDef\"><gitem>");
				writer.println("<label>The <loc href=\""+getURL(key)+"\" xlink:show='replace' xlink:actuate='onRequest'>");
				//http://www.w3.org/TR/2007/REC-xforms-20071029/#structure-attrs-single-node\
				writer.println(getHumanName(key));
				writer.println("</loc></label><def><p>");
				//The following attributes define a binding between an element and an instance data node defined.
				writer.println("</p></def></gitem></glist>");
				Iterator iterator = attributesList.iterator();
				while (iterator.hasNext()) {
					String attname = (String) iterator.next();
					alreadyIncludedAttributes.add(getAttributePrefixAndName(attname, targetPrefix));
				}
				
			}			
		}
		for (int i = 0; i < attributes.length; i++) {
			try {
				XSAttribute attribute = (XSAttribute) attributes[i];
				String attName = getElementName(attribute.getName(),targetPrefix);

				if (!alreadyIncludedAttributes.contains(getAttributePrefixAndName(attName, targetPrefix))){
					writer.println("<glist role=\"attrDef\"><gitem>");
					writer.print("<label>");
					writer.print(getElementName(attribute.getName(),targetPrefix));
					writer.print(" = ");

					if (attribute.getType().getName() != null) {
						String typeName = attribute.getType().getName()
								.getLocalName();
						boolean isAnyURIList = "anyURIList".equals(typeName);
						if (isAnyURIList)
							typeName = "anyURI";
						String loc = getURL(typeName);
						if (isAnyURIList)
							writer.print(" List of ");
						writeLocation(writer, loc, typeName);
					} else if (attribute.getType().getSimpleType() instanceof XSAtomicType) {
						XSSimpleType simple = attribute.getType()
								.getSimpleType();
						String typeName = simple.getRestrictedType().getName()
								.getLocalName();
						String loc = getURL(typeName);
						writeLocation(writer, loc, typeName);
						XSEnumeration[] enumerations = simple.getEnumerations();
						boolean enumeration = enumerations.length > 0;
						if (enumeration)
							writer.print("( ");
						for (int j = 0; j < enumerations.length; j++) {
							String value = enumerations[j].getValue();
							if ("&".equals(value))
								value = "&amp;";
							writer.print(value);
							if (j < enumerations.length - 1)
								writer.print(" | ");
						}
						if (enumeration)
							writer.println(" )");
					} else if (attribute.getType().getSimpleType() instanceof XSListType) {
						if ("includenamespaceprefixes".equals(attribute
								.getName().getLocalName())) {
							String typeName = "NMTOKENS";
							String loc = getURL(typeName);
							writeLocation(writer, loc, typeName);
						} else {
							XSSimpleType simple = attribute.getType()
									.getSimpleType();
							writer.print("List of ");
							String typeName = simple.getListType()
									.getItemType().getName().getLocalName();
							String loc = getURL(typeName);
							writeLocation(writer, loc, typeName);
						}
					} else if (attribute.getType().getSimpleType() instanceof XSUnionType) {
						XSSimpleType simple = attribute.getType()
								.getSimpleType();
						XSUnionType union = simple.getUnionType();
						writer.print(" ( ");
						XSType[] types = union.getMemberTypes();
						for (int j = 0; j < types.length; j++) {
							XSType xstype = types[j];
							if (xstype.getName() != null) {
								String typeName = xstype.getName()
										.getLocalName();
								String loc = getURL(typeName);
								writeLocation(writer, loc, typeName);
							} else if (xstype.getSimpleType()
									.getRestrictedType().getName() != null) {
								XSEnumeration[] enumerations = xstype
										.getSimpleType().getEnumerations();
								for (int z = 0; z < enumerations.length; z++) {
									writer
											.print("\""
													+ enumerations[z]
															.getValue() + "\"");
									if (z < enumerations.length - 1)
										writer.print(" | ");
								}
							}
							if (j < types.length - 1)
								writer.print(" | ");
						}
						writer.print(" )");

					} else {
						writer.print("UNKNOWN");
					}

					writer.println("</label>");
					writer.println("<def><p>");

					try {
						XSAttribute attr = schema.getAttribute(attribute
								.getName());
						if (attr == null)
							attr = attribute;
						
						String doc = getSpecialAttributeDocumentation(element.getName().getLocalName(),attr.getName().getLocalName());
						if (doc != null){
							writer.println(doc);
						}
						else
						{
						XSAnnotation[] annotations = attr.getAnnotations();
							for (int j = 0; j < annotations.length; j++) {
								XSDocumentation[] docs = annotations[j]
										.getDocumentations();
								for (int k = 0; k < docs.length; k++) {
									if (docs[k].getSource() != null) {
										XsAnyURI uri = docs[k].getSource();
										writer.println("See <loc href=\"");
										writer.println(uri.getURI());
										writer.println("\"");									
										writer.println(" xlink:show=\"replace\"");
										writer.println(" xlink:actuate=\"onRequest\"");
										writer.println(">");	
										writer.println(uri.getURI());									
										writer.println("</loc>");
									} else {
										writer.println(docs[k].getText().trim());
									}
								}
							}
					}
					} catch (NullPointerException e) {
						System.out.println(attribute.getName()
								+ " attribute has not associated annotations.");
					}

					writer.println("</p></def>");
					writer.println("</gitem></glist>");
					
					alreadyIncludedAttributes.add(getAttributePrefixAndName(getElementName(attribute.getName(),targetPrefix), targetPrefix));					
				}
			} catch (ClassCastException e) {
			}
		}
	}

	public static String getSpecialAttributeDocumentation(String element, String attribute) {
		return attributesDocumentation.getProperty(element+"_"+attribute);
	}
	
	public static String getElementName(XsQName name, String targetPrefix) {
		return getElementName(name, targetPrefix, ":");
	}
	
	public static String getElementNameForID(XsQName name,  String targetPrefix) {
		return getElementName(name, targetPrefix, "_");
	}	
	
	public static String getElementName(XsQName name, String targetPrefix, String separator) {

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
	
	private static Node getChildByName(Node n, String name) {
		 NodeList nl = n.getChildNodes();
		 for (int i = 0; i < nl.getLength(); i++) {
		 Node t = nl.item(i);
		 if (t.getNodeName().equals(name))
		  return t;
		 }
		 return null;
		}	

	private static boolean elementNeedsDefinition(XSElement element) {
		String name = getElementName(element.getName(),targetPrefix);
		String namespaceURI = element.getName().getNamespaceURI();
		if (elementsExcluded.containsKey(name)){
			return false;
		}

		if (namespaceURI != null){
			if (namespacesExcluded.containsKey(namespaceURI)){
				return false;
			}
		}
		
		return true;		
	}
	
	private static String getAttributePrefixAndName(String attributeName, String targetPrefix) {
		if (!attributeName.contains(":")){
			attributeName = targetPrefix + ":" + attributeName;
		}
		return attributeName;		
	}	
	
	// FROM ModuleTablesGenerator
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
				//namespacesDocUris.put(uri, docuri);
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
}
