package com.adhiraj.enterpries.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_master")
public class MenuMaster implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "menu_id", unique = true, nullable = false)
	private Long menuId;
	
	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "is_active")
	private String isActive;
	
	@Column(name = "organisation_id")
	private int organisationId;
	
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "url")
	private String url;
	
	public MenuMaster(Long menuId, String menuName, String isActive, int organisationId, int roleId, String url) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.isActive = isActive;
		this.organisationId = organisationId;
		this.roleId = roleId;
		this.url = url;
	}

	public MenuMaster() {
		// TODO Auto-generated constructor stub
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrganisationId() {
		return organisationId;
	}

	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

}
