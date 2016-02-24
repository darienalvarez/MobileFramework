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
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Screen
implements Serializable
{
	private static final long serialVersionUID = -7742778112621578507L;

	@Id
	@SequenceGenerator(name="SCREEN_IDSCREEN_GENERATOR", sequenceName="SCREEN_ID_SCREEN_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCREEN_IDSCREEN_GENERATOR")
	@Column(name="id_screen")
	private Long idScreen;
	private String description;
	private String name;

	@Column(name="isdefault")
	private boolean defaultScreen;

	@OneToMany(mappedBy="screen", cascade={javax.persistence.CascadeType.ALL})
	private List<Control> controls;

	@ManyToOne(fetch=FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="id_application")
	private Application application;

	@OneToMany(mappedBy="screen", cascade={javax.persistence.CascadeType.ALL})
	private List<Datasource> datasources;

	public Screen()
	{
		this.controls = new ArrayList<Control>();
		this.datasources = new ArrayList<Datasource>();
	}

	public void addControl(Control control) {
		if (control != null) {
			if (this.controls == null) {
				this.controls = new ArrayList<Control>();
			}

			List<ControlDefinition> def = control.getControlDefinitions();
			for (ControlDefinition controlDefinition : def) {
				controlDefinition.setControl(control);
			}

			control.setScreen(this);

			this.controls.add(control);
		}
	}

	public void addDatasource(Datasource datasource) {
		if (datasource != null) {
			if (this.datasources == null) {
				this.datasources = new ArrayList<Datasource>();
			}

			datasource.setScreen(this);

			this.datasources.add(datasource);
		}
	}

	public Long getIdScreen() {
		return this.idScreen;
	}

	public void setIdScreen(Long idScreen) {
		this.idScreen = idScreen;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDefaultScreen() {
		return this.defaultScreen;
	}

	public void setDefaultScreen(boolean defaultScreen) {
		this.defaultScreen = defaultScreen;
	}
	@XmlTransient
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<Datasource> getDatasources() {
		return this.datasources;
	}

	public void setDatasources(List<Datasource> datasources) {
		this.datasources = datasources;
	}

	public List<Control> getControls() {
		return this.controls;
	}

	public void setControls(List<Control> controls) {
		this.controls = controls;
	}
}