package com.gazoomobile.mfw.platform.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Permissionset
implements Serializable
{
	private static final long serialVersionUID = -8582852524441187891L;

	@Id
	@SequenceGenerator(name="PERMISSIONSET_IDPERMISSIONSET_GENERATOR", sequenceName="PERMISSIONSET_ID_PERMISSIONSET_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSIONSET_IDPERMISSIONSET_GENERATOR")
	@Column(name="id_permissionset")
	private Long idPermissionset;
	private String description;
	private String name;

	@ManyToMany(cascade={javax.persistence.CascadeType.ALL})
	@JoinTable(name="permissionset_permission", joinColumns={@javax.persistence.JoinColumn(name="id_permissionset")}, inverseJoinColumns={@javax.persistence.JoinColumn(name="id_permission")})
	private List<Permission> permissions;

	@ManyToMany(mappedBy="permissionsets")
	private List<User> users;

	public Permissionset()
	{
		this.permissions = new ArrayList<Permission>();
		this.users = new ArrayList<User>();
	}

	public Long getIdPermissionset() {
		return this.idPermissionset;
	}

	public void setIdPermissionset(Long idPermissionset) {
		this.idPermissionset = idPermissionset;
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

	public List<Permission> getPermissions() {
		return this.permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}