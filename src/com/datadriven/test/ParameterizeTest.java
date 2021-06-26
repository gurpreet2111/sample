package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {

		Xls_Reader reader = new Xls_Reader("C:\\Users\\Lenovo\\Framework\\SeleniumProject\\ebayTestdata.xlsx");
		
		int rowCount = reader.getRowCount("Register");
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		reader.addColumn("Register", "Status");
		for(int rowNum=2; rowNum<=rowCount; rowNum++)
		{
			//System.out.println("***********************");
			String firstname = reader.getCellData("Register", "firstname", rowNum);
			//System.out.println(firstname);
			
			
			String lastname = reader.getCellData("Register", "lastname", rowNum);
			//System.out.println(lastname);
			
			String email = reader.getCellData("Register", "email", rowNum);
			//System.out.println(email);
			
			
			String password = reader.getCellData("Register", "password", rowNum);
			//System.out.println(password);
			
			
			
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
			//driver.get("https://www.ebay.com/");
			//driver.findElement(By.xpath("//*[@id='gh-ug-flex']/a")).click();
			driver.findElement(By.id("firstname")).clear();;
			driver.findElement(By.id("firstname")).sendKeys(firstname);
			
			driver.findElement(By.id("lastname")).clear();
			driver.findElement(By.id("lastname")).sendKeys(lastname);

			driver.findElement(By.id("Email")).clear();;
			driver.findElement(By.id("Email")).sendKeys(email);

			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			
			reader.setCellData("Register", "Status", rowNum, "Pass");
			
		}

	}

}
