package com.master.selenium2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiSelectDropdown {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
	
	
	@Test
	public void selectMultiSelectDD(){
		
		WebElement DD = driver.findElement(By.id("cars"));
		Select sd = new Select(DD);
		
		System.out.println(sd.isMultiple());
		
		sd.selectByIndex(1);
		sd.selectByIndex(3);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//getFirstselectedoption
		System.out.println(sd.getFirstSelectedOption().getText());
		System.out.println("***********************");
		
		//getallselectedoption
	List<WebElement> car = 	sd.getAllSelectedOptions();
	for(WebElement cars : car)
	{
		System.out.println(cars.getText());
	}
	
	sd.deselectAll();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}


}
