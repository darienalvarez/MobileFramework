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
import javax.persistence.SequenceGenerator;

@Entity
public class Permission
implements Serializable
{
	private static final long serialVersionUID = 6376693575472509471L;

	@Id
	@SequenceGenerator(name="PERMISSION_IDPERMISSION_GENERATOR", sequenceName="PERMISSION_ID_PERMISSION_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERMISSION_IDPERMISSION_GENERATOR")
	@Column(name="id_permission")
	private Long idPermission;
	private String description;
	private String permission;

	@ManyToMany(mappedBy="permissions", cascade={javax.persistence.CascadeType.ALL})
	private List<Permissionset> permissionsets;

	public Permission()
	{
		this.permissionsets = new ArrayList<Permissionset>();
	}

	public Long getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermission() {
		return this.permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<Permissionset> getPermissionsets() {
		return this.permissionsets;
	}

	public void setPermissionsets(List<Permissionset> permissionsets) {
		this.permissionsets = permissionsets;
	}
}