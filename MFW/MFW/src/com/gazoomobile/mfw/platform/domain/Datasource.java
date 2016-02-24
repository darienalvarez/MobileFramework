package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Datasource
  implements Serializable
{
  private static final long serialVersionUID = -4236238444970379969L;

  @Id
  @SequenceGenerator(name="DATASOURCE_IDDATASOURCE_GENERATOR", sequenceName="DATASOURCE_ID_DATASOURCE_SEQ", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DATASOURCE_IDDATASOURCE_GENERATOR")
  @Column(name="id_datasource")
  private Long idDatasource;
  private String name;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_screen")
  private Screen screen;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_connector")
  private Connector connector;

  @Transient
  private List<String> outputFields;

  public Long getIdDatasource()
  {
    return this.idDatasource;
  }

  public void setIdDatasource(Long idDatasource) {
    this.idDatasource = idDatasource;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
  @XmlTransient
  public Screen getScreen() {
    return this.screen;
  }

  public void setScreen(Screen screen) {
    this.screen = screen;
  }

  public Connector getConnector() {
    return this.connector;
  }

  public void setConnector(Connector connector) {
    this.connector = connector;
  }

  public List<String> getOutputFields() {
    return this.outputFields;
  }

  public void setOutputFields(List<String> outputFields) {
    this.outputFields = outputFields;
  }
}