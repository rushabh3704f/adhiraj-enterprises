package com.shope.dev.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.shope.dev.model.UnitTypeMaster;
import com.shope.dev.model.UserData;
import com.shope.dev.repository.BillingDetailsForPurchaseRepository;
import com.shope.dev.repository.BillingDetailsForSaleRepository;
import com.shope.dev.repository.PaymentHistoryDetailsPurchaseRepository;
import com.shope.dev.repository.PaymentHistoryDetailsRepository;
import com.shope.dev.repository.ProductDetailsForPurchaseRepository;
import com.shope.dev.repository.ProductDetailsForSaleRepository;
import com.shope.dev.repository.ShopeCreateEmployeeSalaryRepository;
import com.shope.dev.repository.UnitTypeMasterRepository;
import com.shope.dev.service.Constants;
import com.shope.dev.service.DigitalShopeService;
import com.shope.dev.service.Utils;

@Controller
public class DigitalShopeController {

	@Autowired
	DigitalShopeService digitalShopeService;
	
	@Autowired
	PaymentHistoryDetailsPurchaseRepository paymentHistoryDetailsPurchaseRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	ProductDetailsForSaleRepository productDetailsForSaleRepository;
	
	@Autowired
	UnitTypeMasterRepository unitTypeMasterRepository;
	
	@Autowired
	ShopeCreateEmployeeSalaryRepository shopeCreateEmployeeSalaryRepository;
	
	@Autowired
	BillingDetailsForSaleRepository billingDetailsForSaleRepository;
	
	@Autowired
	PaymentHistoryDetailsRepository paymentHistoryDetailsRepository;
	
	@Autowired
	BillingDetailsForPurchaseRepository billingDetailsForPurchaseRepository;
	
	@Autowired
	ProductDetailsForPurchaseRepository productDetailsForPurchaseRepository;
	
	@Autowired
	HttpSession session;
	
    //===================================================================================================================
	@RequestMapping("/createNewOrder")
	public String createNewOrder(Model model, @ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
	    int maxNumber=digitalShopeService.getMaxNumber();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    
	    int billAmount = digitalShopeService.getSumOfProduct();
	    model.addAttribute("billAmount",billAmount);
	    
	    List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
		model.addAttribute("productMasterList",productMasterList);
		
		List<UnitTypeMaster> unitTypeMasterList= unitTypeMasterRepository.getAllUnitTypeList();
		model.addAttribute("unitTypeMasterList",unitTypeMasterList);
		
		List<TempProductDetailsForSale> tempProductDetailsForSale=digitalShopeService.getAllProductDetailsByBillingNumber();
		model.addAttribute("shopeCreateOrderForSaleList",tempProductDetailsForSale);
		
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		
	    model.addAttribute("shopeCreateOrderForSale",billDetailsForSale);
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createNewOrder";
	}
	
	
	
	@PostMapping(value="/createNewOrder", params= {"command=addItemInList"})
	public String addItemInList(Model model, @ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale,BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		digitalShopeService.addItemInList(billDetailsForSale);
		List<TempProductDetailsForSale> tempProductDetailsForSale=digitalShopeService.getAllProductDetailsByBillingNumber();
		model.addAttribute("shopeCreateOrderForSaleList",tempProductDetailsForSale);
		model.addAttribute("shopeCreateOrderForSale",billDetailsForSale);
	    model.addAttribute("billNumber",billDetailsForSale.getBillingNumber());
	    int billAmount = digitalShopeService.getSumOfProduct();
	    model.addAttribute("billAmount",billAmount);
	    List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
	  	model.addAttribute("productMasterList",productMasterList);
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());

		return "createNewOrder";
	}
	
	
	
	@PostMapping(value="/createNewOrder", params= {"command=generateBill"})
	public String generateBill(Model model, @ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.generateBill(billDetailsForSale);		
		digitalShopeService.rePaymentHistorySaveDuringBillGeneration(billDetailsForSale);
		
		List<TempProductDetailsForSale> tempProductDetailsForSale=digitalShopeService.getAllProductDetailsByBillingNumber();
		digitalShopeService.placeFinalOrder(tempProductDetailsForSale);
		digitalShopeService.deleteTempOrder(tempProductDetailsForSale);
		model.addAttribute("shopeCreateOrderForSaleList",tempProductDetailsForSale);
		model.addAttribute("shopeCreateOrderForSale",billDetailsForSale); 
	    int maxNumber=digitalShopeService.getMaxNumber();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
	    return "redirect:thanks";
	}
	
	  @RequestMapping(value = "/thanks", method = RequestMethod.GET)
	   public String finalPage() {
	      return "thanks";
	   }
	
	
	@RequestMapping("/deleteProductById")
	public String deleteProductById(Model model, @ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteSoldProductById(String.valueOf(billDetailsForSale.getId()),billDetailsForSale.getSum());
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		
		List<TempProductDetailsForSale> tempProductDetailsForSale=digitalShopeService.getAllProductDetailsByBillingNumber();
		model.addAttribute("shopeCreateOrderForSaleList",tempProductDetailsForSale);
		
	    int billAmount = digitalShopeService.getSumOfProduct();
	    model.addAttribute("billAmount",billAmount);
	    
	    int maxNumber=digitalShopeService.getMaxNumber();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    
	    model.addAttribute("systemDate",utils.getCurrentDate());	    
	    List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
	  	model.addAttribute("productMasterList",productMasterList);
	  	
		model.addAttribute("shopeCreateOrderForSale",billDetailsForSale);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createNewOrder";
	}
	
	
	

	
	@RequestMapping("/createEmployee")
	public String renderOnEmployeePage(Model model, @ModelAttribute("shopeCreateEmployee")ShopeCreateEmployee shopeCreateEmployee, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ShopeCreateEmployee> shopeCreateEmployeeList=digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList",shopeCreateEmployeeList);
		model.addAttribute("shopeCreateEmployee",shopeCreateEmployee);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "employee";
	}
	
	@PostMapping(value="/createEmployee", params= {"command=addEmployee"})
	public String createEmployee(Model model, @ModelAttribute("shopeCreateEmployee")ShopeCreateEmployee shopeCreateEmployee,BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		try {
			shopeCreateEmployee.setCreatedOn(utils.getCurrentDate());
			digitalShopeService.createNewEmployee(shopeCreateEmployee);
		}
		catch (DataIntegrityViolationException e) {
			List<ShopeCreateEmployee> shopeCreateEmployeeList = digitalShopeService.getAllEmployeList();
			model.addAttribute("shopeCreateEmployeeList", shopeCreateEmployeeList);
			model.addAttribute("shopeCreateEmployee", shopeCreateEmployee);
			model.addAttribute("msg", "Refresh Your Page Please");
			return "employee";
		}
		List<ShopeCreateEmployee> shopeCreateEmployeeList = digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList", shopeCreateEmployeeList);
		model.addAttribute("shopeCreateEmployee", shopeCreateEmployee);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "employee";
	}
	
	
	@RequestMapping("/deleteEmployeeById")
	public String deleteEmployeeById(Model model, @ModelAttribute("shopeCreateEmployee")ShopeCreateEmployee shopeCreateEmployee,@RequestParam("employeeId") String employeeId, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteEmployeeById(employeeId);
		List<ShopeCreateEmployee> shopeCreateEmployeeList=digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList",shopeCreateEmployeeList);
		model.addAttribute("shopeCreateEmployee",shopeCreateEmployee);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "employee";
	}
	
	@RequestMapping("/createClient")
	public String renderOnCreateClient(Model model, @ModelAttribute("shopeCreateClient")ShopeCreateClient shopeCreateClient,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		model.addAttribute("shopeCreateClient",shopeCreateClient);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createClient";
	}
	
	
	@PostMapping(value="/createClient", params= {"command=createClient"})
	public String createClient(Model model, @ModelAttribute("shopeCreateClient")ShopeCreateClient shopeCreateClient,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		shopeCreateClient.setCreatedOn(utils.getCurrentDate());
		digitalShopeService.createNewClient(shopeCreateClient);
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		model.addAttribute("shopeCreateClient",shopeCreateClient);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createClient";
	}
	
	
	@RequestMapping("/deleteClientById")
	public String deleteClientById(Model model, @ModelAttribute("shopeCreateClient")ShopeCreateClient shopeCreateClient,@RequestParam("clientId") String clientId, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteClientById(clientId);
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		model.addAttribute("shopeCreateClient",shopeCreateClient);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createClient";
	}
	
	
	//========================================================================================================================
	@RequestMapping("/createEmpSalary")
	public String rendarOnEmpSalary(Model model, @ModelAttribute("shopeCreateEmployeeSalary")ShopeCreateEmployeeSalary shopeCreateEmployeeSalary, BindingResult bindingResult) {		
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ShopeCreateEmployee> shopeCreateEmployeeList = digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList", shopeCreateEmployeeList);
		
		List<ShopeCreateEmployeeSalary> shopeCreateEmployeeSalaryList=digitalShopeService.getAllSalaryList();
		model.addAttribute("shopeCreateEmployeeSalaryList",shopeCreateEmployeeSalaryList);
		model.addAttribute("shopeCreateEmployeeSalary", shopeCreateEmployeeSalary);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "emp-salary";
	}
	
	@PostMapping(value="/createEmpSalary", params= {"command=createSalary"})
	public String createEmpSalary(Model model, @ModelAttribute("shopeCreateEmployeeSalary")ShopeCreateEmployeeSalary shopeCreateEmployeeSalary,BindingResult bindingResult) throws ParseException {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		shopeCreateEmployeeSalary.setCreatedOn(utils.getCurrentDate());
		shopeCreateEmployeeSalary.setPaymentDate(utils.getDateInDDMMMYYYY(shopeCreateEmployeeSalary.getPaymentDate().toString()));
		digitalShopeService.createEmpSalary(shopeCreateEmployeeSalary);
		
		List<ShopeCreateEmployeeSalary> shopeCreateEmployeeSalaryList=digitalShopeService.getAllSalaryList();
		model.addAttribute("shopeCreateEmployeeSalaryList",shopeCreateEmployeeSalaryList);
		model.addAttribute("shopeCreateEmployeeSalary",shopeCreateEmployeeSalary);
		
		List<ShopeCreateEmployee> shopeCreateEmployeeList = digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList", shopeCreateEmployeeList);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "emp-salary";
	}
	
	
	@RequestMapping("/deleteSalaryById")
	public String deleteSalaryById(Model model, @ModelAttribute("shopeCreateEmployeeSalary")ShopeCreateEmployeeSalary shopeCreateEmployeeSalary,@RequestParam("clientId") String clientId, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteEmpSalById(clientId);
		List<ShopeCreateEmployeeSalary> shopeCreateEmployeeSalaryList=digitalShopeService.getAllSalaryList();
		model.addAttribute("shopeCreateEmployeeSalaryList",shopeCreateEmployeeSalaryList);
		model.addAttribute("shopeCreateEmployeeSalary", shopeCreateEmployeeSalary);
		
		List<ShopeCreateEmployee> shopeCreateEmployeeList = digitalShopeService.getAllEmployeList();
		model.addAttribute("shopeCreateEmployeeList", shopeCreateEmployeeList);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);	
	    model.addAttribute("role",data.getRole());
		return "emp-salary";
	}
	
	
	//========================================================================================================================
	@RequestMapping("/createPurchaseProduct")
	public String addPurchaseProduct(Model model, @ModelAttribute("shopeCreateProductForPurchase")ShopeCreateProductForPurchase shopeCreateProductForPurchase, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ShopeCreateProductForPurchase> shopeCreateProductForPurchaseList=digitalShopeService.getCreatedPurchaseProduct();
		model.addAttribute("shopeCreateProductForPurchaseList",shopeCreateProductForPurchaseList);
		model.addAttribute("shopeCreateProductForPurchase", shopeCreateProductForPurchase);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createProductForPurchase";
	}
	
	
	@PostMapping(value="/createPurchaseProduct", params= {"command=createPurchaseProduct"})
	public String createPurchaseProduct(Model model, @ModelAttribute("shopeCreateProductForPurchase")ShopeCreateProductForPurchase shopeCreateProductForPurchase,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		int maxClient=digitalShopeService.getMaxPurchaseProduct();
		shopeCreateProductForPurchase.setProductId(utils.uniquePurchaesProductId(maxClient));
		shopeCreateProductForPurchase.setCreatedOn(utils.getCurrentDate());
		
		digitalShopeService.createPurchaseProduct(shopeCreateProductForPurchase);
		List<ShopeCreateProductForPurchase> shopeCreateProductForPurchaseList=digitalShopeService.getCreatedPurchaseProduct();
		model.addAttribute("shopeCreateProductForPurchaseList",shopeCreateProductForPurchaseList);
		model.addAttribute("shopeCreateProductForPurchase",shopeCreateProductForPurchase);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createProductForPurchase";
	}
	
	
	@PostMapping(value="/createPurchaseProduct", params= {"command=updatePurchaseProduct"})
	public String updatePurchaseProduct(Model model, @ModelAttribute("shopeCreateProductForPurchase")ShopeCreateProductForPurchase shopeCreateProductForPurchase,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		shopeCreateProductForPurchase.setCreatedOn(utils.getCurrentDate());
		digitalShopeService.createPurchaseProduct(shopeCreateProductForPurchase);
		
		List<ShopeCreateProductForPurchase> shopeCreateProductForPurchaseList=digitalShopeService.getCreatedPurchaseProduct();
		model.addAttribute("shopeCreateProductForPurchaseList",shopeCreateProductForPurchaseList);
		
		model.addAttribute("shopeCreateProductForPurchase",shopeCreateProductForPurchase);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createProductForPurchase";
	}
	
	
	
	
	@RequestMapping("/deleteCreatedPurchaseProductById")
	public String deleteCreatedPurchaseProductById(Model model, @ModelAttribute("shopeCreateProductForPurchase")ShopeCreateProductForPurchase shopeCreateProductForPurchase,@RequestParam("purchaseProductId") String purchaseProductId, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteCreatedPurchaseProductById(purchaseProductId);
		List<ShopeCreateProductForPurchase> shopeCreateProductForPurchaseList=digitalShopeService.getCreatedPurchaseProduct();
		model.addAttribute("shopeCreateProductForPurchaseList",shopeCreateProductForPurchaseList);
		model.addAttribute("shopeCreateProductForPurchase",shopeCreateProductForPurchase);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createProductForPurchase";
	}

	
	//========================================================================================================================
	@RequestMapping("/createSaleProduct")
	public String addSaleProduct(Model model, @ModelAttribute("shopeCreateProductForSale")ShopeCreateProductForSale shopeCreateProductForSale, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ShopeCreateProductForSale> shopeCreateProductForSaleList=digitalShopeService.getCreatedSaleProduct();
		model.addAttribute("shopeCreateProductForSaleList",shopeCreateProductForSaleList);
		model.addAttribute("shopeCreateProductForSale", shopeCreateProductForSale);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createProductForSale";
	}
	
	
	@PostMapping(value="/createSaleProduct", params= {"command=createSaleProduct"})
	public String createSaleProduct(Model model, @ModelAttribute("shopeCreateProductForSale")ShopeCreateProductForSale shopeCreateProductForSale,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		int maxClient=digitalShopeService.getMaxProduct();
		shopeCreateProductForSale.setProductId(utils.uniqueProductId(maxClient));
		shopeCreateProductForSale.setCreatedOn(utils.getCurrentDate());
		try {
			digitalShopeService.createProductForSale(shopeCreateProductForSale);
			List<ShopeCreateProductForSale> shopeCreateProductForSaleList=digitalShopeService.getCreatedSaleProduct();
			model.addAttribute("shopeCreateProductForSaleList",shopeCreateProductForSaleList);
		}
		catch (DataIntegrityViolationException e) {
			List<ShopeCreateProductForSale> shopeCreateProductForSaleList=digitalShopeService.getCreatedSaleProduct();
			model.addAttribute("shopeCreateProductForSaleList",shopeCreateProductForSaleList);
			model.addAttribute("msg","Please Refresh Page..");
			return "createProductForSale";
		}
		model.addAttribute("shopeCreateProductForSale",shopeCreateProductForSale);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createProductForSale";
	}
	
	
	
	@PostMapping(value="/createSaleProduct", params= {"command=updateSaleProduct"})
	public String updateSaleProduct(Model model, @ModelAttribute("shopeCreateProductForSale")ShopeCreateProductForSale shopeCreateProductForSale,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		shopeCreateProductForSale.setCreatedOn(utils.getCurrentDate());
		digitalShopeService.createProductForSale(shopeCreateProductForSale);
		
		List<ShopeCreateProductForSale> shopeCreateProductForSaleList=digitalShopeService.getCreatedSaleProduct();
		model.addAttribute("shopeCreateProductForSaleList",shopeCreateProductForSaleList);
		
		model.addAttribute("shopeCreateProductForSale",shopeCreateProductForSale);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createProductForSale";
	}
	
	
	
	
	
	@RequestMapping("/deleteCreatedSaleProductById")
	public String deleteSaleProductById(Model model, @ModelAttribute("shopeCreateProductForPurchase")ShopeCreateProductForPurchase shopeCreateProductForSale,@RequestParam("saleProductId") String saleProductId, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteCreatedSaleProductById(saleProductId);
		List<ShopeCreateProductForSale> shopeCreateProductForSaleList=digitalShopeService.getCreatedSaleProduct();
		model.addAttribute("shopeCreateProductForSaleList",shopeCreateProductForSaleList);
		model.addAttribute("shopeCreateProductForSale",shopeCreateProductForSale);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createProductForSale";
	}
	
	
	//====================================================================================================================
	@RequestMapping("/createNewPurchaseOrder")
	public String createNewPurchaseOrder(Model model, @ModelAttribute("shopeCreateOrderForPurchase")BillingDetailsForPurchase billingDetailsForPurchase, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		int maxNumber=digitalShopeService.getMaxNumberFormPurchase();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    
	    int billAmount = digitalShopeService.getSumOfPurchaseProduct();
	    model.addAttribute("billAmount",billAmount);
	    
	    List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();
		model.addAttribute("productMasterList",productMasterList);
		
		List<UnitTypeMaster> unitTypeMasterList= unitTypeMasterRepository.getAllUnitTypeList();
		model.addAttribute("unitTypeMasterList",unitTypeMasterList);
		
		List<TempProductDetailsForPurchase> tempProductDetailsForPurchase=digitalShopeService.getAllPurchaseProductDetailsByBillingNumber();
		model.addAttribute("tempProductDetailsForPurchase",tempProductDetailsForPurchase);
		
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		
	    model.addAttribute("shopeCreateOrderForSale",billingDetailsForPurchase);
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createNewPurchaseOrder";
	}
	
	
	
	@PostMapping(value="/createNewPurchaseOrder", params= {"command=addItemInPurchase"})
	public String addItemInList(Model model, @ModelAttribute("shopeCreateOrderForPurchase")BillingDetailsForPurchase billingDetailsForPurchase,BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.addItemInList(billingDetailsForPurchase);
		List<TempProductDetailsForPurchase> tempProductDetailsForPurchase=digitalShopeService.getAllPurchaseProductDetailsByBillingNumber();
		model.addAttribute("tempProductDetailsForPurchase",tempProductDetailsForPurchase);
		
		model.addAttribute("billingDetailsForPurchase",billingDetailsForPurchase);
	    model.addAttribute("billNumber",billingDetailsForPurchase.getBillingNumber());
	    
	    int billAmount = digitalShopeService.getSumOfPurchaseProduct();
	    model.addAttribute("billAmount",billAmount);
	    
	    List<ShopeCreateProductForPurchase>shopeCreateProductForPurchase = digitalShopeService.getCreatedPurchaseProduct();
	  	model.addAttribute("productMasterList",shopeCreateProductForPurchase);
	  	
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "createNewPurchaseOrder";
	}
	


	@PostMapping(value="/createNewPurchaseOrder", params= {"command=genPurchaseBill"})
	public String generateBill(Model model, @ModelAttribute("shopeCreateOrderForPurchase")BillingDetailsForPurchase billingDetailsForPurchase,BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.generateBillForPurchase(billingDetailsForPurchase);
		digitalShopeService.rePaymentPurchaseHistorySaveDuringBillGeneration(billingDetailsForPurchase);
		
		List<TempProductDetailsForPurchase> tempProductDetailsForPurchase=digitalShopeService.getAllPurchaseProductDetailsByBillingNumber();
		digitalShopeService.placeFinalPurchaseOrder(tempProductDetailsForPurchase);
		
		digitalShopeService.deletePurchaseTempOrder(tempProductDetailsForPurchase);
		
		model.addAttribute("shopeCreateOrderForSaleList",tempProductDetailsForPurchase);
		model.addAttribute("shopeCreateOrderForSale",billingDetailsForPurchase); 
		
	    int maxNumber=digitalShopeService.getMaxNumber();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
	    return "redirect:thanksPurchase";
	}
	
	
	  @RequestMapping(value = "/thanksPurchase", method = RequestMethod.GET)
	   public String thanksPurchase() {
	      return "thanksPurchase";
	   }
	
	
	
	@RequestMapping("/deletePurchaseProductById")
	public String deletePurchaseProductById(Model model, @ModelAttribute("shopeCreateOrderForPurchase")BillingDetailsForPurchase billingDetailsForPurchase, BindingResult bindingResult) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		digitalShopeService.deleteSoldPurchaseProductById(String.valueOf(billingDetailsForPurchase.getId()));
		List<ShopeCreateClient> shopeCreateClientList=digitalShopeService.getAllClientList();
		model.addAttribute("shopeCreateClientList",shopeCreateClientList);
		
		List<TempProductDetailsForPurchase> tempProductDetailsForPurchase=digitalShopeService.getAllPurchaseProductDetailsByBillingNumber();
		model.addAttribute("tempProductDetailsForPurchase",tempProductDetailsForPurchase);
		
	    int billAmount = digitalShopeService.getSumOfPurchaseProduct();
	    model.addAttribute("billAmount",billAmount);
	    
	    int maxNumber=digitalShopeService.getMaxNumberFormPurchase();
	    String billNumber= utils.uniqueBillNo(maxNumber);
	    model.addAttribute("billNumber",billNumber);
	    
	    model.addAttribute("systemDate",utils.getCurrentDate());	
	    
	    List<ShopeCreateProductForPurchase>shopeCreateProductForPurchase = digitalShopeService.getCreatedPurchaseProduct();
	  	model.addAttribute("productMasterList",shopeCreateProductForPurchase);
	  	
		model.addAttribute("shopeCreateOrderForPurchase",billingDetailsForPurchase);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "createNewPurchaseOrder";
	}
	
	
	
	@RequestMapping("/purchaseOrderList")
	public String getPurchaseOrderList(Model model,@ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<BillingDetailsForPurchase>billingDetailsForPurchaseList = digitalShopeService.getAllBillingDetailsForPurchaseList();		
	    List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();    
		List<BillingDetailsForPurchase>billingDetailsForPurchaseListWithProductName =new ArrayList<>();
			
		for (ShopeCreateProductForPurchase shopeCreateProductForPurchase : productMasterList) {
			
			for (BillingDetailsForPurchase billingDetailsForPurchase : billingDetailsForPurchaseList) {
				if (billingDetailsForPurchase.getProduct().equals(shopeCreateProductForPurchase.getProductId())) {
					billingDetailsForPurchase.setProductName(shopeCreateProductForPurchase.getProductName());
					billingDetailsForPurchaseListWithProductName.add(billingDetailsForPurchase);
				}
			}
		}
		
	    model.addAttribute("productDetailsForPurchase",productDetailsForPurchase);
	    model.addAttribute("billingDetailsForPurchaseList",billingDetailsForPurchaseListWithProductName);
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "purchaseOrderList";
	}
	
	
	@RequestMapping("/purchaseOrderListByBillNumber")
	public String purchaseOrderListByBillNumber(Model model,@ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase1, @RequestParam("billNumber")String billNumber) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ProductDetailsForPurchase>productDetailsForPurchaseList = digitalShopeService.getAllProductDetailsForPurchaseList(billNumber);
	    List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();   
		List<ProductDetailsForPurchase>billingDetailsForPurchaseListWithProductName =new ArrayList<>();
			
		for (ShopeCreateProductForPurchase shopeCreateProductForPurchase : productMasterList) {
			for (ProductDetailsForPurchase productDetailsForPurchase : productDetailsForPurchaseList) {
				if (productDetailsForPurchase.getProductId().equals(shopeCreateProductForPurchase.getProductId())) {
					productDetailsForPurchase.setProductName(shopeCreateProductForPurchase.getProductName());
					billingDetailsForPurchaseListWithProductName.add(productDetailsForPurchase);
				}
			}
		}
		model.addAttribute("productDetailsForPurchaseList",billingDetailsForPurchaseListWithProductName);
		model.addAttribute("productDetailsForPurchase",productDetailsForPurchase1);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "purchaseOrderListByBillNumber";
	}
	
	
	
	@RequestMapping("/saleOrderListByBillNumber")
	public String saleOrderListByBillNumber(Model model,@ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale1,@RequestParam("billNumber")String billNumber) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ProductDetailsForSale>productDetailsForSaleList = digitalShopeService.getAllProductDetailsForSaleList(billNumber);
		List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
		List<ProductDetailsForSale>productDetailsForSaleListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForSale productDetailsForSale : productDetailsForSaleList) {
			for (ShopeCreateProductForSale shopeCreateProductForSale : productMasterList) {
				if (shopeCreateProductForSale.getProductId().equals(productDetailsForSale.getProductId())) {
					productDetailsForSale.setProductName(shopeCreateProductForSale.getProductName());
					productDetailsForSaleListWithProductName.add(productDetailsForSale);
				}
			}
		}
		
		model.addAttribute("productDetailsForSaleList",productDetailsForSaleListWithProductName);
		model.addAttribute("productDetailsForSale",productDetailsForSale1);
		model.addAttribute("BASE_URL",Constants.BASE_URL);	
		model.addAttribute("role",data.getRole());
		return "saleOrderListByBillNumber";
	}
	
	
	
	@RequestMapping("/orderList")
	public String orderList(Model model,@ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<BillingDetailsForSale>billingDetailsForSaleList = digitalShopeService.getAllBillingDetailsForSaleList();
		List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
		List<BillingDetailsForSale>billingDetailsForSaleListWithProductName =new ArrayList<>();	
		
		for (ShopeCreateProductForSale shopeCreateProductForSale : productMasterList) {
			
			for (BillingDetailsForSale billingDetailsForSale : billingDetailsForSaleList) {
				if (billingDetailsForSale.getProduct().equals(shopeCreateProductForSale.getProductId())) {
					billingDetailsForSale.setProductName(shopeCreateProductForSale.getProductName());
					billingDetailsForSaleListWithProductName.add(billingDetailsForSale);
				}
			}
		}
		model.addAttribute("productDetailsForSale",productDetailsForSale);		
		model.addAttribute("billingDetailsForSaleList",billingDetailsForSaleListWithProductName);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "saleOrderList";
	}

	//===================================================================================================================
	@RequestMapping("/purchaseReport")
	public String getPurchaseReport(Model model) {

		return "purchase-report";
	}

	@RequestMapping("/salesReport")
	public String salesReport(Model model) {
		System.out.println("-----");
		return "sales-report";
	}

	@ResponseBody
	@PostMapping(value="/getDropdownValue")
	public ShopeCreateProductForSale getDropdownValue(Model mod,@ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, @RequestParam("productId") String productId) {
	  ShopeCreateProductForSale shopeCreateProductForSale =digitalShopeService.getDropdownValueByProductId(productId);
	  return shopeCreateProductForSale;
	}

	
	@ResponseBody
	@PostMapping(value="/getBillingDetails")
	public ShopeCreateClient getBillingDetails(Model mod,@ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, @RequestParam("billingNameId") String billingNameId) {
	  ShopeCreateClient shopeCreateClient =digitalShopeService.getClientDetailsById(billingNameId);
	  return shopeCreateClient;
	}

	@ResponseBody
	@PostMapping(value="/getClientId")
	public String getClientId(Model mod,@ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, @RequestParam("clientId") String clientId) {
	    int maxClient=digitalShopeService.getMaxClient();
	    String newClientId= utils.uniqueClientId(maxClient);
	    return newClientId;
	}
	
	

	@ResponseBody
	@PostMapping(value="/getEmployeeId")
	public String getEmployeeId(Model mod,@ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, @RequestParam("clientId") String clientId) {
	    int maxClient=digitalShopeService.getMaxEmployee();
	    String newEmployeeId= utils.uniqueEmployeeId(maxClient);
	    return newEmployeeId;
	}
	
	
	@ResponseBody
	@PostMapping(value="/getDropdownValueForPurchase")
	public ShopeCreateProductForPurchase getDropdownValueForPurchase(Model mod,@ModelAttribute("shopeCreateOrderForSale")BillingDetailsForSale billDetailsForSale, @RequestParam("productId") String productId) {
		ShopeCreateProductForPurchase shopeCreateProductForPurchase =digitalShopeService.getDropdownValueForPurchase(productId);
	  return shopeCreateProductForPurchase;
	}
	
	
	
	@ResponseBody
	@PostMapping(value="/getEmployeeSalary")
	public ShopeCreateEmployee getEmployeeSalary(Model mod,@ModelAttribute("shopeCreateEmployee")ShopeCreateEmployee shopeCreateEmployee, @RequestParam("employeeId") String employeeId) {
		
		ShopeCreateEmployee shopeCreateEmployee1 =digitalShopeService.getEmployeeSalary(employeeId);
		return shopeCreateEmployee1;
	}
	
	
	@RequestMapping("/invoiceDetails")
	public String invoiceDetails(Model model, @RequestParam("billNumber") String billNumber) {

		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ProductDetailsForSale>productDetailsForSaleList = digitalShopeService.getAllProductDetailsForSaleList(billNumber);		
		List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();    
		List<ProductDetailsForSale>productDetailsForSaleListWithProductName =new ArrayList<>();	
		
		for (ProductDetailsForSale productDetailsForSale : productDetailsForSaleList) {
			
			for (ShopeCreateProductForSale shopeCreateProductForSale : productMasterList) {
				if (shopeCreateProductForSale.getProductId().equals(productDetailsForSale.getProductId())) {
					productDetailsForSale.setProductName(shopeCreateProductForSale.getProductName());
					productDetailsForSale.setPerKgOrPiece(shopeCreateProductForSale.getUnitType());
					productDetailsForSaleListWithProductName.add(productDetailsForSale);
				}
			}
		}
		
		BillingDetailsForSale shopeCreateClient = digitalShopeService.getAllBillingDetailsForSale(billNumber);		
	    model.addAttribute("billName",shopeCreateClient.getBillingName());
	    model.addAttribute("billAddress",shopeCreateClient.getAddress());
	    model.addAttribute("phoneNumber",shopeCreateClient.getPhoneNumber());
	    model.addAttribute("orderPlaceDate",shopeCreateClient.getCreatedOn());

		model.addAttribute("productDetailsForSaleList",productDetailsForSaleListWithProductName);	
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "invoiceDetails";
	}

	
	
	@RequestMapping("/invoiceDetailsPurchase")
	public String invoiceDetailsPurchase(Model model, @RequestParam("billNumber") String billNumber) {
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		List<ProductDetailsForPurchase>productDetailsForPurchaseList = digitalShopeService.getAllProductDetailsForPurchaseList(billNumber);
		List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();
		List<ProductDetailsForPurchase>productDetailsForPurchaseListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForPurchase productDetailsForPurchase : productDetailsForPurchaseList) {
			
			for (ShopeCreateProductForPurchase shopeCreateProductForSale : productMasterList) {
				if (shopeCreateProductForSale.getProductId().equals(productDetailsForPurchase.getProductId())) {
					productDetailsForPurchase.setProductName(shopeCreateProductForSale.getProductName());
					productDetailsForPurchase.setPerKgOrPiece(shopeCreateProductForSale.getUnitType());
					productDetailsForPurchaseListWithProductName.add(productDetailsForPurchase);
				}
			}
		}
		
		BillingDetailsForPurchase shopeCreateClient = digitalShopeService.getBillingDetailsForPurchase(billNumber);		
	    model.addAttribute("billName",shopeCreateClient.getBillingName());
	    model.addAttribute("billAddress",shopeCreateClient.getAddress());
	    model.addAttribute("phoneNumber",shopeCreateClient.getPhoneNumber());
	    model.addAttribute("orderPlaceDate",shopeCreateClient.getCreatedOn());
		
		
		model.addAttribute("productDetailsForPurchaseList",productDetailsForPurchaseListWithProductName);	
	    model.addAttribute("systemDate",utils.getCurrentDate());
	    model.addAttribute("BASE_URL",Constants.BASE_URL);
	    model.addAttribute("role",data.getRole());
		return "invoiceDetailsPurchase";
	}
	
	
	
	@RequestMapping("/paymentHistory")
	public String paymentHistory(Model model, @RequestParam("billNumber") String billNumber) {
		return "saleOrderPaymentHistory";
	}
	
	
	
	@RequestMapping("/deleteProductDetailsForSale")
	public String deleteProductDetailsForSale(Model model,@ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale1, @RequestParam("productId") String productId,@RequestParam("billNumber") String billingNumber) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		productDetailsForSaleRepository.deleteProductDetailsForSaleById(productId);
		List<ProductDetailsForSale>productDetailsForSaleList = digitalShopeService.getAllProductDetailsForSaleList(billingNumber);
		List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();
		List<ProductDetailsForSale>productDetailsForSaleListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForSale productDetailsForSale : productDetailsForSaleList) {
			for (ShopeCreateProductForSale shopeCreateProductForSale : productMasterList) {
				if (shopeCreateProductForSale.getProductId().equals(productDetailsForSale.getProductId())) {
					productDetailsForSale.setProductName(shopeCreateProductForSale.getProductName());
					productDetailsForSaleListWithProductName.add(productDetailsForSale);
				}
			}
		}
		model.addAttribute("productDetailsForSaleList",productDetailsForSaleListWithProductName);
		model.addAttribute("productDetailsForSale",productDetailsForSale1);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "saleOrderListByBillNumber";
	}
	
	@RequestMapping("/deleteProductDetailsForPurchase")
	public String deleteProductDetailsForPurchase(Model model,@ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase1, @RequestParam("productId") String productId,@RequestParam("billNumber") String billingNumber) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		productDetailsForPurchaseRepository.deleteProductDetailsForPurchaseById(productId);
		List<ProductDetailsForPurchase>productDetailsForPurchaseList = digitalShopeService.getAllProductDetailsForPurchaseList(billingNumber);
		List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();
		List<ProductDetailsForPurchase>productDetailsForPurchaseListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForPurchase productDetailsForPurchase : productDetailsForPurchaseList) {
			for (ShopeCreateProductForPurchase shopeCreateProductForPurchase : productMasterList) {
				if (shopeCreateProductForPurchase.getProductId().equals(productDetailsForPurchase.getProductId())) {
					productDetailsForPurchase.setProductName(shopeCreateProductForPurchase.getProductName());
					productDetailsForPurchaseListWithProductName.add(productDetailsForPurchase);
				}
			}
		}
		model.addAttribute("productDetailsForPurchaseList",productDetailsForPurchaseListWithProductName);
		model.addAttribute("productDetailsForPurchase",productDetailsForPurchase1);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "purchaseOrderListByBillNumber";
	}
	
	
	
	@PostMapping(value="/updateProductForSale", params= {"command=updateProduct"})
	public String updateOrderForSale(Model model, @ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		productDetailsForSaleRepository.updateProductDetailsForSaleById(productDetailsForSale.getUnit(),productDetailsForSale.getSum(),productDetailsForSale.getId());
		int paidAmount=billingDetailsForSaleRepository.getPaidAmountForSale(productDetailsForSale.getBillingNumber());
		int unPaidAmount=Integer.valueOf(productDetailsForSale.getSum())-paidAmount;
		billingDetailsForSaleRepository.updateBillingDetailsForSale(productDetailsForSale.getBillingNumber(),productDetailsForSale.getSum(),unPaidAmount);

		
		List<ProductDetailsForSale>productDetailsForSaleList = digitalShopeService.getAllProductDetailsForSaleList(productDetailsForSale.getBillingNumber());
		List<ShopeCreateProductForSale>productMasterList = digitalShopeService.getCreatedSaleProduct();	    
		List<ProductDetailsForSale>productDetailsForSaleListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForSale productDetailsForSale1 : productDetailsForSaleList) {
			
			for (ShopeCreateProductForSale shopeCreateProductForSale : productMasterList) {
				if (shopeCreateProductForSale.getProductId().equals(productDetailsForSale1.getProductId())) {
					productDetailsForSale1.setProductName(shopeCreateProductForSale.getProductName());
					productDetailsForSaleListWithProductName.add(productDetailsForSale1);
				}
			}
		}
		model.addAttribute("productDetailsForSaleList",productDetailsForSaleListWithProductName);
		model.addAttribute("productDetailsForSale",productDetailsForSale);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "saleOrderListByBillNumber";
	}
	
	
	//updatePurchaseProduct
	@PostMapping(value="/productDetailsForPurchase", params= {"command=updatePurchaseProduct"})
	public String updatePurchaseProduct(Model model, @ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		
		productDetailsForPurchaseRepository.updateProductDetailsForPurchaseById(productDetailsForPurchase.getUnit(),productDetailsForPurchase.getSum(),productDetailsForPurchase.getId());
		int paidAmount=billingDetailsForPurchaseRepository.getPaidAmountForPurchase(productDetailsForPurchase.getBillingNumber());
		int unPaidAmount=Integer.valueOf(productDetailsForPurchase.getSum())-paidAmount;
		billingDetailsForPurchaseRepository.updateBillingDetailsForPurchase(productDetailsForPurchase.getBillingNumber(),productDetailsForPurchase.getSum(),unPaidAmount);

		
		List<ProductDetailsForPurchase>productDetailsForPurchaseList = digitalShopeService.getAllProductDetailsForPurchaseList(productDetailsForPurchase.getBillingNumber());
		List<ShopeCreateProductForPurchase>productMasterList = digitalShopeService.getCreatedPurchaseProduct();	    
		List<ProductDetailsForPurchase>productDetailsForPurchaseListWithProductName =new ArrayList<>();
		
		for (ProductDetailsForPurchase productDetailsForPurchase1 : productDetailsForPurchaseList) {
			
			for (ShopeCreateProductForPurchase shopeCreateProductForPurchase : productMasterList) {
				if (shopeCreateProductForPurchase.getProductId().equals(productDetailsForPurchase1.getProductId())) {
					productDetailsForPurchase1.setProductName(shopeCreateProductForPurchase.getProductName());
					productDetailsForPurchaseListWithProductName.add(productDetailsForPurchase1);
				}
			}
		}
		model.addAttribute("productDetailsForPurchaseList",productDetailsForPurchaseListWithProductName);
		model.addAttribute("productDetailsForPurchase",productDetailsForPurchase);
		model.addAttribute("BASE_URL",Constants.BASE_URL);
		model.addAttribute("role",data.getRole());
		return "purchaseOrderListByBillNumber";
	}
	
	
	@PostMapping(value="/updateProductForSale", params= {"command=rePay"})
	public String rePay(Model model, @ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		digitalShopeService.rePaymentHistorySave(productDetailsForSale);
		billingDetailsForSaleRepository.updateProductDetailsForSaleByBillNumber(productDetailsForSale.getPaidAmount(),productDetailsForSale.getUnPaidAmount(),productDetailsForSale.getBillingNumber());
		model.addAttribute("role",data.getRole());
		return "redirect:orderList";
	}
	
	
	@RequestMapping(value="/paymentHistoryDetails")
	public String paymentHistoryDetails(Model model, @ModelAttribute("productDetailsForSale")ProductDetailsForSale productDetailsForSale,@RequestParam("billingNumber") String billingNumber, BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		List<PaymentHistoryDetails> paymentHistoryDetailsList= paymentHistoryDetailsRepository.getPaymentHistoryByBill(billingNumber);
		model.addAttribute("paymentHistoryDetailsList",paymentHistoryDetailsList);
		model.addAttribute("role",data.getRole());
		return "paymentHistoryDetails";
	}
	
	
	@RequestMapping(value="/paymentHistoryDetailsPurchase")
	public String paymentHistoryDetailsPurchase(Model model, @ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase,@RequestParam("billingNumber") String billingNumber, BindingResult bindingResult) {
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		List<PaymentHistoryDetailsPurchase> paymentHistoryDetailsList= paymentHistoryDetailsPurchaseRepository.getPaymentHistoryByBill(billingNumber);
		model.addAttribute("paymentHistoryDetailsList",paymentHistoryDetailsList);
		model.addAttribute("role",data.getRole());
		return "paymentHistoryDetailsPurchase";
	}
	
	
	@PostMapping(value="/updateProductForPurchase", params= {"command=rePayPurchase"})
	public String rePayPurchase(Model model, @ModelAttribute("productDetailsForPurchase")ProductDetailsForPurchase productDetailsForPurchase,BindingResult bindingResult) {
		
		UserData data = (UserData) session.getAttribute("userData");
		if(data==null) {
			return "redirect:loginPage";
		}
		digitalShopeService.rePaymentHistorySavePurchase(productDetailsForPurchase);
		billingDetailsForPurchaseRepository.updateProductDetailsForSaleByBillNumber(productDetailsForPurchase.getPaidAmount(),productDetailsForPurchase.getUnPaidAmount(),productDetailsForPurchase.getBillingNumber());
		model.addAttribute("role",data.getRole());
		return "redirect:purchaseOrderList";
	}
	
	

}
