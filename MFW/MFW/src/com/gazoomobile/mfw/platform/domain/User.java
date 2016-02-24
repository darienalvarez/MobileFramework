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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="users")
public class User
implements Serializable
{
	private static final long serialVersionUID = -4986995424336321434L;

	@Id
	@SequenceGenerator(name="USER_IDUSER_GENERATOR", sequenceName="USERS_ID_USER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_IDUSER_GENERATOR")
	@Column(name="id_user")
	private Long idUser;
	private String description;
	private String fullname;
	private String password;
	private String username;

	@ManyToMany
	@JoinTable(name="user_profile", joinColumns={@javax.persistence.JoinColumn(name="id_user")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="id_permissionset")})
	private List<Permissionset> permissionsets;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_profile", joinColumns={@javax.persistence.JoinColumn(name="id_user")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="id_application")})
	private List<Application> applications;

	public User()
	{
		this.permissionsets = new ArrayList<Permissionset>();
		this.applications = new ArrayList<Application>();
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Permissionset> getPermissionsets() {
		return this.permissionsets;
	}

	public void setPermissionsets(List<Permissionset> permissionsets) {
		this.permissionsets = permissionsets;
	}
	@XmlTransient
	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
}