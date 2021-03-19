package com.shope.dev.model;

import javax.persistence.Column;

public class BaseEntity {

	@Column(name = "created_by")
	private String 	createdBy;
	
	@Column(name = "created_on")
	private String 	createdOn;
	
}
