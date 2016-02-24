package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Application
implements Serializable
{
	private static final long serialVersionUID = 8913988567576463409L;

	@Id
	@SequenceGenerator(name="APPLICATION_IDAPPLICATION_GENERATOR", sequenceName="APPLICATION_ID_APPLICATION_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPLICATION_IDAPPLICATION_GENERATOR")
	@Column(name="id_application")
	private Long idApplication;
	private String description;
	private String name;

	@OneToMany(mappedBy="application", cascade={javax.persistence.CascadeType.ALL})
	private List<Screen> screens;

	@ManyToMany(mappedBy="applications", cascade={javax.persistence.CascadeType.ALL})
	private List<User> users;

	public Application()
	{
		this.screens = new ArrayList<Screen>();
		this.users = new ArrayList<User>();
	}

	public void addUser(User user) {
		if (user != null) {
			if (this.users == null) {
				this.users = new ArrayList<User>();
			}
			List<Application> apps = user.getApplications();
			if (apps == null) {
				apps = new ArrayList<Application>();
			}
			apps.add(this);

			this.users.add(user);
		}
	}

	public void addScreen(Screen screen) {
		if (screen != null) {
			if (this.screens == null) {
				this.screens = new ArrayList<Screen>();
			}
			screen.setApplication(this);
			this.screens.add(screen);
		}
	}

	public Long getIdApplication() {
		return this.idApplication;
	}

	public void setIdApplication(Long idApplication) {
		this.idApplication = idApplication;
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

	public List<Screen> getScreens() {
		return this.screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}