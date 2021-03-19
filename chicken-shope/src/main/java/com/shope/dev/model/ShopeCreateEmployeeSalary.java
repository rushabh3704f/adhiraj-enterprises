package com.shope.dev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shope_create_employee_salary")
public class ShopeCreateEmployeeSalary implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "employee_id")
	private String employeeId;

	@Column(name = "payment_date")
	private String paymentDate;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "salary")
	private String salary;

	@Column(name = "payment")
	private String payment;

	@Column(name = "is_given")
	private String isGiven;

	@Column(name = "year")
	private String year;

	@Column(name = "month")
	private String month;

	@Column(name = "leave_in_days")
	private String leaveInDays;

	@Column(name = "total_salary")
	private String totalSalary;

	@Column(name = "pending_salary")
	private String pendingSalary;

	@Column(name = "is_active")
	private String isActive;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_on")
	private String createdOn;

	public String getPendingSalary() {
		return pendingSalary;
	}

	public void setPendingSalary(String pendingSalary) {
		this.pendingSalary = pendingSalary;
	}

	public String getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(String totalSalary) {
		this.totalSalary = totalSalary;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getLeaveInDays() {
		return leaveInDays;
	}

	public void setLeaveInDays(String leaveInDays) {
		this.leaveInDays = leaveInDays;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getIsGiven() {
		return isGiven;
	}

	public void setIsGiven(String isGiven) {
		this.isGiven = isGiven;
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
