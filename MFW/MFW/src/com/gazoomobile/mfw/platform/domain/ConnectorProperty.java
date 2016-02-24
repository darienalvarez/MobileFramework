package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="connector_property")
public class ConnectorProperty implements Serializable
{
	private static final long serialVersionUID = 859793728292101022L;

	@Id
	@SequenceGenerator(name="CONNECTOR_PROPERTY_ID_GENERATOR", sequenceName="connector_property_id_connector_property_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTOR_PROPERTY_ID_GENERATOR")
	@Column(name="id_connector_property")
	private Long id;
	private String name;
	private String description;

	@ManyToMany(mappedBy="connectorProperties")
	private List<ConnectorType> types;

	@OneToMany(mappedBy="property", cascade={javax.persistence.CascadeType.ALL})
	private List<ConnectorDefinition> definitions;

	public ConnectorProperty()
	{
		this.types = new ArrayList<ConnectorType>();
		this.definitions = new ArrayList<ConnectorDefinition>();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlTransient
	public List<ConnectorType> getTypes() {
		return this.types;
	}

	public void setTypes(List<ConnectorType> types) {
		this.types = types;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlTransient
	public List<ConnectorDefinition> getDefinitions() {
		return this.definitions;
	}

	public void setDefinitions(List<ConnectorDefinition> definitions) {
		this.definitions = definitions;
	}
}