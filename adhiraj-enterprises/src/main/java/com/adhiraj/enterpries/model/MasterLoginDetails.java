package com.adhiraj.enterpries.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_login_details")
public class MasterLoginDetails implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "date_of_birth")
	private String dateOfBirth;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "employee_id", unique = true, nullable = false)
	private String employeeId;

	@Column(name = "accesscode")
	private String accessCode;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "organisation_id")
	private int organisationId;

	@Column(name = "created_date_time")
	String createdDateTime;

	@Column(name = "is_active")
	private char isActive;

	@Column(name = "is_admin")
	private boolean isAdmin;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "dsa_category_name")
	private String dsaCategoryName;

	@Column(name = "dsa_gstin")
	private String dsaGSTIN;

	@Column(name = "dsa_gstin_frequency")
	private String dsaGSTINFrequency;

	@Column(name = "office_location")
	private String officeLocation;

	@Column(name = "address")
	private String address;

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public int getRoleId() {
		return roleId;
	}

	public int getOrganisationId() {
		return organisationId;
	}

	public String getCreatedDateTime() {
		return createdDateTime;
	}

	public char getIsActive() {
		return isActive;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getDsaCategoryName() {
		return dsaCategoryName;
	}

	public String getDsaGSTIN() {
		return dsaGSTIN;
	}

	public String getDsaGSTINFrequency() {
		return dsaGSTINFrequency;
	}

	public String getOfficeLocation() {
		return officeLocation;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}

	public void setCreatedDateTime(String createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setDsaCategoryName(String dsaCategoryName) {
		this.dsaCategoryName = dsaCategoryName;
	}

	public void setDsaGSTIN(String dsaGSTIN) {
		this.dsaGSTIN = dsaGSTIN;
	}

	public void setDsaGSTINFrequency(String dsaGSTINFrequency) {
		this.dsaGSTINFrequency = dsaGSTINFrequency;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
