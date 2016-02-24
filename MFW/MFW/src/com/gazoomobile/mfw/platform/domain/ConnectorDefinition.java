package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="connector_configuration")
public class ConnectorDefinition
  implements Serializable
{
  private static final long serialVersionUID = -8080160805329333049L;

  @Id
  @SequenceGenerator(name="CONNECTOR_DEFINITION_ID_GENERATOR", sequenceName="connector_configuration_id_connector_configuration_seq", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTOR_DEFINITION_ID_GENERATOR")
  @Column(name="id_connector_configuration")
  private Long id;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_connector_property")
  private ConnectorProperty property;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_connector")
  private Connector connector;
  private String value;

  public Long getId()
  {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ConnectorProperty getProperty() {
    return this.property;
  }

  public void setProperty(ConnectorProperty property) {
    this.property = property;
  }
  @XmlTransient
  public Connector getConnector() {
    return this.connector;
  }

  public void setConnector(Connector connector) {
    this.connector = connector;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}