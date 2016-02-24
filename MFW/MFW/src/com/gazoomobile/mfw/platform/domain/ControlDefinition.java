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
@Table(name="control_definition")
public class ControlDefinition
  implements Serializable
{
  private static final long serialVersionUID = 1646845372552112866L;

  @Id
  @SequenceGenerator(name="CONTROL_DEFINITION_ID_GENERATOR", sequenceName="control_definition_id_control_definition_seq", allocationSize=1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTROL_DEFINITION_ID_GENERATOR")
  @Column(name="id_control_definition")
  private Long id;
  
  private String value;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_control")
  private Control control;

  @ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
  @JoinColumn(name="id_property")
  private ControlProperty controlProperty;

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
  @XmlTransient
  public Control getControl() {
    return this.control;
  }

  public void setControl(Control control) {
    this.control = control;
  }

  public ControlProperty getControlProperty() {
    return this.controlProperty;
  }

  public void setControlProperty(ControlProperty controlProperty) {
    this.controlProperty = controlProperty;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}