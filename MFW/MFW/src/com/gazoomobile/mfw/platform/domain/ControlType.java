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
import javax.persistence.Transient;

@Entity
@Table(name="control_type")
public class ControlType
implements Serializable
{
	private static final long serialVersionUID = -7080920643800736909L;

	@Id
	@SequenceGenerator(name="CONTROL_TYPE_IDCONTROL_GENERATOR", sequenceName="control_type_id_control_type_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTROL_TYPE_IDCONTROL_GENERATOR")
	@Column(name="id_control_type")
	private Long id;
	private String type;

	@OneToMany(mappedBy="controlType", cascade={javax.persistence.CascadeType.ALL})
	@Transient
	private List<ControlProperty> controlProperties;

	public ControlType()
	{
		this.controlProperties = new ArrayList<ControlProperty>();
	}

	public void addProperty(ControlProperty property) {
		if (property != null) {
			if (this.controlProperties == null) {
				this.controlProperties = new ArrayList<ControlProperty>();
			}
			property.setControlType(this);

			this.controlProperties.add(property);
		}
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ControlProperty> getControlProperties() {
		return this.controlProperties;
	}

	public void setControlProperties(List<ControlProperty> controlProperties) {
		this.controlProperties = controlProperties;
	}
}