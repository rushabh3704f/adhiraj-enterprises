package com.shope.dev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_history_details")
public class PaymentHistoryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "billing_number")
	private String billingNumber;

	@Column(name = "bill_amount")
	private String billAmount;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "re_pay_amount")
	private String rePayAmount;

	@Column(name = "paid_amount")
	private String paidAmount;

	@Column(name = "total_bill_amount")
	private String totalBillAmount;

	@Column(name = "un_paid_amount")
	private String unPaidAmount;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private String createdOn;

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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getRePayAmount() {
		return rePayAmount;
	}

	public void setRePayAmount(String rePayAmount) {
		this.rePayAmount = rePayAmount;
	}

	public String getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(String totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	public String getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(String billAmount) {
		this.billAmount = billAmount;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getUnPaidAmount() {
		return unPaidAmount;
	}

	public void setUnPaidAmount(String unPaidAmount) {
		this.unPaidAmount = unPaidAmount;
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

}
