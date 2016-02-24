package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="connector_type")
public class ConnectorType implements Serializable
{
	private static final long serialVersionUID = 1062396101512050541L;

	@Id
	@SequenceGenerator(name="CONNECTOR_TYPE_IDCONNECTORTYPE_GENERATOR", sequenceName="connector_type_id_connector_type_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTOR_TYPE_IDCONNECTORTYPE_GENERATOR")
	@Column(name="id_connector_type")
	private Long id;
	private String name;
	private String clazz;
	private String description;

	@ManyToMany(cascade={javax.persistence.CascadeType.ALL})
	@JoinTable(name="connector_type_connector_property", joinColumns={@javax.persistence.JoinColumn(name="id_connector_type")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="id_connector_property")})
	private List<ConnectorProperty> connectorProperties;

	public ConnectorType()
	{
		this.connectorProperties = new ArrayList<ConnectorProperty>();
	}

	public void addProperty(ConnectorProperty property) {
		if (property != null)
			this.connectorProperties.add(property);
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClazz() {
		return this.clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public List<ConnectorProperty> getConnectorProperties() {
		return this.connectorProperties;
	}

	public void setConnectorProperties(List<ConnectorProperty> connectorProperties) {
		this.connectorProperties = connectorProperties;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}