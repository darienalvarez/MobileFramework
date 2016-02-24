package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Connector implements Serializable
{
	private static final long serialVersionUID = 5967831125427953637L;

	@Id
	@SequenceGenerator(name="CONNECTOR_IDCONNECTOR_GENERATOR", sequenceName="CONNECTOR_ID_CONNECTOR_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTOR_IDCONNECTOR_GENERATOR")
	@Column(name="id_connector")
	private Long idConnector;

	@OneToMany(cascade={javax.persistence.CascadeType.ALL}, mappedBy="connector")
	private List<Datasource> datasources;

	@OneToMany(mappedBy="connector", cascade={javax.persistence.CascadeType.ALL})
	protected List<ConnectorDefinition> definitions;

	@OneToOne(cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_connector_type")
	private ConnectorType connectorType;

	public Connector()
	{
		this.datasources = new ArrayList<Datasource>();
		this.definitions = new ArrayList<ConnectorDefinition>();
	}

	public void addDefinition(ConnectorDefinition definition) {
		if (definition != null) {
			definition.setConnector(this);
			this.definitions.add(definition);
		}
	}

	public Long getIdConnector() {
		return this.idConnector;
	}

	public void setIdConnector(Long idConnector) {
		this.idConnector = idConnector;
	}
	@XmlTransient
	public List<Datasource> getDatasources() {
		return this.datasources;
	}

	public void setDatasources(List<Datasource> datasources) {
		this.datasources = datasources;
	}

	public ConnectorType getConnectorType() {
		return this.connectorType;
	}

	public void setConnectorType(ConnectorType connectorType) {
		this.connectorType = connectorType;
	}

	public List<ConnectorDefinition> getDefinitions() {
		return this.definitions;
	}

	public void setDefinitions(List<ConnectorDefinition> definitions) {
		this.definitions = definitions;
	}
}