package com.adhiraj.enterpries.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl {

	public String uniqueBillNo(int approveCount) {
		approveCount++;
		Date d = new Date();
		int year = d.getYear();
		year = year - 100;
		String slNumber = "CHKN" + String.format("%04d", approveCount);
		System.out.println("Unique Number " + slNumber);
		return slNumber;
	}

	public static String getCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String currentDate = dtf.format(now);
		return currentDate;
	}
}
