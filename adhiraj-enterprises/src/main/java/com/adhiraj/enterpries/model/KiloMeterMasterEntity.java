package com.adhiraj.enterpries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kilometer_mst_tbl")
public class KiloMeterMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "region")
	private String region;

	@Column(name = "depot")
	private String depot;

	@Column(name = "dealer_code")
	private String dealerCode;

	@Column(name = "dealer_type")
	private String dealerType;

	@Column(name = "dealer_ship_name")
	private String dealerShipName;

	@Column(name = "location")
	private String location;

	@Column(name = "final_km")
	private String finalKm;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepot() {
		return depot;
	}

	public void setDepot(String depot) {
		this.depot = depot;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerType() {
		return dealerType;
	}

	public void setDealerType(String dealerType) {
		this.dealerType = dealerType;
	}

	public String getDealerShipName() {
		return dealerShipName;
	}

	public void setDealerShipName(String dealerShipName) {
		this.dealerShipName = dealerShipName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFinalKm() {
		return finalKm;
	}

	public void setFinalKm(String finalKm) {
		this.finalKm = finalKm;
	}

}
