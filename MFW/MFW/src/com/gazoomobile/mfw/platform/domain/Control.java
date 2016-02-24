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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Control implements Serializable
{
	private static final long serialVersionUID = 5236503024876576131L;

	@Id
	@SequenceGenerator(name="CONTROL_IDCONTROL_GENERATOR", sequenceName="CONTROL_ID_CONTROL_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTROL_IDCONTROL_GENERATOR")
	@Column(name="id_control")
	private Long idControl;
	
	@Column(name="uuid")
	private Long uid;

	@OneToOne(cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_parent_control")
	private Control parentControl;

	@Column(name="control_name")
	private String controlName;
	private int index;

	@ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_control_type")
	private ControlType controlType;

	@OneToMany(mappedBy="control", cascade={javax.persistence.CascadeType.ALL})
	private List<ControlDefinition> controlDefinitions;

	@ManyToOne(cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_screen")
	private Screen screen;

	public Control()
	{
		this.controlDefinitions = new ArrayList<ControlDefinition>();
	}

	public void addControlDefinition(ControlDefinition definition) {
		if (definition != null) {
			definition.setControl(this);
			definition.getControlProperty().setControlType(this.controlType);
			this.controlDefinitions.add(definition);
		}
	}

	public Long getIdControl() {
		return this.idControl;
	}

	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}

	public String getControlName() {
		return this.controlName;
	}

	public void setControlName(String controlName) {
		this.controlName = controlName;
	}

	public List<ControlDefinition> getControlDefinitions() {
		return this.controlDefinitions;
	}

	public void setControlDefinitions(List<ControlDefinition> controlDefinitions) {
		this.controlDefinitions = controlDefinitions;
	}
	@XmlTransient
	public Screen getScreen() {
		return this.screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Control getParentControl() {
		return this.parentControl;
	}

	public void setParentControl(Control parentControl) {
		this.parentControl = parentControl;
	}

	public ControlType getControlType() {
		return this.controlType;
	}

	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}