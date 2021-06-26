package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel()
	{
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try{
		reader = new Xls_Reader("C:\\Users\\Lenovo\\Framework\\SeleniumProject\\ebayTestdata.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		for(int rowNum = 2; rowNum<=reader.getRowCount("Register"); rowNum++)
		{
			String firstname = reader.getCellData("Register", "firstname", rowNum);
			String lastname = reader.getCellData("Register", "lastname", rowNum);
			String email = reader.getCellData("Register", "email", rowNum);
			String password = reader.getCellData("Register", "password", rowNum);
			

		
		Object ob[] = {firstname,lastname,email,password};

		myData.add(ob);
		}
		return myData;
	}

}
