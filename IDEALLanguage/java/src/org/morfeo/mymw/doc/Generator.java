package org.morfeo.mymw.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Generator {

	private static List commonAttributes = new ArrayList();

	private static List elementsWithoutCommonAttributes = new ArrayList();

	private static List embeddingAttributes = new ArrayList();

	private static List hypertextAttributes = new ArrayList();

	private static List repeatAttributes = new ArrayList();

	private static List eventsAttributes = new ArrayList();

	private static List singleNodeBindingAttributes = new ArrayList();

	private static List nodeSetBindingAttributes = new ArrayList();
	
	private static List modelItemPropertyAttributes = new ArrayList();
	
	private static List extContentModel = new ArrayList();

	private static Properties URLs = new Properties();

	private static boolean isDIAL = false;

	private static Properties groupNames = new Properties();

	private static Properties contentModels = new Properties();

	static {
		commonAttributes.add("xml:space");
		commonAttributes.add("xml:id");
		commonAttributes.add("xml:lang");
		commonAttributes.add("class");
		commonAttributes.add("title");
		commonAttributes.add("role");
		commonAttributes.add("sel:expr");

		embeddingAttributes.add("src");
		embeddingAttributes.add("srctype");
		embeddingAttributes.add("encoding");

		hypertextAttributes.add("href");
		hypertextAttributes.add("hreftype");
		hypertextAttributes.add("hrefmedia");
		hypertextAttributes.add("hreflang");
		hypertextAttributes.add("nextfocus");
		hypertextAttributes.add("prevfocus");

		repeatAttributes.add("xforms:repeat-nodeset");
		repeatAttributes.add("xforms:repeat-number");
		repeatAttributes.add("xforms:repeat-model");
		repeatAttributes.add("xforms:repeat-bind");
		repeatAttributes.add("xforms:repeat-startindex");

		eventsAttributes.add("ev:defaultAction");
		eventsAttributes.add("ev:event");
		eventsAttributes.add("ev:handler");
		eventsAttributes.add("ev:observer");
		eventsAttributes.add("ev:phase");
		eventsAttributes.add("ev:propagate");
		eventsAttributes.add("ev:target");
		eventsAttributes.add("if");
		eventsAttributes.add("targetid");
		eventsAttributes.add("targetrole");

		singleNodeBindingAttributes.add("xforms:bind");
		singleNodeBindingAttributes.add("xforms:model");
		singleNodeBindingAttributes.add("xforms:ref");

		nodeSetBindingAttributes.add("xforms:bind");
		nodeSetBindingAttributes.add("xforms:model");
		nodeSetBindingAttributes.add("xforms:nodeset");
		
		 modelItemPropertyAttributes.add("xforms:type");
		 modelItemPropertyAttributes.add("xforms:readonly");
		 modelItemPropertyAttributes.add("xforms:required");
		 modelItemPropertyAttributes.add("xforms:relevant");
		 modelItemPropertyAttributes.add("xforms:calculate");
		 modelItemPropertyAttributes.add("xforms:constraint");
		 modelItemPropertyAttributes.add("xforms:p3ptype");
	}

	private static String getURL(String type) {
		return URLs.getProperty(type);
	}

	private static String getHumanName(XSGroup group) {
		String ret = null;

		if (group != null && group.getName() != null)
			ret = groupNames.getProperty(group.getName().getLocalName());

		if (ret != null)
			ret = ret.trim();

		return ret;
	}

	/**
	 * Read properties file.
	 * 
	 * @throws Throwable
	 */
	private static void loadProperties() throws Throwable {

		try {
			// Read properties file.
			String path = System.getProperty("user.dir");
			URLs.load(new FileInputStream(path
					+ "/java/resources/uri.properties"));
			groupNames.load(new FileInputStream(path
					+ "/java/resources/group.name.properties"));
			Properties tmp = new Properties();
			tmp.load(new FileInputStream(path
					+ "/java/resources/redefinition.properties"));
			String elementsList = tmp.getProperty("ContentModel");
			String[] elements = elementsList.split(",");
			for (int i = 0; i < elements.length; i++) {
				extContentModel.add(elements[i].trim());
			}
			contentModels.load(new FileInputStream(path
					+ "/java/resources/content.model.properties"));

			tmp = new Properties();
			tmp.load(new FileInputStream(path
					+ "/java/resources/common.attributes.properties"));
			elementsList = tmp.getProperty("Elements");
			elements = elementsList.split(",");
			for (int i = 0; i < elements.length; i++) {
				elementsWithoutCommonAttributes.add(elements[i].trim());
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
			System.out
					.println("* First argument is document type -DIAL or -IDEAL");
			System.out.println("* Second argument is the XML Schema file");
			System.out.println("* Thrid argument is the path to XML spec file");
		} else {
			try {
				loadProperties();
				isDIAL = "-DIAL".equals(args[0]);
				File input = new File(args[1]);
				File out = new File(args[2]);
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

		for (int i = 0; i < elements.length; i++) {
			if (!definedElements.contains(elements[i].getName())) {
				String namespace = elements[i].getName().getNamespaceURI();
				if (("http://www.morfeo-project.org/2008/dial"
						.equals(namespace))
						|| ("http://www.morfeo-project.org/2008/ideal"
								.equals(elements[i].getName().getNamespaceURI()) )) {

					writer.print("<div2 id=\"");
					writer.print(elements[i].getName().getLocalName());
					writer.println("-element\">");
					writer.print("<head>The <code>&lt;");
					writer.print(elements[i].getName().getLocalName());
					writer.println("&gt;</code> element</head>");
					addContentModelSection(elements[i], writer);
					addAttributesSection(schema, elements[i], writer);
					writer.println("</div2>");
				} else if (("http://www.w3.org/2002/xforms".equals(namespace))
						|| ("http://www.w3.org/2001/xml-events"
								.equals(namespace))
						|| ("http://www.w3.org/2004/06/diselect"
								.equals(namespace))) {
					writer.print("<div2 id=\"");
					writer.print(getElementNameForID(elements[i].getName()));
					writer.println("-element\">");
					writer.print("<head>The <code>&lt;");
					writer.print(getElementName(elements[i].getName()));
					writer.println("&gt;</code>");
					writer.println(" element</head>");
					writer
							.println("<p>This element has been extended by IDEAL.</p>");
					// Add Common Attributes
					addAttributesSection(schema, elements[i], writer);

					if (contentModelRedefined(elements[i])) {
						addContentModelSection(elements[i], writer);
					}

					addExternalElementReference(elements[i], writer);

					writer.println("</div2>");
				}

				definedElements.add(elements[i].getName());
			}

		}

		writer.println("</div1>");
		writer.close();

	}

	private static boolean contentModelRedefined(XSElement element) {
		return extContentModel.contains(getElementName(element.getName()));
	}

	private static boolean isNextXSParticlePrinted(XSParticle particle) {

		boolean ret = false;

		if (particle.isElement()) {
			ret = true;
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

	private static boolean addContentModelGroup(XSGroup group,
			StringBuffer buffer, int minOccurs, int maxOccurs,
			boolean openParentheses) {

		boolean ret = false;

		XSParticle[] particles = group.getParticles();
		int size = particles.length;

		if (openParentheses && size > 1)
			buffer.append("( ");

		boolean previousPrinted = false;
		for (int i = 0; i < size; i++) {
			XSParticle particle = particles[i];

			if (previousPrinted && isNextXSParticlePrinted(particle)) {
				if (group.isSequence())
					buffer.append(" , ");
				else if (group.isChoice())
					buffer.append(" | ");
			}

			if (particle.isElement()) {
				ret = previousPrinted = true;
				String name = getElementNameForID(particle.getElement().getName());
				String url = "#" + name + "-element";
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

		if (!openParentheses || (ret && size > 1))
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

		writer.println("<p id=\"" + element.getName().getLocalName()
				+ "-content-model\">");
		if (element.getType().getAnnotations().length > 0) {
			if (element.getType().getAnnotations()[0].getDocumentations().length > 0) {
				writer.println(escapeString2XML(element.getType()
						.getAnnotations()[0].getDocumentations()[0].getText()));
			}
		}
		writer.println("</p><p><emph>Content Model</emph></p>");

		writer.println("<glist role=\"contentDef\">");
		XSComplexType type = element.getType().getComplexType();

		writer.println("<gitem><label><code>");

		String contentModel = getContentModel(element.getName().getLocalName());
		if (contentModel != null) {
			writer.println(contentModel);
		} else {

			if (type.isExtension()) {
				XSType ext = type.getExtendedType();
				if ("string".equals(ext.getName().getLocalName())) {
					writer.println("( PCDATA )*");
				} else {
					writer.println("Extension of " + ext.getName());
				}
			} else {
				XSParticle particle = type.getParticle();
				if (particle.getGroup().getParticles().length == 0) {
					writer.print(" EMPTY ");
				} else if (type.isMixed()) {
					writer.print("( PCDATA | ");
					StringBuffer tmp = new StringBuffer();
					addContentModelGroup(particle.getGroup(), tmp, -2, -2,
							false);
					writer.println(tmp.toString());
					writer.print("*");
				} else {
					StringBuffer tmp = new StringBuffer();
					addContentModelGroup(particle.getGroup(), tmp, -2, -2, true);
					writer.println(tmp.toString());
				}
			}
		}

		writer.println("</code></label><def></def></gitem></glist>");

	}

	private static void addExternalElementReference(XSElement element,
			PrintWriter writer) throws SAXException {

		String url = getURL(getElementName(element.getName()));
		writer.println("<p id=\"" + getElementNameForID(element.getName())
				+ "-content-model\">");
		writer.print("View definition of this element is on " + "<loc href='"
				+ url + "'  xlink:show='replace' xlink:actuate='onRequest'>" + element.getName().getLocalName() + "</loc></p>");

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
		for (int i = 0; i < all.length; i++) {
			try {
				XSAttribute attr = (XSAttribute) all[i];
				if (attributes.contains(getElementName(attr.getName())))
					cont++;
			} catch (ClassCastException e) {
			}
		}

		return cont == attributes.size();
	}

	private static void addAttributesSection(XSSchema schema,
			XSElement element, PrintWriter writer) throws SAXException {

		String elementLocalName = element.getName().getLocalName();
		writer.println("<p id=\"" + getElementNameForID(element.getName())
				+ "-attributes\"><emph>Attributes</emph></p>");
		XSComplexType type = element.getType().getComplexType();

		if (!elementsWithoutCommonAttributes.contains(elementLocalName))
			writer
					.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#common-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Common</loc> collection</label><def><p>Collection of common attributes.</p></def></gitem></glist>");

		boolean includedEmbeddingAttributes = false;
		boolean includedHypertextAttributes = false;
		boolean includedRepeatAttributes = false;
		boolean includedEventsAttributes = false;
		boolean includedBindingAttributes = false;
		boolean includedModelItemPropertyAttributes = false;
		XSAttributable[] attributes = type.getAttributes();
		Arrays.sort(attributes, new XSAttributeComparator());

		// All Single Node Binding attributes
		if (hasAllAttributes(attributes, singleNodeBindingAttributes)) {
			writer
					.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"http://www.w3.org/TR/2007/REC-xforms-20071029/#structure-attrs-single-node\" xlink:show='replace' xlink:actuate='onRequest'>Single-Node Binding Attributes</loc></label><def><p>The following attributes define a binding between an element and an instance data node defined.</p></def></gitem></glist>");
			includedBindingAttributes = true;
		}

		// All Node-Set Binding attributes
		if (hasAllAttributes(attributes, nodeSetBindingAttributes)) {
			writer
					.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"http://www.w3.org/TR/2007/REC-xforms-20071029/#structure-attrs-nodeset\" xlink:show='replace' xlink:actuate='onRequest'>Node-Set Binding Attributes</loc></label><def><p>The following attributes define a binding between an element and a node-set defined.</p></def></gitem></glist>");
			includedBindingAttributes = true;
		}
		
		if (hasAllAttributes(attributes, modelItemPropertyAttributes)) {
			writer
					.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"http://www.w3.org/TR/2007/REC-xforms-20071029/#structure-attrs-mip\" xlink:show='replace' xlink:actuate='onRequest'>Model Item Property Attributes</loc></label><def><p>This collection contains one attribute for each model item property, with an attribute name exactly matching the name of the model item property, as defined in <loc href='http://www.w3.org/TR/2007/REC-xforms-20071029/#model-xformsconstraints' xlink:show='replace' xlink:actuate='onRequest'>6.1 Model Item Property Definitions.</loc></p></def></gitem></glist>");
			includedModelItemPropertyAttributes = true;
		}		

		for (int i = 0; i < attributes.length; i++) {
			try {
				XSAttribute attribute = (XSAttribute) attributes[i];
				String localName = attribute.getName().getLocalName();
				String qName = getElementName(attribute.getName());
				if (embeddingAttributes.contains(localName)) {
					if (!includedEmbeddingAttributes) {
						writer
								.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#embedding-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Embedding</loc> collection</label><def><p>Collection of embedding attributes.</p></def></gitem></glist>");
						includedEmbeddingAttributes = true;
					}
				} else if (hypertextAttributes.contains(localName)) {
					if (!includedHypertextAttributes) {
						writer
								.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#hypertext-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Hypertext</loc> collection</label><def><p>Collection of hypertext attributes. This collection allows an element to be the start point of a hypertext link to a remote resource.</p></def></gitem></glist>");
						includedHypertextAttributes = true;
					}
				} else if (repeatAttributes.contains(qName)) {
					if (!includedRepeatAttributes) {
						writer
								.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#repeat-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Repeat</loc> collection</label><def><p>Collection of repeat attributes. This collection enables the creation of user interfaces for populating repeating structures.</p></def></gitem></glist>");
						includedRepeatAttributes = true;
					}
				} else if (eventsAttributes.contains(qName)) {
					if (!includedEventsAttributes) {
						writer
								.println("<glist role=\"attrDef\"><gitem><label>The <loc href=\"#events-attributes\" xlink:show='replace' xlink:actuate='onRequest'>Events</loc> collection</label><def><p>Collection of events attributes. This collection makes possible to uniformly integrate event listeners.</p></def></gitem></glist>");
						includedEventsAttributes = true;
					}
				} else if ((singleNodeBindingAttributes.contains(qName) || nodeSetBindingAttributes
						.contains(qName))
						&& includedBindingAttributes) {
					// NOOP
				} else if ((modelItemPropertyAttributes.contains(qName))
						&& includedModelItemPropertyAttributes) {
					// NOOP					
				} else if (!commonAttributes.contains(qName)
						|| (elementsWithoutCommonAttributes
								.contains(elementLocalName))) {
					writer.println("<glist role=\"attrDef\"><gitem>");
					writer.print("<label>");
					writer.print(getElementName(attribute.getName()));
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
					} catch (NullPointerException e) {
						System.out.println(attribute.getName()
								+ " attribute has not associated annotations.");
					}

					writer.println("</p></def>");
					writer.println("</gitem></glist>");
				}
			} catch (ClassCastException e) {
			}
		}

	}

	public static String getElementName(XsQName name) {
		return getElementName(name, ":");
	}
	
	public static String getElementNameForID(XsQName name) {
		return getElementName(name, "_");
	}	
	
	public static String getElementName(XsQName name, String separator) {

		String localName = name.getLocalName();

		String prefix = name.getPrefix();

		if (prefix != null && prefix.length() > 0 && !"dial".equals(prefix)
				&& !"ideal".equals(prefix)) {
			prefix = name.getPrefix() + separator;
		} else {
			prefix = "";
		}

		return prefix + localName;
	}

	private static String getContentModel(String element) {

		String ret = null;

		if (!isDIAL) {
			ret = contentModels.getProperty(element);
		}

		return ret;

	}
}
