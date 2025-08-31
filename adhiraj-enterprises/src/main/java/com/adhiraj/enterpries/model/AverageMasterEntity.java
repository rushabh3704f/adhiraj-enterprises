package com.adhiraj.enterpries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "average_mst_tbl")
public class AverageMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "model_name")
	private String modelName;

	@Column(name = "cwc")
	private Double cwc;

	@Column(name = "cbc")
	private Double cbc;

	@Column(name = "fsd_dsd")
	private Double fsdDsd;

	@Column(name = "hsd")
	private Double hsd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Double getCwc() {
		return cwc;
	}

	public void setCwc(Double cwc) {
		this.cwc = cwc;
	}

	public Double getCbc() {
		return cbc;
	}

	public void setCbc(Double cbc) {
		this.cbc = cbc;
	}

	public Double getFsdDsd() {
		return fsdDsd;
	}

	public void setFsdDsd(Double fsdDsd) {
		this.fsdDsd = fsdDsd;
	}

	public Double getHsd() {
		return hsd;
	}

	public void setHsd(Double hsd) {
		this.hsd = hsd;
	}

}
