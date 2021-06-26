/*
 * This is my project
 */

package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {

		
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Lenovo\\Framework\\SeleniumProject\\ebayTestdata.xlsx");
		
		String firstname = reader.getCellData("Register", 0, 2);
		//System.out.println(firstname);
		
		
		String lastname = reader.getCellData("Register", 1, 2);
		//System.out.println(lastname);
		
		
		String email = reader.getCellData("Register", 2, 2);
		//System.out.println(email);
		

		String password = reader.getCellData("Register", 3, 2);
		//System.out.println(password);
		
		
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		//driver.get("https://www.ebay.com/");
		//driver.findElement(By.xpath("//*[@id='gh-ug-flex']/a")).click();
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		
	}

}
