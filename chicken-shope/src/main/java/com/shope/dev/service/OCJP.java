package com.shope.dev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OCJP {
	public static void main(String[] args) throws ParseException {
		

	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");  
		Date d = formatter.parse("2021-02-21");  
	    System.out.println(d);
	    
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");  
	    String strDate = formatter1.format(d); 
	    System.out.println(strDate);
	    
	}
}
