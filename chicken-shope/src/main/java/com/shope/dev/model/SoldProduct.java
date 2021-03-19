package com.shope.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shope_sold_product")
public class SoldProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "billing_number")
	private String billingNumber;

	@Column(name = "product")
	private String product;

	@Column(name = "unit")
	private String unit;

	@Column(name = "per_kg_or_pice")
	private String perKgOrPice;

	@Column(name = "rate")
	private String rate;

	@Column(name = "is_active")
	private String isActive;

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getPerKgOrPice() {
		return perKgOrPice;
	}

	public void setPerKgOrPice(String perKgOrPice) {
		this.perKgOrPice = perKgOrPice;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}
