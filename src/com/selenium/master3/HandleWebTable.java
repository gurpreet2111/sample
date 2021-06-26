package com.selenium.master3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleWebTable {
	
	WebDriver driver;
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Framework\\SeleniumProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}

	@Test
	public void manageTable()
	{
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.linkText("Indices")).click();
		
		driver.findElement(By.linkText("Show More >>")).click();
		
		//get row count
		List<WebElement> totalrow = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr"));
		
		System.out.println("Total number of rows are "+totalrow.size());
		
		
		//get col count
		List<WebElement> totalcol = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("Total number of cols are "+totalcol.size());
		
		
		//get thhe data of specific row
		List<WebElement> cols = driver.findElements(By.xpath("//*[@class='dataTable']/tbody/tr[3]/td"));
		System.out.println("****Get the data of 3rd row**********");
		for(WebElement ty : cols)
		{
			System.out.println(ty.getText());
		}
		
		//Get a data of cols
		List<WebElement> columns = driver.findElements(By.xpath("[@class='dataTable']/tbody/tr/td[1]"));
		System.out.println("********Data of first cols*******");
		for (WebElement cl : columns) {
			System.out.println(cl.getText());
			
		}
		//get the data of complete table
		System.out.println("****Data of complete table*****");
		
		for (WebElement r : totalrow) {
			System.out.println(r.getText());
			
		}
	}

}
