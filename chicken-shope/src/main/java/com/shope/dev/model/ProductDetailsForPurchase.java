package com.shope.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_details_for_purchase")
public class ProductDetailsForPurchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "billing_number")
	private String billingNumber;

	@Column(name = "product_id")
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit")
	private String unit;

	@Column(name = "rate")
	private String rate;

	@Column(name = "category")
	private String category;

	@Column(name = "per_kg_or_piece")
	private String perKgOrPiece;

	@Column(name = "sum")
	private String sum;

	@Column(name = "re_pay_amount")
	private String rePayAmount;

	@Column(name = "paid_amount")
	private String paidAmount;

	@Column(name = "total_bill_amount")
	private String totalBillAmount;

	@Column(name = "un_paid_amount")
	private String unPaidAmount;

	@Column(name = "is_active")
	private String isActive;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private String createdOn;

	public String getRePayAmount() {
		return rePayAmount;
	}

	public void setRePayAmount(String rePayAmount) {
		this.rePayAmount = rePayAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(String totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public String getUnPaidAmount() {
		return unPaidAmount;
	}

	public void setUnPaidAmount(String unPaidAmount) {
		this.unPaidAmount = unPaidAmount;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBillingNumber() {
		return billingNumber;
	}

	public void setBillingNumber(String billingNumber) {
		this.billingNumber = billingNumber;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPerKgOrPiece() {
		return perKgOrPiece;
	}

	public void setPerKgOrPiece(String perKgOrPiece) {
		this.perKgOrPiece = perKgOrPiece;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
