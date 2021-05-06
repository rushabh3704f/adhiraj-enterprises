package com.shope.dev.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shope.dev.model.BillingDetailsForPurchase;
import com.shope.dev.model.BillingDetailsForSale;
import com.shope.dev.model.PaymentHistoryDetails;
import com.shope.dev.model.PaymentHistoryDetailsPurchase;
import com.shope.dev.model.ProductDetailsForPurchase;
import com.shope.dev.model.ProductDetailsForSale;
import com.shope.dev.model.ShopeCreateClient;
import com.shope.dev.model.ShopeCreateEmployee;
import com.shope.dev.model.ShopeCreateEmployeeSalary;
import com.shope.dev.model.ShopeCreateProductForPurchase;
import com.shope.dev.model.ShopeCreateProductForSale;
import com.shope.dev.model.TempProductDetailsForPurchase;
import com.shope.dev.model.TempProductDetailsForSale;
import com.shope.dev.repository.BillingDetailsForPurchaseRepository;
import com.shope.dev.repository.BillingDetailsForSaleRepository;
import com.shope.dev.repository.PaymentHistoryDetailsPurchaseRepository;
import com.shope.dev.repository.PaymentHistoryDetailsRepository;
import com.shope.dev.repository.ProductDetailsForPurchaseRepository;
import com.shope.dev.repository.ProductDetailsForSaleRepository;
import com.shope.dev.repository.ShopeCreateClientRepository;
import com.shope.dev.repository.ShopeCreateEmployeeRepository;
import com.shope.dev.repository.ShopeCreateEmployeeSalaryRepository;
import com.shope.dev.repository.ShopeCreateProductForPurchaseRepository;
import com.shope.dev.repository.ShopeCreateProductForSaleRepository;
import com.shope.dev.repository.SoldProductRepository;
import com.shope.dev.repository.TempProductDetailsForPurchaseRepository;
import com.shope.dev.repository.TempProductDetailsForSaleRepository;

@Service
public class DigitalShopeService {
	
	@Autowired
	PaymentHistoryDetailsRepository paymentHistoryDetailsRepository;
	
	@Autowired
	PaymentHistoryDetailsPurchaseRepository paymentHistoryDetailsPurchaseRepository;

	@Autowired
	ShopeCreateEmployeeRepository shopeCreateEmployeeRepository;

	@Autowired
	ShopeCreateClientRepository shopeCreateClientRepository;

	@Autowired
	ShopeCreateEmployeeSalaryRepository shopeCreateEmployeeSalaryRepository;

	@Autowired
	ShopeCreateProductForPurchaseRepository shopeCreateProductForPurchaseRepository;

	@Autowired
	ShopeCreateProductForSaleRepository shopeCreateProductForSaleRepository;

	@Autowired
	BillingDetailsForSaleRepository billingDetailsForSaleRepository;

	@Autowired
	SoldProductRepository soldProductRepository;

	@Autowired
	TempProductDetailsForSaleRepository tempProductDetailsForSaleRepository;

	@Autowired
	ProductDetailsForSaleRepository productDetailsForSaleRepository;

	@Autowired
	TempProductDetailsForPurchaseRepository tempProductDetailsForPurchaseRepository;

	@Autowired
	BillingDetailsForPurchaseRepository billingDetailsForPurchaseRepository;

	@Autowired
	ProductDetailsForPurchaseRepository productDetailsForPurchaseRepository;

	public void createNewEmployee(ShopeCreateEmployee shopeCreateEmployee) {
		// TODO Auto-generated method stub
		shopeCreateEmployee.setIsActive("A");
		shopeCreateEmployeeRepository.save(shopeCreateEmployee);
	}

	public List<ShopeCreateEmployee> getAllEmployeList() {
		// TODO Auto-generated method stub
		List<ShopeCreateEmployee> shopeCreateEmployeeList = shopeCreateEmployeeRepository.getAllEmployeList();
		return shopeCreateEmployeeList;
	}

	public void deleteEmployeeById(String employeeId) {
		// TODO Auto-generated method stub
		shopeCreateEmployeeRepository.deleteEmployeeById(employeeId);
	}

	public void createNewClient(ShopeCreateClient shopeCreateClient) {
		// TODO Auto-generated method stub
		shopeCreateClient.setIsActive("A");
		shopeCreateClientRepository.save(shopeCreateClient);

	}

	public List<ShopeCreateClient> getAllClientList() {
		// TODO Auto-generated method stub
		List<ShopeCreateClient> shopeCreateClientList = shopeCreateClientRepository.getAllEmployeList();
		return shopeCreateClientList;
	}

	public void deleteClientById(String employeeId) {
		// TODO Auto-generated method stub
		shopeCreateClientRepository.deleteEmployeeById(employeeId);

	}

	public void createEmpSalary(ShopeCreateEmployeeSalary shopeCreateEmployeeSalary) {
		// TODO Auto-generated method stub
		shopeCreateEmployeeSalary.setIsActive("A");
		shopeCreateEmployeeSalaryRepository.save(shopeCreateEmployeeSalary);
	}

	public List<ShopeCreateEmployeeSalary> getAllSalaryList() {
		// TODO Auto-generated method stub
		List<ShopeCreateEmployeeSalary> shopeCreateClientList = shopeCreateEmployeeSalaryRepository.getAllSalaryList();
		return shopeCreateClientList;
	}

	public List<ShopeCreateProductForPurchase> getCreatedPurchaseProduct() {
		// TODO Auto-generated method stub
		List<ShopeCreateProductForPurchase> shopeCreateProductForPurchaseList = shopeCreateProductForPurchaseRepository
				.getCreatedPurchaseProduct();
		return shopeCreateProductForPurchaseList;
	}

	public void createPurchaseProduct(ShopeCreateProductForPurchase shopeCreateProductForPurchase) {
		// TODO Auto-generated method stub
		shopeCreateProductForPurchase.setIsActive("A");
		shopeCreateProductForPurchaseRepository.save(shopeCreateProductForPurchase);
	}

	public void deleteCreatedPurchaseProductById(String purchaseProductId) {
		// TODO Auto-generated method stub
		shopeCreateProductForPurchaseRepository.deleteCreatedPurchaseProductById(purchaseProductId);
	}

	public void createProductForSale(ShopeCreateProductForSale shopeCreateProductForSale) {
		// TODO Auto-generated method stub
		shopeCreateProductForSale.setIsActive("A");
		shopeCreateProductForSaleRepository.save(shopeCreateProductForSale);

	}

	public List<ShopeCreateProductForSale> getCreatedSaleProduct() {
		// TODO Auto-generated method stub
		List<ShopeCreateProductForSale> shopeCreateProductForSaleList = shopeCreateProductForSaleRepository
				.getCreatedSaleProduct();
		return shopeCreateProductForSaleList;
	}

	public void deleteCreatedSaleProductById(String purchaseProductId) {
		// TODO Auto-generated method stub
		shopeCreateProductForSaleRepository.deleteCreatedSaleProductById(purchaseProductId);

	}

	public List<BillingDetailsForSale> getAllCreateOrderForSale() {
		// TODO Auto-generated method stub
		List<BillingDetailsForSale> shopeCreateOrderForSaleList = billingDetailsForSaleRepository.getAllCreateOrderForSale();
		return shopeCreateOrderForSaleList;
	}

	public void generateBill(BillingDetailsForSale billDetailsForSale) {
		// TODO Auto-generated method stub
		billDetailsForSale.setIsActive("A");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		billDetailsForSale.setCreatedOn(dtf.format(now));
		billDetailsForSale.setCreatedBy("Alam");
		billingDetailsForSaleRepository.save(billDetailsForSale);
	}

	public void saveSoldProduct(BillingDetailsForSale billingDetailsForSale) {
		// TODO Auto-generated method stub
		BillingDetailsForSale billingDetailsForSale1 = new BillingDetailsForSale();
		billingDetailsForSale1.setBillingName(billingDetailsForSale.getBillingName());
		billingDetailsForSale1.setBillingNumber(billingDetailsForSale.getBillingNumber());
		billingDetailsForSale1.setProduct(billingDetailsForSale.getProduct());
		billingDetailsForSale1.setPerKgOrPice(billingDetailsForSale.getPerKgOrPice());
		billingDetailsForSale1.setRate(billingDetailsForSale.getRate());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		billingDetailsForSale1.setCreatedOn(dtf.format(now));
		billingDetailsForSale1.setCreatedBy("Alam");
		billingDetailsForSaleRepository.save(billingDetailsForSale1);
	}

	public void deleteSoldProductById(String productId,String amount) {
		// TODO Auto-generated method stub
		billingDetailsForSaleRepository.deletePoductUpdateAmount(productId,amount);
		tempProductDetailsForSaleRepository.deleteProductFromListByProductId(productId);
	}

	public void addItemInList(BillingDetailsForSale billDetailsForSale) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		TempProductDetailsForSale tempProductDetailsForSale = new TempProductDetailsForSale();
		tempProductDetailsForSale.setIsActive("A");
		tempProductDetailsForSale.setBillingNumber(billDetailsForSale.getBillingNumber());
		tempProductDetailsForSale.setProductId(billDetailsForSale.getProduct());
		tempProductDetailsForSale.setUnit(billDetailsForSale.getUnit());
		tempProductDetailsForSale.setPerKgOrPiece(billDetailsForSale.getPerKgOrPice());
		tempProductDetailsForSale.setRate(billDetailsForSale.getRate());
		tempProductDetailsForSale.setSum(billDetailsForSale.getSum());
		tempProductDetailsForSale.setCreatedOn(dtf.format(now));
		tempProductDetailsForSale.setCreatedBy("Alam");
		tempProductDetailsForSale.setProductName(getSaleProductNameByProductId(billDetailsForSale.getProduct()));
		tempProductDetailsForSaleRepository.save(tempProductDetailsForSale);
	}

	private String getSaleProductNameByProductId(String product) {
		// TODO Auto-generated method stub
		ShopeCreateProductForSale shopeCreateProductForSale = shopeCreateProductForSaleRepository
				.getDropdownValueByProductId(product);
		return shopeCreateProductForSale.getProductName();
	}

	public List<TempProductDetailsForSale> getAllProductDetailsByBillingNumber() {
		// TODO Auto-generated method stub
		List<TempProductDetailsForSale> tempProductDetailsForSale = tempProductDetailsForSaleRepository.getAllProductDetailsByBillingNumber();
		return tempProductDetailsForSale;
	}

	public int getMaxNumber() {
		// TODO Auto-generated method stub
		int num = billingDetailsForSaleRepository.getMaxNumber();
		return num;
	}

	public ShopeCreateProductForSale getDropdownValueByProductId(String productId) {
		// TODO Auto-generated method stub
		ShopeCreateProductForSale shopeCreateProductForSale = shopeCreateProductForSaleRepository
				.getDropdownValueByProductId(productId);
		return shopeCreateProductForSale;
	}

	public double getSumOfProduct() {
		// TODO Auto-generated method stub
		double totalSum = tempProductDetailsForSaleRepository.getSumOfProduct();
		return totalSum;
	}

	public void placeFinalOrder(List<TempProductDetailsForSale> tempProductDetailsForSale) {
		// TODO Auto-generated method stub
		for (TempProductDetailsForSale tempProductDetailsForSale2 : tempProductDetailsForSale) {
			ProductDetailsForSale productDetailsForSale = new ProductDetailsForSale();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			productDetailsForSale.setIsActive("A");
			productDetailsForSale.setBillingNumber(tempProductDetailsForSale2.getBillingNumber());
			productDetailsForSale.setProductId(tempProductDetailsForSale2.getProductId());
			productDetailsForSale.setUnit(tempProductDetailsForSale2.getUnit());
			productDetailsForSale.setRate(tempProductDetailsForSale2.getRate());
			productDetailsForSale.setSum(tempProductDetailsForSale2.getSum());
			productDetailsForSale.setCreatedOn(dtf.format(now));
			productDetailsForSale.setCreatedBy("Alam");
			productDetailsForSaleRepository.save(productDetailsForSale);
		}

	}

	public void deleteTempOrder(List<TempProductDetailsForSale> tempProductDetailsForSale) {
		// TODO Auto-generated method stub
		tempProductDetailsForSaleRepository.deleteAll(tempProductDetailsForSale);
	}

	public ShopeCreateClient getClientDetailsById(String billingNameId) {
		// TODO Auto-generated method stub
		ShopeCreateClient shopeCreateClient = shopeCreateClientRepository.getClientDetailsById(billingNameId);
		return shopeCreateClient;
	}

	public int getMaxClient() {
		// TODO Auto-generated method stub
		int num = shopeCreateClientRepository.getMaxClient();
		return num;
	}

	public int getMaxEmployee() {
		// TODO Auto-generated method stub
		int num = shopeCreateEmployeeRepository.getMaxEmployee();
		return num;
	}

	public void deleteEmpSalById(String id) {
		// TODO Auto-generated method stub
		shopeCreateEmployeeSalaryRepository.deleteEmpSalById(id);
	}

	public int getMaxProduct() {
		// TODO Auto-generated method stub
		int num = shopeCreateProductForSaleRepository.getMaxProduct();
		return num;
	}

	public int getMaxPurchaseProduct() {
		// TODO Auto-generated method stub
		int num = shopeCreateProductForPurchaseRepository.getMaxPurchaseProduct();
		return num;
	}

	public List<TempProductDetailsForPurchase> getAllPurchaseProductDetailsByBillingNumber() {
		// TODO Auto-generated method stub
		List<TempProductDetailsForPurchase> tempProductDetailsForPurchase = tempProductDetailsForPurchaseRepository
				.getAllPurchaseProductDetailsByBillingNumber();
		return tempProductDetailsForPurchase;
	}

	public int getMaxNumberFormPurchase() {
		// TODO Auto-generated method stub
		int num = billingDetailsForPurchaseRepository.getMaxNumberFormPurchase();
		return num;
	}

	public ShopeCreateProductForPurchase getDropdownValueForPurchase(String productId) {
		// TODO Auto-generated method stub
		ShopeCreateProductForPurchase shopeCreateProductForPurchase = shopeCreateProductForPurchaseRepository
				.getDropdownValueForPurchase(productId);
		return shopeCreateProductForPurchase;
	}

	public void addItemInList(BillingDetailsForPurchase billingDetailsForPurchase) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		TempProductDetailsForPurchase tempProductDetailsForPurchase = new TempProductDetailsForPurchase();
		tempProductDetailsForPurchase.setIsActive("A");
		tempProductDetailsForPurchase.setBillingNumber(billingDetailsForPurchase.getBillingNumber());
		tempProductDetailsForPurchase.setProductId(billingDetailsForPurchase.getProduct());
		tempProductDetailsForPurchase.setUnit(billingDetailsForPurchase.getUnit());
		tempProductDetailsForPurchase.setPerKgOrPiece(billingDetailsForPurchase.getPerKgOrPice());
		tempProductDetailsForPurchase.setRate(billingDetailsForPurchase.getRate());
		tempProductDetailsForPurchase.setSum(billingDetailsForPurchase.getSum());
		tempProductDetailsForPurchase.setCreatedOn(dtf.format(now));
		tempProductDetailsForPurchase.setCreatedBy("Alam");
		tempProductDetailsForPurchase.setProductName(getPurchaseProductNameByProductId(billingDetailsForPurchase.getProduct()));
		tempProductDetailsForPurchaseRepository.save(tempProductDetailsForPurchase);

	}

	public void generateBillForPurchase(BillingDetailsForPurchase billingDetailsForPurchase) {
		// TODO Auto-generated method stub
		billingDetailsForPurchase.setIsActive("A");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		billingDetailsForPurchase.setCreatedOn(dtf.format(now));
		billingDetailsForPurchase.setCreatedBy("Alam");
		billingDetailsForPurchaseRepository.save(billingDetailsForPurchase);

	}

	public double getSumOfPurchaseProduct() {
		// TODO Auto-generated method stub
		double totalSum = tempProductDetailsForPurchaseRepository.getSumOfPurchaseProduct();
		return totalSum;
	}

	public void placeFinalPurchaseOrder(List<TempProductDetailsForPurchase> tempProductDetailsForPurchase) {
		// TODO Auto-generated method stub
		for (TempProductDetailsForPurchase tempProductDetailsForPurchas2 : tempProductDetailsForPurchase) {
			ProductDetailsForPurchase productDetailsForPurchas = new ProductDetailsForPurchase();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
			LocalDateTime now = LocalDateTime.now();
			productDetailsForPurchas.setIsActive("A");
			productDetailsForPurchas.setBillingNumber(tempProductDetailsForPurchas2.getBillingNumber());
			productDetailsForPurchas.setProductId(tempProductDetailsForPurchas2.getProductId());
			productDetailsForPurchas.setUnit(tempProductDetailsForPurchas2.getUnit());
			productDetailsForPurchas.setRate(tempProductDetailsForPurchas2.getRate());
			productDetailsForPurchas.setSum(tempProductDetailsForPurchas2.getSum());
			productDetailsForPurchas.setCreatedOn(dtf.format(now));
			productDetailsForPurchas.setCreatedBy("Alam");
			productDetailsForPurchaseRepository.save(productDetailsForPurchas);
		}

	}

	public void deletePurchaseTempOrder(List<TempProductDetailsForPurchase> tempProductDetailsForPurchase) {
		// TODO Auto-generated method stub
		tempProductDetailsForPurchaseRepository.deleteAll(tempProductDetailsForPurchase);

	}

	public void deleteSoldPurchaseProductById(String productId) {
		// TODO Auto-generated method stub
		tempProductDetailsForPurchaseRepository.deleteProductFromListByProductId(productId);
	}

	private String getPurchaseProductNameByProductId(String product) {
		// TODO Auto-generated method stub
		ShopeCreateProductForPurchase shopeCreateProductForPurchase = shopeCreateProductForPurchaseRepository
				.getDropdownValueForPurchase(product);
		return shopeCreateProductForPurchase.getProductName();
	}

	public List<BillingDetailsForPurchase> getAllBillingDetailsForPurchaseList() {
		// TODO Auto-generated method stub
		List<BillingDetailsForPurchase> billingDetailsForPurchaseList = billingDetailsForPurchaseRepository
				.getAllCreateOrderForPurchase();
		return billingDetailsForPurchaseList;
	}

	public List<BillingDetailsForSale> getAllBillingDetailsForSaleList() {
		// TODO Auto-generated method stub
		List<BillingDetailsForSale> billingDetailsForSaleList = billingDetailsForSaleRepository
				.getAllCreateOrderForSale();
		return billingDetailsForSaleList;
	}

	public List<ProductDetailsForPurchase> getAllProductDetailsForPurchaseList(String billNumber) {
		// TODO Auto-generated method stub
		List<ProductDetailsForPurchase> productDetailsForPurchaseList = productDetailsForPurchaseRepository
				.getAllProductDetailsForPurchaseList(billNumber);
		return productDetailsForPurchaseList;
	}

	public List<ProductDetailsForSale> getAllProductDetailsForSaleList(String billNumber) {
		// TODO Auto-generated method stub
		List<ProductDetailsForSale> productDetailsForSaleList = productDetailsForSaleRepository
				.getAllProductDetailsForSaleList(billNumber);
		return productDetailsForSaleList;
	}

	public ShopeCreateEmployee getEmployeeSalary(String employeeId) {
		// TODO Auto-generated method stub
		ShopeCreateEmployee shopeCreateEmployee = shopeCreateEmployeeRepository.getEmployeeSalary(employeeId);
		return shopeCreateEmployee;
	}

	public void rePaymentHistorySave(ProductDetailsForSale productDetailsForSale) {
		// TODO Auto-generated method stub
		 PaymentHistoryDetails paymentHistoryDetails=new PaymentHistoryDetails();
		 paymentHistoryDetails.setBillingNumber(productDetailsForSale.getBillingNumber());
	 	 paymentHistoryDetails.setProductName(productDetailsForSale.getProductName());
		 paymentHistoryDetails.setTotalBillAmount(productDetailsForSale.getSum()); 
		 paymentHistoryDetails.setPaidAmount(productDetailsForSale.getPaidAmount());
		 paymentHistoryDetails.setUnPaidAmount(productDetailsForSale.getUnPaidAmount());
		 paymentHistoryDetails.setRePayAmount(productDetailsForSale.getRePayAmount());
		 paymentHistoryDetails.setCreatedOn(Utils.getCurrentDate());
		 paymentHistoryDetailsRepository.save(paymentHistoryDetails);
	}

	public void rePaymentHistorySavePurchase(ProductDetailsForPurchase productDetailsForPurchase) {
		// TODO Auto-generated method stub
		 PaymentHistoryDetailsPurchase paymentHistoryDetailsPurchase=new PaymentHistoryDetailsPurchase();
		 paymentHistoryDetailsPurchase.setBillingNumber(productDetailsForPurchase.getBillingNumber());
		 paymentHistoryDetailsPurchase.setProductName(productDetailsForPurchase.getProductName());
		 paymentHistoryDetailsPurchase.setTotalBillAmount(productDetailsForPurchase.getSum()); //getTotalBillAmount()
		 paymentHistoryDetailsPurchase.setPaidAmount(productDetailsForPurchase.getPaidAmount());
		 paymentHistoryDetailsPurchase.setUnPaidAmount(productDetailsForPurchase.getUnPaidAmount());
		 paymentHistoryDetailsPurchase.setRePayAmount(productDetailsForPurchase.getRePayAmount());
		 paymentHistoryDetailsPurchase.setCreatedOn(Utils.getCurrentDate());
		 paymentHistoryDetailsPurchaseRepository.save(paymentHistoryDetailsPurchase);
		
	}

	public void rePaymentHistorySaveDuringBillGeneration(BillingDetailsForSale billDetailsForSale) {
		// TODO Auto-generated method stub
		 PaymentHistoryDetails paymentHistoryDetailsSale=new PaymentHistoryDetails();
		 paymentHistoryDetailsSale.setBillingNumber(billDetailsForSale.getBillingNumber());
		 paymentHistoryDetailsSale.setProductName(billDetailsForSale.getProductName());
		 paymentHistoryDetailsSale.setTotalBillAmount(billDetailsForSale.getBillAmount()); 
		 paymentHistoryDetailsSale.setPaidAmount(billDetailsForSale.getPaidAmount());
		 paymentHistoryDetailsSale.setUnPaidAmount(billDetailsForSale.getUnPaidAmount());
		 paymentHistoryDetailsSale.setRePayAmount("00");
		 paymentHistoryDetailsSale.setCreatedOn(Utils.getCurrentDate());
		 paymentHistoryDetailsRepository.save(paymentHistoryDetailsSale);
	}

	public void rePaymentPurchaseHistorySaveDuringBillGeneration(BillingDetailsForPurchase billingDetailsForPurchase) {
		// TODO Auto-generated method stub
		 PaymentHistoryDetailsPurchase paymentHistoryDetailsPurchase=new PaymentHistoryDetailsPurchase();
		 paymentHistoryDetailsPurchase.setBillingNumber(billingDetailsForPurchase.getBillingNumber());
		 paymentHistoryDetailsPurchase.setProductName(billingDetailsForPurchase.getProductName());
		 paymentHistoryDetailsPurchase.setTotalBillAmount(billingDetailsForPurchase.getBillAmount()); 
		 paymentHistoryDetailsPurchase.setPaidAmount(billingDetailsForPurchase.getPaidAmount());
		 paymentHistoryDetailsPurchase.setUnPaidAmount(billingDetailsForPurchase.getUnPaidAmount());
		 paymentHistoryDetailsPurchase.setRePayAmount("00");
		 paymentHistoryDetailsPurchase.setCreatedOn(Utils.getCurrentDate());
		 paymentHistoryDetailsPurchaseRepository.save(paymentHistoryDetailsPurchase);
	}

	public BillingDetailsForSale getAllBillingDetailsForSale(String billNumber) {
		// TODO Auto-generated method stub
	    BillingDetailsForSale billingDetailsForSaleList = billingDetailsForSaleRepository.getCreateOrderForSale(billNumber);
		return billingDetailsForSaleList;
	}

	public BillingDetailsForPurchase getBillingDetailsForPurchase(String billNumber) {
		// TODO Auto-generated method stub
		BillingDetailsForPurchase billingDetailsForPurchase = billingDetailsForPurchaseRepository.getCreateOrderForPurchase(billNumber);
		return billingDetailsForPurchase;
	 }

}
