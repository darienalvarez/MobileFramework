<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
	elementFormDefault="qualified"
	xmlns="http://www.morfeo-project.org/2008/dial"
	targetNamespace="http://www.morfeo-project.org/2008/dial">

	<xs:include schemaLocation="dial-attribs-1.xsd" />

	<xs:annotation>
		<xs:documentation>
			This is the XML Schema Object module for DIAL
		</xs:documentation>
	</xs:annotation>
	<xs:annotation>
		<xs:documentation>
			This module declares the object element type and its
			attributes, used to embed external objects as part of DIAL
			pages. In the document, place param elements prior to the
			object elements that require their content.

			Note that use of this module requires instantiation of the
			Param Element Module prior to this module.

			Elements defined here:

			* object (param)
		</xs:documentation>
	</xs:annotation>

	<xs:include schemaLocation="dial-param-1.xsd">
		<xs:annotation>
			<xs:documentation>
				Param module

				Elements defined here: * param
			</xs:documentation>
		</xs:annotation>
	</xs:include>

	<xs:attributeGroup name="dial.object.attlist">
		<xs:attributeGroup ref="dial.Common.attrib" />
		<xs:attribute ref="declare"/>
		<xs:attribute ref="encoding" />
		<xs:attribute ref="nextfocus" />
		<xs:attribute ref="prevfocus" />
		<xs:attribute ref="src" />
		<xs:attribute ref="srctype" />
		<xs:attributeGroup ref="object.extra.attributes" />
	</xs:attributeGroup>

	<xs:group name="dial.object.content">
		<xs:sequence>
			<xs:choice minOccurs="0" maxOccurs="unbounded">
				<xs:element ref="param"/>
			</xs:choice>
		</xs:sequence>
	</xs:group>

	<xs:complexType name="dial.object.type">
		<xs:annotation>
			<xs:documentation>
				Object indicates a non-text item for inclusion in the
				document; this includes images and other media, as well
				as executable content which require plugins or external
				applications to process.

				Note this is the way images are referenced in this language,
				rather than through the legacy img/@src
			</xs:documentation>
		</xs:annotation>
		<xs:group ref="dial.object.content" />
		<xs:attributeGroup ref="dial.object.attlist" />
	</xs:complexType>
	<xs:element name="object" type="dial.object.type"/>
</xs:schema>
