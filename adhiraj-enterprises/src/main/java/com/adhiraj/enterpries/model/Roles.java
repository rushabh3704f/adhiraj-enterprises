package com.adhiraj.enterpries.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	private Long roleId;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "organisation_id")
	private int organisationId;

	public Roles() {
		
	}

	public Roles(String roleName, Long roleId, int organisationId) {
		super();
		this.roleName = roleName;
		this.roleId = roleId;
		this.organisationId = organisationId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public int getOrganisationId() {
		return organisationId;
	}


	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

}
