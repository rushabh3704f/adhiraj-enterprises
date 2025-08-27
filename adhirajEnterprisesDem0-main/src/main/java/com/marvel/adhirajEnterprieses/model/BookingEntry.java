package com.marvel.adhirajEnterprieses.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class BookingEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sNo;
	private String stockTrNum;
	private String stockTrDate;
	private String deliveryNum;
	private String vehicleChassisNumber;
	private String vehicleEngineNumber;
	private String materialCode;
	private String materialDescription;
	private String division;
	private String dealerCode;
	private String region;
	private String depoDealerRgpExport;
	private String depotToDesc;
	private String transporter;
	private String stnValue;
	private String trcNo;
	private String billToParty;
	private String shipToParty;
	private String shipmentNo;
	private String plant;
	private String gw;
	private String invoiceNo;
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getStockTrNum() {
		return stockTrNum;
	}
	public void setStockTrNum(String stockTrNum) {
		this.stockTrNum = stockTrNum;
	}
	public String getStockTrDate() {
		return stockTrDate;
	}
	public void setStockTrDate(String stockTrDate) {
		this.stockTrDate = stockTrDate;
	}
	public String getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public String getVehicleChassisNumber() {
		return vehicleChassisNumber;
	}
	public void setVehicleChassisNumber(String vehicleChassisNumber) {
		this.vehicleChassisNumber = vehicleChassisNumber;
	}
	public String getVehicleEngineNumber() {
		return vehicleEngineNumber;
	}
	public void setVehicleEngineNumber(String vehicleEngineNumber) {
		this.vehicleEngineNumber = vehicleEngineNumber;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getMaterialDescription() {
		return materialDescription;
	}
	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDepoDealerRgpExport() {
		return depoDealerRgpExport;
	}
	public void setDepoDealerRgpExport(String depoDealerRgpExport) {
		this.depoDealerRgpExport = depoDealerRgpExport;
	}
	public String getDepotToDesc() {
		return depotToDesc;
	}
	public void setDepotToDesc(String depotToDesc) {
		this.depotToDesc = depotToDesc;
	}
	public String getTransporter() {
		return transporter;
	}
	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}
	public String getStnValue() {
		return stnValue;
	}
	public void setStnValue(String stnValue) {
		this.stnValue = stnValue;
	}
	public String getTrcNo() {
		return trcNo;
	}
	public void setTrcNo(String trcNo) {
		this.trcNo = trcNo;
	}
	public String getBillToParty() {
		return billToParty;
	}
	public void setBillToParty(String billToParty) {
		this.billToParty = billToParty;
	}
	public String getShipToParty() {
		return shipToParty;
	}
	public void setShipToParty(String shipToParty) {
		this.shipToParty = shipToParty;
	}
	public String getShipmentNo() {
		return shipmentNo;
	}
	public void setShipmentNo(String shipmentNo) {
		this.shipmentNo = shipmentNo;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getGw() {
		return gw;
	}
	public void setGw(String gw) {
		this.gw = gw;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BookingEntry [id=" + id + ", sNo=" + sNo + ", stockTrNum=" + stockTrNum + ", stockTrDate=" + stockTrDate
				+ ", deliveryNum=" + deliveryNum + ", vehicleChassisNumber=" + vehicleChassisNumber
				+ ", vehicleEngineNumber=" + vehicleEngineNumber + ", materialCode=" + materialCode
				+ ", materialDescription=" + materialDescription + ", division=" + division + ", dealerCode="
				+ dealerCode + ", region=" + region + ", depoDealerRgpExport=" + depoDealerRgpExport + ", depotToDesc="
				+ depotToDesc + ", transporter=" + transporter + ", stnValue=" + stnValue + ", trcNo=" + trcNo
				+ ", billToParty=" + billToParty + ", shipToParty=" + shipToParty + ", shipmentNo=" + shipmentNo
				+ ", plant=" + plant + ", gw=" + gw + ", invoiceNo=" + invoiceNo + ", status=" + status + "]";
	}
	public BookingEntry() {
		super();
	}
	public BookingEntry(Long id, String sNo, String stockTrNum, String stockTrDate, String deliveryNum,
			String vehicleChassisNumber, String vehicleEngineNumber, String materialCode, String materialDescription,
			String division, String dealerCode, String region, String depoDealerRgpExport, String depotToDesc,
			String transporter, String stnValue, String trcNo, String billToParty, String shipToParty,
			String shipmentNo, String plant, String gw, String invoiceNo, String status) {
		super();
		this.id = id;
		this.sNo = sNo;
		this.stockTrNum = stockTrNum;
		this.stockTrDate = stockTrDate;
		this.deliveryNum = deliveryNum;
		this.vehicleChassisNumber = vehicleChassisNumber;
		this.vehicleEngineNumber = vehicleEngineNumber;
		this.materialCode = materialCode;
		this.materialDescription = materialDescription;
		this.division = division;
		this.dealerCode = dealerCode;
		this.region = region;
		this.depoDealerRgpExport = depoDealerRgpExport;
		this.depotToDesc = depotToDesc;
		this.transporter = transporter;
		this.stnValue = stnValue;
		this.trcNo = trcNo;
		this.billToParty = billToParty;
		this.shipToParty = shipToParty;
		this.shipmentNo = shipmentNo;
		this.plant = plant;
		this.gw = gw;
		this.invoiceNo = invoiceNo;
		this.status = status;
	}
	
	
}