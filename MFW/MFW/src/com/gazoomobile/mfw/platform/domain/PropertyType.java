package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="property_type")
public class PropertyType
implements Serializable
{
	private static final long serialVersionUID = -6095880520814053716L;

	@Id
	@SequenceGenerator(name="PROPERTY_TYPE_IDPROPERTYTYPE_GENERATOR", sequenceName="PROPERTY_TYPE_ID_PROPERTY_TYPE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROPERTY_TYPE_IDPROPERTYTYPE_GENERATOR")
	@Column(name="id_property_type")
	private Long idPropertyType;
	private String type;

	@OneToMany(mappedBy="propertyType", cascade={javax.persistence.CascadeType.ALL})
	private List<ControlProperty> controlProperties;

	public PropertyType()
	{
		this.controlProperties = new ArrayList<ControlProperty>();
	}

	public Long getIdPropertyType() {
		return this.idPropertyType;
	}

	public void setIdPropertyType(Long idPropertyType) {
		this.idPropertyType = idPropertyType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@XmlTransient
	public List<ControlProperty> getControlProperties() {
		return this.controlProperties;
	}

	public void setControlProperties(List<ControlProperty> controlProperties) {
		this.controlProperties = controlProperties;
	}
}