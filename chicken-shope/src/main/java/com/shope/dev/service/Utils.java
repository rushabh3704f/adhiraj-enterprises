package com.shope.dev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String uniqueBillNo(int approveCount) {
		approveCount++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "ALAM" + String.format("%04d", approveCount);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		return currentDate;
	}

	public String uniqueClientId(int maxClient) {
		// TODO Auto-generated method stub
		maxClient++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "CLNT" + String.format("%04d", maxClient);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}

	public String uniqueEmployeeId(int maxClient) {
		// TODO Auto-generated method stub
		maxClient++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "EMPL" + String.format("%04d", maxClient);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}

	public String getDateInDDMMMYYYY(String date) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date d = formatter.parse(date);
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
		String strDate = formatter1.format(d);
		System.out.println(strDate);
		return strDate;
	}
	
	public String uniqueProductId(int maxClient) {
		// TODO Auto-generated method stub
		maxClient++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "PRODS" + String.format("%04d", maxClient);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}
	
	
	public String uniquePurchaesProductId(int maxClient) {
		// TODO Auto-generated method stub
		maxClient++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "PRODP" + String.format("%04d", maxClient);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}
	
	

}
