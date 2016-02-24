package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="control_property")
public class ControlProperty
implements Serializable
{
	private static final long serialVersionUID = -7933469289714295727L;

	@Id
	@SequenceGenerator(name="CONTROL_PROPERTY_IDPROPERTY_GENERATOR", sequenceName="CONTROL_PROPERTY_ID_PROPERTY_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTROL_PROPERTY_IDPROPERTY_GENERATOR")
	@Column(name="id_property")
	private Long idProperty;
	private String name;
	private String description;

	@OneToMany(mappedBy="controlProperty", cascade={javax.persistence.CascadeType.ALL})
	private List<ControlDefinition> controlDefinitions;

	@ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_property_type")
	private PropertyType propertyType;

	@ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_control_type")
	private ControlType controlType;

	public ControlProperty()
	{
		this.controlDefinitions = new ArrayList<ControlDefinition>();
	}

	public Long getIdProperty() {
		return this.idProperty;
	}

	public void setIdProperty(Long idProperty) {
		this.idProperty = idProperty;
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
	@XmlTransient
	public List<ControlDefinition> getControlDefinitions() {
		return this.controlDefinitions;
	}

	public void setControlDefinitions(List<ControlDefinition> controlDefinitions) {
		this.controlDefinitions = controlDefinitions;
	}

	public PropertyType getPropertyType() {
		return this.propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	@XmlTransient
	public ControlType getControlType() {
		return this.controlType;
	}

	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}
}