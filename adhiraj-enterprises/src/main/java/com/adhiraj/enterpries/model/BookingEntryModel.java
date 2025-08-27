package com.adhiraj.enterpries.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allocation_dtl_tbl")
public class BookingEntryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "sr_no")
	private String srNo;

	@Column(name = "stock_tr_num")
	private String stockTrNum;

	@Column(name = "stock_tr_date")
	private String stockTrDate;

	@Column(name = "delivery_num")
	private String deliveryNum;

	@Column(name = "vehicle_chassis_num")
	private String vehicleChassisNum;

	@Column(name = "vehicle_engine_num")
	private String vehicleEngineNum;

	@Column(name = "material_code")
	private String materialCode;

	@Column(name = "material_description")
	private String materialDescription;

	@Column(name = "division")
	private String division;

	@Column(name = "dealer_code")
	private String dealerCode;

	@Column(name = "region")
	private String region;

	@Column(name = "depo_dealer_rgp_export")
	private String depoDealerRgpExport;

	@Column(name = "depot_To_Desc")
	private String depotToDesc;

	@Column(name = "transporter")
	private String transporter;

	@Column(name = "stn_value")
	private String stnValue;

	@Column(name = "trc_vo")
	private String trcNo;

	@Column(name = "bill_to_party")
	private String billToParty;

	@Column(name = "ship_to_party")
	private String shipToParty;

	@Column(name = "shipment_no")
	private String shipmentNo;

	@Column(name = "plant")
	private String plant;

	@Column(name = "gw")
	private String gw;

	@Column(name = "invoice_no")
	private String invoiceNo;

	@Column(name = "status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
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

	public String getVehicleChassisNum() {
		return vehicleChassisNum;
	}

	public void setVehicleChassisNum(String vehicleChassisNum) {
		this.vehicleChassisNum = vehicleChassisNum;
	}

	public String getVehicleEngineNum() {
		return vehicleEngineNum;
	}

	public void setVehicleEngineNum(String vehicleEngineNum) {
		this.vehicleEngineNum = vehicleEngineNum;
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

}
