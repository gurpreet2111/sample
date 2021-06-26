package com.liveproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class AddDeleteStock {
	
	
	@Test
	public void addStocks()
	{
		selectDateInCalendar("12/01/2019");

	}
	
	public void selectDateInCalendar(String date){
		Date currentDate = new Date();
		System.out.println(currentDate);
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
try {
	dateFormat.parse(date);
	} catch (ParseException e) {
		e.printStackTrace();
}			
		
	}

}
