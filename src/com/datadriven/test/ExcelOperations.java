package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Lenovo\\Framework\\SeleniumProject\\ebayTestdata.xlsx");
		
		
		if(!reader.isSheetExist("HomePage")){
		reader.addSheet("HomePage");
		}
		
		
	int colCount = 	reader.getColumnCount("Register");
	System.out.println("column count is "+colCount);
	
	
	System.out.println(reader.getCellRowNum("Register", "firstname", "Neha"));

	}

}
