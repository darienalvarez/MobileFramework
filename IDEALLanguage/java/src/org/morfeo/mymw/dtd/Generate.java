package org.morfeo.mymw.dtd;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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

public class Generate {

	private static Map URIS = new HashMap();

	static {
		URIS
				.put("CDATA",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_CDATA");
		URIS
				.put("ID",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_ID");
		URIS
				.put("IDREF",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_IDREF");
		URIS
				.put("IDREFS",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_IDREFS");
		URIS
				.put("NAME",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_NAME");
		URIS
				.put("NMTOKEN",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_NMTOKEN");
		URIS
				.put("NMTOKENS",
						"http://www.w3.org/TR/xhtml-modularization/abstraction.html#dt_NMTOKENS");
	}

	private static List commonAttributes = new ArrayList();

	static {
		commonAttributes.add("class");
		commonAttributes.add("dir");
		commonAttributes.add("id");
		commonAttributes.add("expr");
		commonAttributes.add("title");
		commonAttributes.add("xml:lang");
		commonAttributes.add("xml:space");
		commonAttributes.add("xmlns:xhtml");
		commonAttributes.add("role");
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out.println("* First argument is the DTD file.");
			System.out.println("* Second argument is the path to W3C file.");
		} else {
			File input = new File(args[0]);
			File out = new File(args[1]);
			export(input, out);
			System.out.println("DTD was exported to W3C format successfully.");
		}
	}

	private static boolean writeElement(DTDElement element) {

		boolean ret = true;

		String name = element.getName();

		if ("noscript".equals(name) || name.startsWith("xs:"))
			ret = false;

		return ret;
	}

	private static void writeDTDAsW3C(DTD file, PrintWriter writer) {
		Vector res = file.getItemsByType(DTDElement.class);

		java.util.Collections.sort(res, new DTDElementComparator());

		for (Iterator iterator = res.iterator(); iterator.hasNext();) {
			DTDElement ele = (DTDElement) iterator.next();

			if (writeElement(ele)) {
				writer.println("<div2 id=\"" + ele.getName() + "-element\">");
				writer.println("<head>&lt;" + ele.getName() + "&gt;</head>");

				writer
						.println("  <table border='1' cellpadding='3' width='100%'>");
				writer.println("    <thead><tr>"
						+ "<th colspan=\"3\">Content Model</th>");
				writer.println("</tr></thead>");
				writer.println("    <tbody>");
				StringBuffer content = new StringBuffer();
				getContent(ele.getContent(), content, ele.getClass(), false);
				writer.println("      <tr  valign='top'><td colspan=\"3\">"
						+ content.toString() + "</td></tr>");
				writer.println("        </tbody></table>");

				Hashtable attrs = ele.attributes;

				writer
						.println("  <table border='1' cellpadding='3' width='100%'>");
				writer
						.println("    <thead><tr>"
								+ "<th colspan=\"3\">Attributes</th>"
								+ "</tr><tr>"
								+ "<th><loc href='#def-attr-name'>Name</loc></th>"
								+ "<th><loc href='#def-attr-type'>Type</loc></th>"
								+ "<th><loc href='#def-attr-default'>Default value</loc></th>");
				writer.println("</tr></thead>");
				writer.println("    <tbody>");

				if (attrs.size() == 0) {
					writer
							.println("      <tr  valign='top'><td colspan=\"3\"></td></tr>");
				} else {
					List list = new ArrayList(attrs.keySet());

					Collections.sort(list);

					boolean hasCommon = hasAllCommonAttr(ele);

					if (hasCommon) {
						writer
								.println("      <tr  valign='middle'><td colspan='3'>");
						writer
								.print("<loc href=\"#common-attributes\">Common</loc>");
						writer.println("      </td></tr>");
					}

					for (Iterator iterator2 = list.iterator(); iterator2
							.hasNext();) {
						String name = (String) iterator2.next();

						if (!(hasCommon && commonAttributes.contains(name))) {
							DTDAttribute attr = (DTDAttribute) attrs.get(name);
							Object objType = attr.getType();
							writer.println("      <tr  valign='middle'>");
							if (objType.getClass() == DTDEnumeration.class) {
								writer.println("        <td>" + attr.getName()
										+ "</td>");
								DTDEnumeration enumeration = (DTDEnumeration) objType;
								String[] values = enumeration.getItem();
								writer.print("        <td><table><tbody>");
								if (values.length != 0) {
									for (int i = 0; i < values.length; i++) {
										writer.print("<tr><td>" + values[i]
												+ "</td></tr>");
									}
								} else {
									writer.print("<tr><td></td></tr>");
								}
								writer.println("        </tbody></table></td>");
							} else {
								writer.println("        <td>" + attr.getName()
										+ "</td>");
								String type = objType.toString();
								String uri = (String) URIS.get(type);
								writer.print("        <td>");
								if (uri != null) {
									writer.print("<loc href=\"" + uri + "\">"
											+ type + "</loc>");
								} else {
									writer.print("type");
								}
								writer.println("</td>");
							}
							String defaultValue = attr.getDefaultValue();
							if (defaultValue != null
									&& defaultValue.length() > 0) {
								writer.println("        <td>" + defaultValue
										+ "</td>");
							} else {
								writer.println("        <td>Not defined</td>");
							}
							writer.println("      </tr>");
						}
					}
				}

				writer.println("        </tbody></table>");
				writer.println("        </div2>");
			}
		}
	}

	private static void getContent(DTDItem element, StringBuffer buffer,
			Class parent, boolean notLastTag) {

		if (element instanceof DTDPCData) {
			buffer.append("PCDATA");
			if (notLastTag) {
				if (parent == DTDChoice.class || parent == DTDMixed.class) {
					buffer.append(" | ");
				} else if (parent == DTDSequence.class) {
					buffer.append(" , ");
				}
			}
		} else if (element instanceof DTDEmpty) {
			buffer.append("EMPTY");
		} else if (element instanceof DTDName) {
			String elementName = ((DTDName) element).getValue().toString();
			if ("xs:schema".equals(elementName)) {
				buffer
						.append("<loc href='http://www.w3.org/TR/xmlschema-0/'>xs:schema</loc>");
			} else {
				buffer.append("<loc href='#").append(elementName).append(
						"-element'>").append(elementName).append("</loc>");
			}
			// buffer.append(elementName);
			DTDCardinal cardinal = element.getCardinal();
			if (cardinal.type == 1) {
				buffer.append("?");
			} else if (cardinal.type == 2) {
				buffer.append("*");
			} else if (cardinal.type == 3) {
				buffer.append("+");
			}
			if (notLastTag) {
				if (parent == DTDChoice.class || parent == DTDMixed.class) {
					buffer.append(" | ");
				} else if (parent == DTDSequence.class) {
					buffer.append(" , ");
				}
			}
		} else if (element instanceof DTDContainer) {
			DTDItem[] items = ((DTDContainer) element).getItems();

			boolean put = items.length > 1
					|| (items.length > 0 && items[0] instanceof DTDContainer);

			if (put)
				buffer.append("(");

			for (int i = 0; i < items.length; i++) {
				getContent((items[i]), buffer, element.getClass(),
						i < items.length - 1);
			}

			if (put)
				buffer.append(")");

			DTDCardinal cardinal = element.getCardinal();
			if (cardinal.type == 1) {
				buffer.append("?");
			} else if (cardinal.type == 2) {
				buffer.append("*");
			} else if (cardinal.type == 3) {
				buffer.append("+");
			}

			if (notLastTag) {
				if (parent == DTDChoice.class || parent == DTDMixed.class) {
					buffer.append(" | ");
				} else if (parent == DTDSequence.class) {
					buffer.append(" , ");
				}
			}

		}
	}

	private static void export(File input, File out) throws IOException {
		DTDParser parser = new DTDParser(input);
		DTD dial = parser.parse();
		try {
			PrintWriter writer = new PrintWriter(out, "utf8");
			writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			writer.println("<div1 id=\"elements\">");
			writer.println("<head> Elements </head>");
			writeDTDAsW3C(dial, writer);
			writer.println("</div1>");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean hasAllCommonAttr(DTDElement element) {

		boolean ret = true;

		for (Iterator iterator = commonAttributes.iterator(); iterator
				.hasNext();) {
			String name = (String) iterator.next();
			DTDAttribute aux = element.getAttribute(name);
			if (aux == null) {
				ret = false;
				break;
			}

		}

		return ret;
	}
}
